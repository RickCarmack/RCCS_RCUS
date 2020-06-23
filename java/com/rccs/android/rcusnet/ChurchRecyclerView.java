package com.rccs.android.rcusnet;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class ChurchRecyclerView extends AppCompatActivity {

    // ArrayList for person names, email Id's and mobile numbers
    ArrayList<String> church = new ArrayList<>();
    ArrayList<String> city = new ArrayList<>();
    ArrayList<String> state = new ArrayList<>();
    ArrayList<String> classis = new ArrayList<>();
    ArrayList<String> address = new ArrayList<>();
    ArrayList<String> phone  = new ArrayList<>();
    ArrayList<String> pastor = new ArrayList<>();
    ArrayList<String> email = new ArrayList<>();
    ArrayList<String> web = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_congregations);
        // get the reference of RecyclerView
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        // set a LinearLayoutManager with default vertical orientation
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);

        try {
            // get JSONObject from JSON file
            JSONObject obj = new JSONObject(loadJSONFromAsset());
            // fetch JSONArray named users
            JSONArray churchArray = obj.getJSONArray("churches");
            // implement for loop for getting church list data
            for (int i = 0; i < churchArray.length(); i++) {
                // create a JSONObject for fetching single user data
                JSONObject churchDetail = churchArray.getJSONObject(i);
                church.add(churchDetail.getString("name"));
                city.add(churchDetail.getString("city"));
                state.add(churchDetail.getString("state"));
                classis.add(churchDetail.getString("classis"));
                address.add(churchDetail.getString("address"));
                phone.add(churchDetail.getString("phone"));
                pastor.add(churchDetail.getString("pastor"));
                email.add(churchDetail.getString("email"));
                web.add(churchDetail.getString("web"));
                // create a object for getting contact data from JSONObject
                            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        //  call the constructor of CustomAdapter to send the reference and data to Adapter
        CustomAdapter customAdapter = new CustomAdapter(ChurchRecyclerView.this, church, city, state, classis, address, phone, pastor, email, web);
        recyclerView.setAdapter(customAdapter); // set the Adapter to RecyclerView
    }

    public String loadJSONFromAsset() {
        String json = null;
        try {
            InputStream is = getAssets().open("congregations.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }
}
