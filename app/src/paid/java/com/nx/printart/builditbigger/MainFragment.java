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

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        new FetchJokeAsync().execute(baseUrlDefault);
    }
}
