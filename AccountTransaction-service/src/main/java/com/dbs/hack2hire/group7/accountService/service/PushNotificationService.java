package com.dbs.hack2hire.group7.accountService.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import org.slf4j.Logger;
/*
import org.json.JSONException;
import org.json.JSONObject;*/
import org.slf4j.LoggerFactory;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Service;

@Service
public class PushNotificationService {
	 private static final Logger log = (Logger) LoggerFactory.getLogger(PushNotificationService.class);

	    private static final String FIREBASE_API_URL = "https://fcm.googleapis.com/fcm/send";
	    private static  String FIREBASE_SERVER_KEY = "AAAAs7dWwbg:APA91bGAvvOyfILmSjYlczZ0nUTwzLYsOaDhEWYRWe8hBwTEzPvwJOTAkClGxL2LAzEmmFAeipOD8Z8SIDJ4oesniuZj7NAwJyGG910QoZ_maLCTvAOnWSXIGl5dJlJFD2Cbttg_Hos0";

	    public static String sendPushNotification(String deviceToken, String Message, String Message1) throws IOException {

	        String result = "";
	        URL url = new URL(FIREBASE_API_URL);
	        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

	        conn.setUseCaches(false);
	        conn.setDoInput(true);
	        conn.setDoOutput(true);

	        conn.setRequestMethod("POST");
	        conn.setRequestProperty("Authorization", "key=" + FIREBASE_SERVER_KEY);
	        conn.setRequestProperty("Content-Type", "application/json");

	        JSONObject json = new JSONObject();

	        try {

	            json.put("to", deviceToken.trim());
	            //json.put("collapse_key", "type_a");
	            //json.put("notification","Redemption Points");

	            JSONObject data = new JSONObject();
	           // data.put("title", "DBS Redemption Jack Points");
	            data.put("body", "Welcome to Jack Point!");
	            //data.put("Key-1", Message);
	            //data.put("Key-2", Message1);
	            json.put("data", data);


	            /*JSONObject info = new JSONObject();
	            info.put("title", "DBS Redemption Jack Points");
	            info.put("body", "Welcome to Jack Point!");
	            info.put("message", "hello user");
	            json.put("notification", info);*/

	        } catch (JSONException e1) {
	            e1.printStackTrace();
	        }

	        try {
	            OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
	            wr.write(json.toString());
	            wr.flush();

	            BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

	            String output;

	            while ((output = br.readLine()) != null) {
	                log.error(output);
	            }
	            result = "succcess";
	        } catch (Exception e) {
	            e.printStackTrace();
	            result = "failure";
	        }

	        return result;

	    }
}
