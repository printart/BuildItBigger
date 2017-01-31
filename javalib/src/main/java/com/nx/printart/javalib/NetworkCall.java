package com.nx.printart.javalib;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class NetworkCall {
    public static String fetchData(String baseUrl) throws Exception {
        HttpURLConnection connection = null;
        StringBuilder stringBuilder = new StringBuilder();
        try {
            URL url = new URL(baseUrl);
            connection = (HttpURLConnection) url.openConnection();
            //check connection
            if (connection.getResponseCode() != 200) {
                throw new Exception("Server says no joke for you! responseCode:" + connection.getResponseCode());
            }
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
        return stringBuilder.toString();
    }
}
