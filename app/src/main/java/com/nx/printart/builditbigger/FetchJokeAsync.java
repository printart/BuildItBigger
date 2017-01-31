package com.nx.printart.builditbigger;

import android.os.AsyncTask;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.nx.printart.builditbigger.myApi.MyApi;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class FetchJokeAsync extends AsyncTask<String, Void, String> {

    private String mJoke;
    private MyApi mMyApiService;

    @Override
    protected String doInBackground(String... params) {
        if (mMyApiService == null) {
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null).setRootUrl("http://10.0.2.2:8080/_ah/api/").
                    setGoogleClientRequestInitializer(request -> request.setDisableGZipContent(true));
            mMyApiService = builder.build();
        }
        try {
            return parseJson(mMyApiService.joke(params[0]).execute().getData());
        } catch (IOException e) {
            return null;
        } catch (JSONException e) {
            return null;
        }
    }

    @Override
    protected void onPostExecute(String data) {
        mJoke = data;
        MainFragment.mJoke = data;
    }

    private String parseJson(String json) throws JSONException {
        JSONObject job1 = new JSONObject(json);
        JSONObject job2 = job1.getJSONObject("value");
        return job2.getString("joke").replace("&quot;", "'");
    }

    public String getJoke() {
        return mJoke;
    }
}
