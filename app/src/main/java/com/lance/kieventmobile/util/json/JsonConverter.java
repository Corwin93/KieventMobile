package com.lance.kieventmobile.util.json;

import com.lance.kieventmobile.model.Category;
import com.lance.kieventmobile.model.Event;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Corwin on 27.05.2015.
 */
public class JsonConverter {
    public List<Event> toJavaObjectOffline(InputStream stream) throws IOException, JSONException {
        List<Event> events = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            sb.append(line).append("\n");
        }
        reader.close();
        String json = sb.toString();
        JSONObject jsonRoot = new JSONObject(json);
        JSONArray jsonArr  = jsonRoot.getJSONArray("events");
        for(int i = 0; i < jsonArr.length(); i++) {
            JSONObject obj = jsonArr.getJSONObject(i);
            Event e = new Event();
            e.setTitle(obj.getString("Title"));
            e.setTime(obj.getString("Time"));
            e.setDate(obj.getString("Date"));
            e.setImage(obj.getString("Image"));
            e.setOrder(obj.getString("Order"));
            e.setAddress(obj.getString("Address"));
            e.setPrice(obj.getString("Price"));
            e.setCategory(Category.ROCK);
            events.add(e);
        }
        return events;
    }

    public List<Event> toJavaObject(String rawJsonString, Category category) throws IOException, JSONException {
        List<Event> events = new ArrayList<>();
        JSONObject jsonRoot = new JSONObject(rawJsonString);
        JSONArray jsonArr  = jsonRoot.getJSONArray("events");
        for(int i = 0; i < jsonArr.length(); i++) {
            JSONObject obj = jsonArr.getJSONObject(i);
            Event e = new Event();
            e.setTitle(obj.getString("Title").trim());
            e.setTime(obj.getString("Time").trim());
            e.setDate(obj.getString("Date").trim());
            e.setImage(obj.getString("Image").trim());
            e.setOrder(obj.getString("Order").trim());
            e.setAddress(obj.getString("Address").trim());
            e.setPrice(obj.getString("Price").trim());
            e.setCategory(category);
            events.add(e);
        }
        return events;
    }
}
