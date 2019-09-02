package com.example.abdo.footballnews;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.abdo.footballnews.Adapters.LeagueViewPagerAdapter;
import com.example.abdo.footballnews.Adapters.StandingAdapter;
import com.example.abdo.footballnews.Adapters.ViewPagerAdapter;
import com.example.abdo.footballnews.Classes.Standing;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class LeagueActivity extends AppCompatActivity {
    ViewPager viewPager1;
    TabLayout tab1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_league);
        viewPager1 = findViewById(R.id.ViewPager2);
        tab1 = findViewById(R.id.TabLayout2);
        LeagueViewPagerAdapter adapter = new LeagueViewPagerAdapter(getSupportFragmentManager());
        viewPager1.setAdapter(adapter);
        tab1.setupWithViewPager(viewPager1);
        tab1.getTabAt(0).setText("Standing");
        tab1.getTabAt(1).setText("Top Scorers");
        tab1.getTabAt(2).setText("Fixtures");
    }
    public String getId()
    {
        return getIntent().getStringExtra("id");
    }

}
