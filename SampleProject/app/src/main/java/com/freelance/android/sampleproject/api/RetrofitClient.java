package com.freelance.android.sampleproject.api;

import retrofit2.RestAdapter;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Kyaw Khine on 07/04/2018.
 */

public class RetrofitClient {

    private static final String API_URL = "";
    private static RetrofitClient mRetrofitClient;
    private static RestAdapter mAsyncRestAdapter;

    public static RetrofitClient getInstance() {

        if (mRetrofitClient == null)
            mRetrofitClient = new RetrofitClient();
        return mRetrofitClient;
    }

    private RetrofitClient() {
        mAsyncRestAdapter = new RestAdapter.Builder()
                .setEndpoint(API_URL)
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .build();
    }
}
