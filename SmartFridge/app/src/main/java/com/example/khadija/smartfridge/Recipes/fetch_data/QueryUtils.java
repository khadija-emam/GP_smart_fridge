package com.example.khadija.smartfridge.Recipes.fetch_data;

/**
 * Created by Elesdody on 24-Mar-18.
 */

import android.text.TextUtils;
import android.util.Log;

import com.example.khadija.smartfridge.Recipes.RecipesClass;
import com.example.khadija.smartfridge.RecipesDetails.Description;
import com.example.khadija.smartfridge.RecipesDetails.IngredientsAdapter;
import com.example.khadija.smartfridge.RecipesDetails.IngredientsClass;
import com.example.khadija.smartfridge.RecipesDetails.StepsClass;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;


/**
 * Helper methods related to requesting and receiving earthquake data from USGS.
 */

public class QueryUtils {


    private static final String LOG_TAG = QueryUtils.class.getName();

    /**
     * Create a private constructor because no one should ever create a {@link QueryUtils} object.
     * This class is only meant to hold static variables and methods, which can be accessed
     * directly from the class name QueryUtils (and an object instance of QueryUtils is not needed).
     */
    private QueryUtils() {
    }


    /**
     * Query the api dataset and return a list of recipes objects.
     */
    public static List<RecipesClass> featchRecipiesData(String Requesturl) {

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Log.i(LOG_TAG, "fetchRecipesData called");
        // Create URL object
        URL url = createUrl(Requesturl);
        // Perform HTTP request to the URL and receive a JSON response back
        String jsonResponse = null;
        try {
            jsonResponse = makeHttpRequest(url);
        } catch (IOException e) {
            Log.e(LOG_TAG, "Error closing input stream", e);
        }
        // Extract relevant fields from the JSON response and create a list of {@link Earthquake}s
        List<RecipesClass> RecipesData = extractEarthquakes(jsonResponse);
        // Return the list of {@link Earthquake}s
        return RecipesData;

    }

    /**
     * Returns new URL object from the given string URL.
     */
    private static URL createUrl(String stringUrl) {
        URL url = null;
        try {
            url = new URL(stringUrl);
        } catch (MalformedURLException e) {
            Log.e(LOG_TAG, "Error with creating URL ", e);
        }
        return url;

    }

    /**
     * Make an HTTP request to the given URL and return a String as the response.
     */
    private static String makeHttpRequest(URL url) throws IOException {
        String jsonResponse = "";
        // If the URL is null, then return early.
        if (url == null)
            return jsonResponse;
        HttpURLConnection urlConnection = null;
        InputStream inputStream = null;
        try {


            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setConnectTimeout(10000);
            urlConnection.setReadTimeout(15000);
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();
            // If the request was successful (response code 200),
            // then read the input stream and parse the response.
            if (urlConnection.getResponseCode() == 200) {
                inputStream = urlConnection.getInputStream();
                jsonResponse = readFromStream(inputStream);

            } else
                Log.e(LOG_TAG, "Error Response Code " + urlConnection.getResponseCode());

        } catch (Exception e) {
            Log.e(LOG_TAG, "Problem reciving earthquake jsonResponse result", e);
        } finally {
            if (urlConnection != null)
                urlConnection.disconnect();
            if (inputStream != null)
                // Closing the input stream could throw an IOException, which is why
                // the makeHttpRequest(URL url) method signature specifies than an IOException
                // could be thrown.
                inputStream.close();


        }
        return jsonResponse;


    }

    /**
     * Convert the {@link InputStream} into a String which contains the
     * whole JSON response from the server.
     */
    private static String readFromStream(InputStream inputStream) throws IOException {

        StringBuilder output = new StringBuilder();
        if (inputStream != null) {
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, Charset.forName("UTF-8"));
            BufferedReader reader = new BufferedReader(inputStreamReader);
            String line = reader.readLine();
            while (line != null) {
                output.append(line);
                line = reader.readLine();


            }
        }

        return output.toString();
    }

    /**
     * Return a list of recipes objects that has been built up from
     * parsing the given JSON response.
     */
    private static List<RecipesClass> extractEarthquakes(String jsonResponse) {
        if (TextUtils.isEmpty(jsonResponse))
            return null;
        // Create an empty ArrayList that we can start adding recipes to
        ArrayList<RecipesClass> recipesItems = new ArrayList<>();

        // Try to parse the SAMPLE_JSON_RESPONSE. If there's a problem with the way the JSON
        // is formatted, a JSONException exception object will be thrown.
        // Catch the exception so the app doesn't crash, and print the error message to the logs.
        try {

            // TODO: Parse the response given by the SAMPLE_JSON_RESPONSE string and
            // build up a list of Earthquake objects with the corresponding data.

            JSONObject Root = new JSONObject(jsonResponse);
            // Getting JSON Array node
            JSONArray features = Root.getJSONArray("recipes");
            for (int i = 0; i < features.length(); i++) {
                JSONObject object = features.getJSONObject(i);
                // Extract the value for the key called "mag"
                String name = object.getString("name");
                String image = object.getString("image");
                JSONArray ingredients = object.getJSONArray("ingredients");
                ArrayList<IngredientsClass> IngredientsArray = new ArrayList<>();

                for (int j = 0; j < ingredients.length(); j++) {
                    JSONObject Ingredient = ingredients.getJSONObject(j);
                    String IngredientName = Ingredient.getString("food");
                    int IngredientItem = Ingredient.getInt("count");
                    IngredientsArray.add(new IngredientsClass(IngredientName, IngredientItem));
                }
                ArrayList<String> steps = (ArrayList<String>) object.get("steps");
                ArrayList<StepsClass> StepsArray = new ArrayList<>();
                for (int h = 0; h < steps.size(); h++) {

                    StepsArray.add(new StepsClass(h + 1, steps.get(h)));
                }
                int cal =object.getInt("calories");
                ArrayList<String> goodFor = (ArrayList<String>) object.get("good_for");
                ArrayList<String> goodArray = new ArrayList<>();
                for (int h = 0; h < goodArray.size(); h++) {

                    goodArray.add(goodFor.get(h));
                }
                ArrayList<String> badFor = (ArrayList<String>) object.get("bad_for");
                ArrayList<String> badArray = new ArrayList<>();
                for (int h = 0; h < badArray.size(); h++) {

                    badArray.add(badFor.get(h));
                }



                        recipesItems.add(new RecipesClass(name, image, IngredientsArray, StepsArray, cal, goodFor,badFor));


            }
            return recipesItems;

        } catch (JSONException e) {
            // If an error is thrown when executing any of the above statements in the "try" block,
            // catch the exception here, so the app doesn't crash. Print a log message
            // with the message from the exception.
            Log.e("QueryUtils", "Problem parsing the recipes JSON results", e);
        }

        // Return the list of earthquakes
        return recipesItems;


    }
}
