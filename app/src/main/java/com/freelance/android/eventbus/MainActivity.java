package com.freelance.android.eventbus;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class MainActivity extends AppCompatActivity {

    private static final String LOT_TAG = MainActivity.class.getName();
    private EditText results;
    private Button click;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(LOT_TAG, "TEST: onCreate() is called...");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EventBus.getDefault().register(this);

        results = this.findViewById(R.id.etMAResult);
        click = this.findViewById(R.id.btnMATrigger);

        listenerOnClick();
    }

    private void listenerOnClick() {
        Log.i(LOT_TAG, "TEST: listenerOnClick() is called...");
        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i(LOT_TAG, "TEST: onClick() is called...");

                Intent i = new Intent(MainActivity.this, ChildActivity.class);
                startActivity(i);
            }
        });
    }

    @Subscribe
    public void onEvent(CustomMessageEvent event){
        Log.i(LOT_TAG, "TEST: onEvent() is called...");
        Log.d(LOT_TAG, "TEST: Event fired. " + event.getCustomMessage());

        results.setText(event.getCustomMessage());
    }
}
