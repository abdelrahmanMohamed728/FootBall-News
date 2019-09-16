package com.example.abdo.footballnews;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.abdo.footballnews.Adapters.TeamAdapter;
import com.example.abdo.footballnews.Classes.League;
import com.example.abdo.footballnews.Classes.Team;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class TeamActivity extends AppCompatActivity {
   String id;
   ImageView image;
   TextView name;
   TeamAdapter adapter;
   ListView listView;
   List<Team> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team);
         id = getIntent().getStringExtra("id");
           image = findViewById(R.id.teamImage);
           name = findViewById(R.id.teamNameTextView);
           list = new ArrayList<>();
           listView = findViewById(R.id.teamListView);
           LoadData("https://allsportsapi.com/api/football/?&met=Teams&teamId="+id+"&APIkey="+getResources().getString(R.string.API_KEY));
           adapter = new TeamAdapter(TeamActivity.this,list);
           listView.setAdapter(adapter);
           listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
               @Override
               public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                   Intent intent = new Intent(TeamActivity.this,PlayerActivity.class);
                   intent.putExtra("id",list.get(position).getId());
                   startActivity(intent);
               }
           });
    }
    public void LoadData(String url)
    {
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET,url, null, new Response.Listener<JSONObject>(){
            @Override
            public void onResponse(JSONObject response) {
                try
                {
                    JSONArray array = response.getJSONArray("result");
                    JSONObject team = array.getJSONObject(0);
                    String img = team.getString("team_logo");
                    String teamName = team.getString("team_name");
                    Picasso.with(TeamActivity.this).load(img).into(image);
                    name.setText(teamName);
                    JSONArray players = team.getJSONArray("players");
                    for (int i =0;i<players.length();i++)
                    {
                        JSONObject player = players.getJSONObject(i);
                        String id = String.valueOf(player.getInt("player_key"));
                        String name = player.getString("player_name");
                        String number = player.getString("player_number");
                        list.add(new Team(id,number,name));
                        adapter.notifyDataSetChanged();
                    }

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
        RequestQueue queue = Volley.newRequestQueue(TeamActivity.this);
        queue.add(request);
    }
}
