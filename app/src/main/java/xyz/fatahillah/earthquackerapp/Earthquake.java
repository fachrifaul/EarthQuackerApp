package xyz.fatahillah.earthquackerapp;

public class Earthquake {

    //magnitude
    private double mMagnitude;

    //location
    private String mLocation;

    //date
    private String mDate;

    //date
    private long mTimeMilliseconds;

    //url website
    private String mUrl;

//    public Earthquake(double magnitude, String location, String date) {
//        mMagnitude = magnitude;
//        mLocation = location;
//        mDate = date;
//    }
//
//    public Earthquake(double magnitude, String location, long timeMilliseconds) {
//        mMagnitude = magnitude;
//        mLocation = location;
//        mTimeMilliseconds = timeMilliseconds;
//    }


    //contuctor
    public Earthquake(double magnitude, String location, long TImeMillisecond, String url) {
        mMagnitude = magnitude;
        mLocation = location;
        mTimeMilliseconds = TImeMillisecond;
        mUrl = url;
    }

    //getter url
    public String getUrl() {
        return mUrl;
    }

    //setter url
    public void setUrl(String url) {
        mUrl = url;
    }

    public double getMagnitude() {
        return mMagnitude;
    }

    public void setMagnitude(double magnitude) {
        mMagnitude = magnitude;
    }

    public String getLocation() {
        return mLocation;
    }

    public void setLocation(String location) {
        mLocation = location;
    }

    public String getDate() {
        return mDate;
    }

    public void setDate(String date) {
        mDate = date;
    }

    public long getTimeMilliseconds() {
        return mTimeMilliseconds;
    }

    public void setTimeMilliseconds(long timeMilliseconds) {
        mTimeMilliseconds = timeMilliseconds;
    }
}