package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.udacity.gradle.builditbigger.backend.myApi.MyApi;
import com.wolasoft.viewslibrary.JokeActivity;

import java.io.IOException;

class EndpointsAsyncTask extends AsyncTask<Context, Void, String> {
    private MyApi myApiService = null;
    public static Context context;

    @Override
    protected String doInBackground(Context... params) {
        context = params[0];
        if(myApiService == null) {
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    .setRootUrl("http://192.168.0.11:8080/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });
            myApiService = builder.build();
        }

        try {
            return myApiService.sayJoke().execute().getData();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String joke) {
        Intent jokeIntent = new Intent(context, JokeActivity.class);
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            jokeIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        }
        jokeIntent.putExtra(JokeActivity.KEY_JOKE, joke);
        context.startActivity(jokeIntent);
    }
}
