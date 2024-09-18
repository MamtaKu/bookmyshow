package com.bookmyshow.bookmyshow.services;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

@Service
public class IpGeolocationService {

    private static final String API_KEY = "76570f55b9d5cba2ac118af4112638da\n";
    private static final String IPSTACK_API_URL = "http://api.ipstack.com/";



    public static String getCityFromIp(String ipAddress) throws Exception {
        String urlString = IPSTACK_API_URL + ipAddress + "?access_key=" + API_KEY;
        URL url = new URL(urlString);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8));
        String inputLine;
        StringBuilder response = new StringBuilder();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        return parseCityFromResponse(response.toString());
    }

    private static String parseCityFromResponse(String response) {

        String city = null;

        if (response.contains("\"city\"")) {
            int cityIndex = response.indexOf("\"city\"");
            int startIndex = response.indexOf("\"", cityIndex + 7) + 1;
            int endIndex = response.indexOf("\"", startIndex);
            city = response.substring(startIndex, endIndex);
        }



        return city;
    }

    public String getCityByIp(String ipAddress, String accessKey) throws IOException {
        String urlString = IPSTACK_API_URL + ipAddress + "?access_key=" + API_KEY;
        URL url = new URL(urlString);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8));
        String inputLine;
        StringBuilder response = new StringBuilder();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        return parseCityFromResponse(response.toString());

    }
}
