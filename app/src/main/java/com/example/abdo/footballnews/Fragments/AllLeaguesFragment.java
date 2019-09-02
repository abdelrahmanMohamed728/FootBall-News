package com.example.abdo.footballnews.Fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.abdo.footballnews.Adapters.LeagueAdapter;
import com.example.abdo.footballnews.Classes.League;
import com.example.abdo.footballnews.R;
import com.example.abdo.footballnews.LeagueActivity;

import org.json.JSONArray;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;

public class AllLeaguesFragment extends Fragment
{
    public AllLeaguesFragment()
    {

    }
    ListView listView;
    List<League> list;
    LeagueAdapter adapter;
    EditText text;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.fragment_leagues, container, false);
        listView = v.findViewById(R.id.LeagueListView);
        list = new ArrayList<>();
           String API_KEY =  getResources().getString(R.string.API_KEY);
           LoadData("https://allsportsapi.com/api/football/?met=Leagues&APIkey="+API_KEY);
        adapter = new LeagueAdapter(getContext(),list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String uid = list.get(position).getId();
                Intent intent = new Intent(getActivity(),LeagueActivity.class);
                intent.putExtra("id",uid);
                startActivity(intent);
            }
        });
           text = v.findViewById(R.id.searchEditText);
           text.addTextChangedListener(new TextWatcher() {
               @Override
               public void beforeTextChanged(CharSequence s, int start, int count, int after) {

               }

               @Override
               public void onTextChanged(CharSequence s, int start, int before, int count) {
                   final List<League> list2 = new ArrayList<>();

                   for (int i = 0;i<list.size();i++)
                   {
                       if (list.get(i).getName().contains(text.getText().toString().toLowerCase())||list.get(i).getCountry().contains(text.getText().toString().toLowerCase()))
                       {
                           list2.add(list.get(i));
                       }
                   }
                   adapter = new LeagueAdapter(getContext(),list2);
                   listView.setAdapter(adapter);
                   listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                       @Override
                       public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                           String uid = list2.get(position).getId();
                           Intent intent = new Intent(getActivity(),LeagueActivity.class);
                           intent.putExtra("id",uid);
                           startActivity(intent);
                       }
                   });
               }

               @Override
               public void afterTextChanged(Editable s) {

               }
           });
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
                    String id = String.valueOf(object.getInt("league_key")).toLowerCase();
                    String name = object.getString("league_name").toLowerCase();
                    String country = object.getString("country_name").toLowerCase();
                    list.add(new League(id,name,country));
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
