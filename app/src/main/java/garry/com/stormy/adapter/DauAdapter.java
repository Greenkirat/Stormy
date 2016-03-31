package garry.com.stormy.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import garry.com.stormy.R;
import garry.com.stormy.weather.Day;

/**
 * Created by Garry on 1/7/2016.
 */
public class DauAdapter extends BaseAdapter {

    private Context mContext;
    private Day[] mDays;

    public DauAdapter(Context context, Day[] days){
        mContext=context;
        mDays=days;
    }


    @Override
    public int getCount() {
        return mDays.length;
    }

    @Override
    public Object getItem(int position) {
        return mDays[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;//we aren't using it . These are used for tags items for easy references

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;

        if(convertView==null)//brand new
        {
            convertView= LayoutInflater.from(mContext).inflate(R.layout.daily_item_list,null);


        holder=new ViewHolder();
            holder.iconImageView=(ImageView)convertView.findViewById(R.id.iconImageView);
            holder.temperatureLabel=(TextView)convertView.findViewById(R.id.temperatureLabel);
            holder.DayLabel=(TextView)convertView.findViewById(R.id.dayNameLabel);

            convertView.setTag(holder);

        }

        else{

            holder=(ViewHolder)convertView.getTag();
        }
Day day=   mDays[position];
        holder.iconImageView.setImageResource(day.getIconId());
        holder.temperatureLabel.setText(day.getTemperatureMax()+"");
        holder.DayLabel.setText(day.getDaysofTheWeek());


        return convertView;
    }


    private  static class ViewHolder{

        ImageView iconImageView;//public by default
        TextView   temperatureLabel;
        TextView   DayLabel;

    }

}
