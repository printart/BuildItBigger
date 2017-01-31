package com.nx.printart.builditbigger;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.nx.printart.androidlib.ShowDataActivity;


public class MainFragment extends Fragment {
    public static final String TAG = "MainFragment";
    //jokes fetched from http://www.icndb.com
    //for api http://www.icndb.com/api/
    //rated PG??
    private static final String baseUrlDefault = "http://api.icndb.com/jokes/random";
    public static String mJoke;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        Button getJokeButton = (Button) view.findViewById(R.id.get_joke_button);

        //call android library to show a joke
        getJokeButton.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), ShowDataActivity.class);
            intent.putExtra("joke_data", mJoke);
            startActivity(intent);
        });

        /*AdView mAdView = (AdView) view.findViewById(R.id.adView);
        // Create an ad request. Check logcat output for the hashed device ID to
        // get test ads on a physical device. e.g.
        // "Use AdRequest.Builder.addTestDevice("ABCDEF012345") to get test ads on this device."
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        mAdView.loadAd(adRequest);*/

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        new FetchJokeAsync().execute(baseUrlDefault);
    }
}
