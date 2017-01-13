package xyz.fatahillah.earthquackerapp;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EarthQuakeAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        ArrayList<Earthquake> earthquakesJson = QueryUtils.extractEarthquakes();
        ArrayList<Earthquake> earthquakesJson = QueryUtils.extractEarthquakes(QueryUtils.SAMPLE_JSON_RESPONSE);
//        ArrayList<Earthquake> earthquakesJson = new ArrayList<>();

        //find list view
        ListView earthQuakeListView = (ListView) findViewById(R.id.list);

        // Create a new {@link ArrayAdapter} of earthquakes
        adapter = new EarthQuakeAdapter(this, earthquakesJson);

        // Set the adapter on the {@link ListView}
        // so the list can be populated in the user interface
        earthQuakeListView.setAdapter(adapter);


       /* part2*/

        //set on item click listener
        earthQuakeListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                //mendapatkan data eratquke
                Earthquake currentEarthQuake = adapter.getItem(position);

                //convert String url menjadi URI object
                Uri earthQuakeUri = Uri.parse(currentEarthQuake.getUrl());

                //create new intent untuk membuka halaman website dari eartquake
                Intent websiteIntent = new Intent(Intent.ACTION_VIEW, earthQuakeUri);

                //mengirim intent untuk membuka website
                startActivity(websiteIntent);
            }
        });

//        new DownloadTaskEartQuake().execute();

    }

    public class DownloadTaskEartQuake extends AsyncTask<Void, Void, ArrayList<Earthquake>> {

        @Override
        protected ArrayList<Earthquake> doInBackground(Void... voids) {

            //set up URL
            URL url = QueryUtils.createURL(QueryUtils.USGS_REQUEST_URL);

            //membuat http request ke URL dan menerima response JSON
            String jsonResponse = null;

            jsonResponse = QueryUtils.makeHttoRequest(url);

            // convert respone dalam bentuk jason menjadi array list
            ArrayList<Earthquake> earthQuakes = QueryUtils.extractEarthquakes(jsonResponse);

            //return list
            return earthQuakes;

        }

        @Override
        protected void onPostExecute(ArrayList<Earthquake> earthQuakes) {
            super.onPostExecute(earthQuakes);
            //add eartquake ke list view
            for (int i = 0; i < earthQuakes.size(); i++) {
                adapter.add(earthQuakes.get(i));
            }
        }
    }


}
