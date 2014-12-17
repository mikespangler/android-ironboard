package com.flatironschool.ironboard.activities;

import android.app.ListActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;

import com.flatironschool.ironboard.R;

import java.util.List;

import models.Schedules;
import services.IronboardService;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class ScheduleActivity extends ListActivity {

    ArrayAdapter<Schedules.Schedule> mScheduleArrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);

        IronboardService service = new IronboardService();

        mScheduleArrayAdapter = new ArrayAdapter<Schedules.Schedule>(this, R.layout.activity_schedule);
        setListAdapter(mScheduleArrayAdapter);

        service.loadSchedules(new Callback<Schedules>() {
            @Override
            public void success(Schedules schedules, Response response) {
                List<Schedules.Schedule> schedulesData = schedules.getData();
                mScheduleArrayAdapter.addAll(schedulesData);
            }

            @Override
            public void failure(RetrofitError error) {
                Log.d("tag", error.getLocalizedMessage());
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.schedule, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
