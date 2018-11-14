package com.freelance.android.sampleproject.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.freelance.android.sampleproject.R;
import com.freelance.android.sampleproject.bus.BusProvider;
import com.freelance.android.sampleproject.bus.events.SomeEvent;
import com.squareup.otto.Bus;

public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    private Button mEvent;
    private Bus mBus = BusProvider.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(LOG_TAG, "TEST : onCreate() is called()");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mEvent = (Button)this.findViewById(R.id.btnEvent);
        mEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i(LOG_TAG, "TEST : onClick() is called()");

                mBus.post(new SomeEvent("Some String"));
            }
        });
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        Log.i(LOG_TAG, "TEST : onCreateOptionsMenu() is called()");

        //getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Log.i(LOG_TAG, "TEST : onOptionsItemSelected() is called()");

        int id = item.getItemId();
        /*if (id = R.id.action_settings){
            return true;
        }*/
        return super.onOptionsItemSelected(item);
    }
}
