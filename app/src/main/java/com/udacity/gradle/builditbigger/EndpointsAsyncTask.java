package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Pair;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.udacity.gradle.builditbigger.backend.myApi.MyApi;
import com.udacity.gradle.builditbigger.backend.myApi.model.MyBean;

import java.io.IOException;

import khairy.com.jokeviewer.JokeViewerActivity;

public class EndpointsAsyncTask extends AsyncTask<EndpointsAsyncTask.OnJokeCallback, Void, String> {
    private MyApi myApiService = null;
    private OnJokeCallback jokecallback;
    private Context context;
    private ProgressBar progressBar;

    public EndpointsAsyncTask(Context context, ProgressBar progressBar) {
        this.context = context;
        this.progressBar = progressBar;
    }




    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        if (progressBar != null) {
            progressBar.setVisibility(View.VISIBLE);
        }
    }

    @Override
    protected String doInBackground(OnJokeCallback... onJokeCallbacks) {
        progressBar.setVisibility(View.VISIBLE);
        if(myApiService == null) {
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    // options for running against local devappserver
                    // - 10.0.2.2 is localhost's IP address in Android emulator
                    // - turn off compression when running against local devappserver
//            "http://10.0.3.2:8080/_ah/api/"
//            "https://gradleproject-207205.appspot.com/_ah/api/"
                    .setRootUrl("http://10.0.3.2:8080/_ah/api/")
                        .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                            @Override
                            public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                                abstractGoogleClientRequest.setDisableGZipContent(true);
                            }
                        });

            myApiService = builder.build();

        }
        jokecallback = onJokeCallbacks[0];

        try {
            return myApiService.sayHi().execute().getData();
        } catch (IOException e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }



    @Override
    protected void onPostExecute(String result) {
        if (jokecallback!=null){
            jokecallback.resultCallback(result);
        }

        progressBar.setVisibility(View.GONE);
    }


    public interface OnJokeCallback {
        void resultCallback(String result);
    }

}