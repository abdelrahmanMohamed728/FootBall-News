package com.example.abdo.footballnews;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.abdo.footballnews.Adapters.ViewPagerAdapter;

public class MainActivity extends AppCompatActivity {
    ViewPager viewPager1;
    TabLayout tab1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager1 = findViewById(R.id.ViewPager1);
        tab1 = findViewById(R.id.TabLayout1);
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager1.setAdapter(adapter);
        tab1.setupWithViewPager(viewPager1);
        tab1.getTabAt(0).setIcon(R.drawable.cup);

    }
}
