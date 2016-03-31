package garry.com.stormy.weather;

import android.os.Parcel;
import android.os.Parcelable;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by Garry on 12/29/2015.
 */
public class Day implements Parcelable {

    private String mIcon;
    private long mTime;
    private double mTemperatureMax;
    private String mSummary;
    private String mTimeZone;


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

    public int getTemperatureMax() {

        return (int)Math.round(mTemperatureMax);
    }

    public void setTemperatureMax(double temperatureMax) {
        mTemperatureMax = temperatureMax;
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

        return Forecast.getIconId(mIcon);
    }
 public  String getDaysofTheWeek(){
     SimpleDateFormat formatter= new SimpleDateFormat("EEEE");
     formatter.setTimeZone(TimeZone.getTimeZone(mTimeZone));
     Date dayTime= new Date(mTime*1000);

     return  formatter.format(dayTime);

 }

    @Override
    public int describeContents() {
        return 0;//not using now
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
     dest.writeString(mIcon);
        dest.writeLong(mTime);
        dest.writeDouble(mTemperatureMax);
        dest.writeString(mSummary);
        dest.writeString(mTimeZone);

    }
    private Day (Parcel in){

        mIcon=in.readString();
        mTime=in.readLong();
        mTemperatureMax=in.readDouble();
        mSummary=in.readString();
        mTimeZone=in.readString();
    }
    public Day(){

    }
    public static final Creator<Day> CREATOR= new Creator<Day>() {
        @Override
        public Day createFromParcel(Parcel source) {
            return new Day(source);
        }

        @Override
        public Day[] newArray(int size) {
            return new Day[size];
        }
    };
}
