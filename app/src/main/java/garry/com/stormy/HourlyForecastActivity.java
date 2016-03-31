package garry.com.stormy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import java.util.Arrays;

import butterknife.ButterKnife;
import butterknife.InjectView;
import garry.com.stormy.R;
import garry.com.stormy.adapter.HourAdapter;
import garry.com.stormy.ui.MainActivity;
import garry.com.stormy.weather.Day;
import garry.com.stormy.weather.Hour;

public class HourlyForecastActivity extends Activity {

    private Hour mHour[];

    @InjectView(R.id.recyclerView)
    RecyclerView mRecyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hourly_forecast);
        ButterKnife.inject(this);
        Intent intent =getIntent();
        Parcelable[] parcelables=intent.getParcelableArrayExtra(MainActivity.Hourly_Forecast);
        mHour = Arrays.copyOf(parcelables,parcelables.length,Hour[].class);

        HourAdapter  adapter= new HourAdapter( this, mHour);
        mRecyclerView.setAdapter(adapter);

        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);

        mRecyclerView.setHasFixedSize(true);



    }




}
