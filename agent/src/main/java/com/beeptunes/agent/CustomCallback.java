package com.beeptunes.agent;

import android.util.Log;

import com.beeptunes.agent.Models.Error;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public abstract class CustomCallback<T> implements Callback<T> {

    int retryLimit;
    protected int statusCode = 0;
    Gson gson = new GsonBuilder().create();
    protected Error error;

    private final String TAG = this.getClass().getSimpleName();

    public CustomCallback(int retryLimit) {
        this.retryLimit = retryLimit;
    }

    public CustomCallback() {
        this.retryLimit = 0;
    }

    @Override
    public void onFailure (Call<T> call, Throwable t) {
        Log.d(TAG, "onFailure: ".concat(call.request().url().toString()));
        if (retryLimit != 0){
            try {
                retryLimit--;
                onResponse(call, call.clone().execute());
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }

    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        Log.d(TAG, "onResponse: ".concat(response.toString()));
        statusCode = response.code();
        if(response.code() >= 400) { //Error
            try {
                assert response.errorBody() != null;
                error = gson.fromJson(response.errorBody().string(), Error.class);
                onFailure(call, new Throwable(response.errorBody().string()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
