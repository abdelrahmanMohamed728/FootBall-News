package com.example.abdo.footballnews.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.abdo.footballnews.Adapters.FixtureAdapter;
import com.example.abdo.footballnews.Adapters.StandingAdapter;
import com.example.abdo.footballnews.Classes.Fixture;
import com.example.abdo.footballnews.Classes.Standing;
import com.example.abdo.footballnews.LeagueActivity;
import com.example.abdo.footballnews.R;

import org.json.JSONArray;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class FixturesFragment extends Fragment {

    ListView listView;
    List<Fixture> list;
    FixtureAdapter adapter;
    public FixturesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_fixtures, container, false);
        listView= v.findViewById(R.id.FixturesListView);
        list = new ArrayList<>();
        String API_KEY =  getResources().getString(R.string.API_KEY);
        LeagueActivity activity= (LeagueActivity) getActivity();
        String id =activity.getId();
        Date c = Calendar.getInstance().getTime();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = df.format(c);

        LoadData("https://allsportsapi.com/api/football/?met=Fixtures&"+id+"&APIkey="+API_KEY+"&leagueId="+id+"&from=2019-05-23&to="+formattedDate);
        adapter = new FixtureAdapter(getActivity(),list);
        listView.setAdapter(adapter);
        return v;
    }
    public void LoadData(String url)
    {
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET,url, null, new Response.Listener<JSONObject>(){
            @Override
            public void onResponse(JSONObject response) {
                try
                {

                    JSONArray array = response.getJSONArray("result");
                    for (int i =0;i<array.length();i++)
                    {
                        JSONObject object = array.getJSONObject(i);
                        String home = object.getString("event_home_team");
                        String id = String.valueOf(object.getInt("event_key"));
                        String away = object.getString("event_away_team");
                        String score = object.getString("event_final_result");
                        list.add(new Fixture(id,home,away,score));
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
        RequestQueue queue = Volley.newRequestQueue(getActivity());
        queue.add(request);
    }
}
