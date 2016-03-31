package garry.com.stormy.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import butterknife.ButterKnife;
import butterknife.InjectView;
import garry.com.stormy.R;
import garry.com.stormy.weather.Hour;

/**
 * Created by Garry on 1/11/2016.
 */
public class HourAdapter extends RecyclerView.Adapter<HourAdapter.HourViewHolder>  {

    private Context mContext;

    private Hour[] mHours;
    public HourAdapter( Context contexts,Hour[] hour)
    {
           mContext=contexts;
        mHours=hour;
    }
    @Override
    public HourViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.hourly_list_item, viewGroup,false);
        HourViewHolder viewHolder=new HourViewHolder(view);
        return     viewHolder;


    }

    @Override
    public void onBindViewHolder(HourViewHolder hourViewwHolder, int i) {
   hourViewwHolder.bindHour(mHours[i]);
    }

    @Override
    public int getItemCount() {
        return mHours.length;
    }




    public  class HourViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public TextView mTemperatureLabel;
        public ImageView mIcon;
        public TextView mSummaryLabel;
        public TextView mTimeLabel;



    /* @InjectView(R.id.timeLabel)TextView mTimeLabel;
        @InjectView(R.id.temperatureLabel)TextView mTemperatureLabel;
        @InjectView(R.id.summaryLabel )TextView mSummaryLabel;
        @InjectView(R.id.iconImageView)ImageView mIcon;
*/




        public HourViewHolder(View itemView) {
            super(itemView);
            mTimeLabel= (TextView)itemView.findViewById(R.id.timeLabel);
            mTemperatureLabel=(TextView)itemView.findViewById(R.id.temperatureLabel);
            mSummaryLabel=(TextView)itemView.findViewById(R.id.summaryLabel);
            mIcon=(ImageView)itemView.findViewById(R.id.iconImageView);
                 // ButterKnife.inject(this,itemView);
            itemView.setOnClickListener(this);

        }

        public void bindHour (Hour hour){

      mTimeLabel.setText(hour.getHour());
            mTemperatureLabel.setText(hour.getTemperature()+"");
            mSummaryLabel.setText(hour.getSummary());
            mIcon.setImageResource(hour.getIconId());

        }
        public void onClick(View v) {

            String TIME= mTimeLabel.getText().toString();
            String temperature= mTemperatureLabel.getText().toString();
            String summary=mSummaryLabel.getText().toString();
            String message=String.format("At %s it will be %s and %s",
                    TIME,
                    temperature,
                    summary );
            Toast.makeText(mContext , message, Toast.LENGTH_LONG).show();
        }
    }
}
