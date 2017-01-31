package com.example.nx.backend;


import com.example.GetJoke;

public class CreateJoke {
    private String mJoke;

    public String getData() {
        return mJoke;
    }

    public void setData(String joke) {
        try {
            mJoke = GetJoke.fetchData(joke);
        } catch (Exception e) {
            mJoke = "No joke for you";
        }
        //mJoke = joke;
    }
}

