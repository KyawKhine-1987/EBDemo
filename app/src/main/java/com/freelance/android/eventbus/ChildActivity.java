package com.freelance.android.eventbus;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.greenrobot.eventbus.EventBus;

public class ChildActivity extends AppCompatActivity {

    private static final String LOT_TAG = ChildActivity.class.getName();
    private EditText results;
    private Button click;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(LOT_TAG, "TEST: onCreate() is called...");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child);
        Toolbar toolbar = this.findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = this.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        results = this.findViewById(R.id.etResult);
        click = this.findViewById(R.id.btnTrigger);

        listenerOnClick();
    }

    private void listenerOnClick() {
        Log.i(LOT_TAG, "TEST: listenerOnClick() is called...");
        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i(LOT_TAG, "TEST: onClick() is called...");

                String inputText = results.getText().toString();

                CustomMessageEvent mEvent = new CustomMessageEvent();
                mEvent.setCustomMessage(inputText);
                EventBus.getDefault().post(mEvent);

                finish();
            }
        });
    }
}
