package com.ng.bankly.utils;

import android.os.Build;
import android.util.Log;
import androidx.annotation.RequiresApi;

import com.ng.bankly.TransactionModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class HttpUtils {

    private static final String LOG_TAG = HttpUtils.class.getSimpleName();

    public static String getTransactionInfo(String BASE_URL) {

        HttpURLConnection urlConnection = null;
        BufferedReader reader = null;
        String transactionJSONString = null;

        try {
            

            // Convert the baseUrl to a URL.
            URL requestURL = new URL(BASE_URL);

            // Open the network connection.
            urlConnection = (HttpURLConnection) requestURL.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();

            // Get the InputStream.
            InputStream inputStream = urlConnection.getInputStream();

            // gET a buffered reader from that input stream.
            reader = new BufferedReader(new InputStreamReader(inputStream));

            //Use StringBuilder since it's more efficient than string for concatenation and appending
            StringBuilder builder = new StringBuilder();

            String line;
            while ((line = reader.readLine()) != null) {
                // Add the current line to the string.
                builder.append(line);

                // Since this is JSON, adding a newline is not necessary (it won't
                // affect parsing) but it does make debugging a l easier
                // if you print out the completed buffer for debugging.
                builder.append("\n");
            }

            if (builder.length() == 0) {
                // Stream was empty.  Exit without parsing.
                return null;
            }
            transactionJSONString = builder.toString();

        }
        catch (IOException e) {
            Log.d(LOG_TAG, "Network Error=="+e);
            e.printStackTrace();
        } finally {
            // Close the connection and the buffered reader.
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return transactionJSONString;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public List<TransactionModel> convertToTransactionModel(String data) {
        List<TransactionModel> transactionModelList = new ArrayList<>();
        try {
           
            JSONArray itemsArray = new JSONArray(data);
            
            int i = 0;
            // Look for results in the  array, exiting when i exceeds the array length.
            while (i < itemsArray.length() ) {

                // Get the current transaction information.
                JSONObject transaction = itemsArray.getJSONObject(i);
                //get each transaction object
                try {

                    TransactionModel transactionModel = new TransactionModel(transaction.getString("transactionTypeName"),
                            transaction.getDouble("amount"), LocalDateTime.parse(transaction.get("transactionDate").toString()) ,transaction.getString("statusName"));
                transactionModelList.add(transactionModel);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                i++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return transactionModelList;
    }
}


