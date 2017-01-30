package com.nx.printart.builditbigger;

import android.os.AsyncTask;
import android.util.Log;

public class FetchJokeAsync extends AsyncTask<String, Void, String> {

    private static final String TAG = "FetchJokeAsync";

    @Override
    protected String doInBackground(String... params) {
        try {
            return NetworkCall.fetchData(params[0]);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    protected void onPostExecute(String data) {
        Log.i(TAG, "onPostExecute: res:" + data);
    }
}
