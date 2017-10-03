package com.dev.streamify;

import android.text.TextUtils;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Devesh Chaturvedi on 002-02-10-2017.
 */

public class DataLoader {


    public DataLoader() {

    }

    public static List<Episodes> extractEpisodesFromJson(String dataJSON, String folderId) {
        // If the JSON string is empty or null, then return early.
        if (TextUtils.isEmpty(dataJSON)) {
            return null;
        }
        // Create an empty ArrayList that we can start adding earthquakes to
        List<Episodes> episodes = new ArrayList<>();

        // Try to parse the SAMPLE_JSON_RESPONSE. If there's a problem with the way the JSON
        // is formatted, a JSONException exception object will be thrown.
        // Catch the exception so the app doesn't crash, and print the error message to the logs.
        try {

            // Create a JSONObject from the JSON response string
            JSONObject response = new JSONObject(dataJSON);
            JSONObject baseJsonResponse = response.getJSONObject("result");


            //   if(baseJsonResponse.getString("status")=="ok") {

            // Extract the JSONArray associated with the key called "features",
            // which represents a list of features (or earthquakes).
            JSONArray episodeArray = baseJsonResponse.getJSONArray("files");
            episodeArray = sort(episodeArray);

            // For each earthquake in the earthquakeArray, create an {@link Earthquake} object
            for (int i = 0; i < episodeArray.length(); i++) {

                // Get a single earthquake at position i within the list of earthquakes
                JSONObject currentEpisode = episodeArray.getJSONObject(i);

                // For a given earthquake, extract the JSONObject associated with the
                // key called "properties", which represents a list of all properties
                // for that earthquake.

                // Extract the value for the key called "mag"
                String name = currentEpisode.getString("name");

                // Extract the value for the key called "url"
                String url = "https://openload.co/embed/" + currentEpisode.getString("linkextid");

                String id = currentEpisode.getString("folderid");

                if (folderId.equals(id)) {


                    // Create a new {@link Earthquake} object with the magnitude, location, time,
                    // and url from the JSON response.
                    Episodes episode1 = new Episodes(name, url);

                    // Add the new {@link Earthquake} to the list of earthquakes.
                    episodes.add(episode1);
                }
            }
            //   }

        } catch (JSONException e) {
            // If an error is thrown when executing any of the above statements in the "try" block,
            // catch the exception here, so the app doesn't crash. Print a log message
            // with the message from the exception.
            Log.e("QueryUtils", "Problem parsing the JSON results", e);
        }

        // Return the list of earthquakes
        return episodes;
    }

    public static List<Serial> extractSeasonsFromJson(String dataJSON) {
        // If the JSON string is empty or null, then return early.
        if (TextUtils.isEmpty(dataJSON)) {
            return null;
        }
        // Create an empty ArrayList that we can start adding earthquakes to
        List<Serial> serials = new ArrayList<>();

        // Try to parse the SAMPLE_JSON_RESPONSE. If there's a problem with the way the JSON
        // is formatted, a JSONException exception object will be thrown.
        // Catch the exception so the app doesn't crash, and print the error message to the logs.
        try {

            // Create a JSONObject from the JSON response string
            JSONObject response = new JSONObject(dataJSON);
            JSONObject baseJsonResponse = response.getJSONObject("result");

            //   if(baseJsonResponse.getString("status")=="ok") {

            // Extract the JSONArray associated with the key called "features",
            // which represents a list of features (or earthquakes).
            JSONArray seasonArray = baseJsonResponse.getJSONArray("folders");

            seasonArray = sort(seasonArray);


            // For each earthquake in the earthquakeArray, create an {@link Earthquake} object
            for (int i = 0; i < seasonArray.length(); i++) {

                // Get a single earthquake at position i within the list of earthquakes
                JSONObject currentEpisode = seasonArray.getJSONObject(i);

                // For a given earthquake, extract the JSONObject associated with the
                // key called "properties", which represents a list of all properties
                // for that earthquake.

                // Extract the value for the key called "mag"
                String name = currentEpisode.getString("name");
                Log.e("Serial Name:", name);

                // Extract the value for the key called "url"
                String id = currentEpisode.getString("id");
                Log.e("Serial id", id);

                int photoId = currentEpisode.getInt("image");


                // Create a new {@link Earthquake} object with the magnitude, location, time,
                // and url from the JSON response.
                Serial serial1 = new Serial(name, id, photoId);

                // Add the new {@link Earthquake} to the list of earthquakes.
                serials.add(serial1);
            }
            //   }

        } catch (JSONException e) {
            // If an error is thrown when executing any of the above statements in the "try" block,
            // catch the exception here, so the app doesn't crash. Print a log message
            // with the message from the exception.
            Log.e("QueryUtils", "Problem parsing the JSON results", e);
        }

        // Return the list of earthquakes
        return serials;
    }

    public static JSONArray sort(JSONArray jsonArray) {
        JSONArray sortedJsonArray = new JSONArray();
        List<JSONObject> jsonList = new ArrayList<JSONObject>();
        for (int i = 0; i < jsonArray.length(); i++) {
            try {

                jsonList.add(jsonArray.getJSONObject(i));
            } catch (JSONException e) {
            }
        }

        Collections.sort(jsonList, new Comparator<JSONObject>() {

            public int compare(JSONObject a, JSONObject b) {
                String valA = new String();
                String valB = new String();

                try {
                    valA = (String) a.get("name");
                    valB = (String) b.get("name");
                } catch (JSONException e) {
                    //do something
                }

                return valA.compareTo(valB);
            }
        });
        for (int i = 0; i < jsonArray.length(); i++) {
            sortedJsonArray.put(jsonList.get(i));
        }
        return sortedJsonArray;
    }
}


