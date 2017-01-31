package com.nx.printart.backend;


import com.nx.printart.javalib.NetworkCall;

public class CreateJoke {
    private String mJoke;

    public String getData() {
        return mJoke;
    }

    public void setData(String joke) {
        try {
            mJoke = NetworkCall.fetchData(joke);
        } catch (Exception e) {
            mJoke = "No joke for you";
        }
    }
}
