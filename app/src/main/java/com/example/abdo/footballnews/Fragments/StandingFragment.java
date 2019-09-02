package com.example.abdo.footballnews.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.abdo.footballnews.Adapters.StandingAdapter;
import com.example.abdo.footballnews.Classes.Standing;
import com.example.abdo.footballnews.LeagueActivity;
import com.example.abdo.footballnews.R;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class StandingFragment extends Fragment {


    public StandingFragment() {
        // Required empty public constructor
    }

    ListView listView;
    List<Standing> list;
    StandingAdapter adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v= inflater.inflate(R.layout.fragment_standing, container, false);
        listView= v.findViewById(R.id.StandingListView);
        list = new ArrayList<>();
        String API_KEY =  getResources().getString(R.string.API_KEY);
        LeagueActivity activity= (LeagueActivity) getActivity();
        String id =activity.getId();
        LoadData("https://allsportsapi.com/api/football/?&met=Standings&leagueId="+id+"&APIkey="+API_KEY);
        adapter = new StandingAdapter(getActivity(),list);
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
                    response = response.getJSONObject("result");
                    JSONArray array = response.getJSONArray("total");
                    for (int i =0;i<array.length();i++)
                    {
                        JSONObject object = array.getJSONObject(i);
                        String id = String.valueOf(object.getInt("team_key"));
                        String name = object.getString("standing_team");
                        String rank = object.getString("standing_place");
                        String points =object.getString("standing_PTS");
                        list.add(new Standing(id,rank,name,points));
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
