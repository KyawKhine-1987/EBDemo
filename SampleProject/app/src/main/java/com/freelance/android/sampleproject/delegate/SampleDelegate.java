package com.freelance.android.sampleproject.delegate;

import android.content.Context;
import android.util.Log;

import com.freelance.android.sampleproject.bus.events.SomeEvent;
import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;

public class SampleDelegate {

    private static final String LOG_TAG = SampleDelegate.class.getSimpleName();

    private Context mContext;
    private Bus mBus;

    public SampleDelegate(Context context, Bus bus) {
        Log.i(LOG_TAG, "TEST : SampleDelegate() constructor is called");

        this.mContext = context;
        this.mBus = bus;
    }

    @Subscribe
    public void onSomeEvent(SomeEvent someEvent){
        Log.i(LOG_TAG, "TEST : onSomeEvent() is called");

        //Do all the processing inside this method.
        Log.d(LOG_TAG, someEvent.getmSomeString());
    }
}
