package com.bookmyshow.bookmyshow.services;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Service;

@Service
public class GeoLocationService {

    private static final String API_KEY = "your_ipstack_api_key";
    private static final String API_URL = "http://api.ipstack.com/";

    public static String getCityByIp(String ipAddress) {
        String url = API_URL + ipAddress + "?access_key=" + API_KEY;
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpGet request = new HttpGet(url);
            HttpResponse response = httpClient.execute(request);
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                String result = EntityUtils.toString(entity);
                JSONObject json = new JSONObject(result);
                return json.getString("city");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
