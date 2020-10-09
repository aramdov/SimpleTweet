package com.codepath.apps.restclienttemplate.models;

import com.codepath.apps.restclienttemplate.TimeFormatter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Tweet {

    public String body;
    public String createdAt;
    public User user;
    public long id;

    public static Tweet fromJson(JSONObject jsonObject) throws JSONException {
        Tweet tweet = new Tweet();
        tweet.body = jsonObject.getString("text");

        //createdAt = jsonObject.getString("created_ad");
        tweet.createdAt = TimeFormatter.getTimeDifference(jsonObject.getString("created_at"));

        tweet.id = jsonObject.getLong("id");
        tweet.user = User.fromJson(jsonObject.getJSONObject("user")); // takes in json object and returns user model by using User.fromjson method
        return tweet;
    }

//    public void getFormattedTimestamp() {
//       createdAt = TimeFormatter.getTimeDifference(createdAt);
//    }

    public static List<Tweet> fromJsonArray(JSONArray jsonArray) throws JSONException {
        List<Tweet> tweets = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++) { // loop through jsonArray, each element we add to our list of tweets object)
            tweets.add(fromJson(jsonArray.getJSONObject(i)));
        }
        return tweets;
    }
}
