package com.example.abdo.footballnews;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.abdo.footballnews.Classes.Team;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONObject;

public class PlayerActivity extends AppCompatActivity {
     TextView name,team,age,country,number,goals,matches;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);
        String id = getIntent().getStringExtra("id");
        name = findViewById(R.id.playerName);
        team = findViewById(R.id.playerTeam);
        age = findViewById(R.id.playerAge);
        country = findViewById(R.id.playerCountry);
        goals = findViewById(R.id.playerGoalsScored);
        number = findViewById(R.id.playerNumber);
        matches = findViewById(R.id.playerMatchesPlayed);
        LoadData("https://allsportsapi.com/api/football/?&met=Players&playerId="+id+"&APIkey="+getResources().getString(R.string.API_KEY));


    }
    public void LoadData(String url)
    {
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET,url, null, new Response.Listener<JSONObject>(){
            @Override
            public void onResponse(JSONObject response) {
                try
                {
                    JSONArray array = response.getJSONArray("result");
                    JSONObject object = array.getJSONObject(0);
                    name.setText("Name : "+object.getString("player_name"));
                    team.setText("Team : "+object.getString("team_name"));
                    age.setText("Age : "+object.getString("player_age"));
                    country.setText("Country : "+object.getString("player_country"));
                    goals.setText("Goals : "+object.getString("player_goals"));
                    matches.setText("Matches : "+object.getString("player_match_played"));
                    number.setText("No : "+object.getString("player_number"));
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                    Log.e("tag",e.toString());
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error)
            {

            }
        });
        RequestQueue queue = Volley.newRequestQueue(PlayerActivity.this);
        queue.add(request);
    }
}
