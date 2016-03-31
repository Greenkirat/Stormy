package garry.com.stormy.ui;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import java.text.FieldPosition;
import java.util.Arrays;

import garry.com.stormy.R;
import garry.com.stormy.adapter.DauAdapter;
import garry.com.stormy.weather.Day;

public class DailyForecastActivity extends ListActivity {



    private Day[] mDays;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_forecast);
        Intent intent = getIntent();
        Parcelable[] parcelables = intent.getParcelableArrayExtra(MainActivity.Daily_Forecast);
        mDays = Arrays.copyOf(parcelables, parcelables.length, Day[].class);

        DauAdapter adapter = new DauAdapter(this, mDays);
        setListAdapter(adapter);

    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        String dayOfTheWeek=mDays[position].getDaysofTheWeek();
        String highTemp=mDays[position].getTemperatureMax()+"";
        String conditions=mDays[position].getSummary();

    String message=String.format("On %s the temperature  will be %s nad it will be %s ",
                   dayOfTheWeek,
                     highTemp,
                     conditions);
        Toast.makeText(this, message,Toast.LENGTH_LONG).show();




    }
}


