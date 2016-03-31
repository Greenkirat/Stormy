package garry.com.stormy.weather;

import android.os.Parcel;
import android.os.Parcelable;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by Garry on 12/29/2015.
 */
public class Hour implements Parcelable {


    private String mIcon;

    private long mTime;
    private double mTemperature;
    private String mSummary;
    private String mTimeZone;

    public Hour(){}

    public String getIcon() {
        return mIcon;
    }

    public void setIcon(String icon) {
        mIcon = icon;
    }

    public long getTime() {
        return mTime;
    }

    public void setTime(long time) {
        mTime = time;
    }

    public int getTemperature() {
        return (int) Math.round(mTemperature);
    }

    public void setTemperature(double temperature) {
        mTemperature = temperature;
    }

    public String getSummary() {
        return mSummary;
    }

    public void setSummary(String summary) {
        mSummary = summary;
    }

    public String getTimeZone() {
        return mTimeZone;
    }

    public void setTimeZone(String timeZone) {
        mTimeZone = timeZone;
    }


    public int getIconId(){

        return  Forecast.getIconId(mIcon);
    }
public  String getHour(){
    SimpleDateFormat formatter=new SimpleDateFormat("h a");
    formatter.setTimeZone(TimeZone.getTimeZone(mTimeZone));
    Date time=new Date(mTime*1000);
    return formatter.format(time);
}

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
         dest.writeString(mIcon);
        dest.writeDouble(mTemperature);
        dest.writeLong(mTime);
        dest.writeString(mSummary);
        dest.writeString(mTimeZone);
    }

    private Hour(Parcel in){
        mIcon=in.readString();
        mTemperature=in.readDouble();
        mTime=in.readLong();
        mSummary=in.readString();
        mTimeZone=in.readString();
    }
 public static final Creator<Hour> CREATOR= new Creator<Hour>() {
     @Override
     public Hour createFromParcel(Parcel source) {
         return new Hour(source);
     }

     @Override
     public Hour[] newArray(int size) {
         return new Hour[size];
     }
 };
}