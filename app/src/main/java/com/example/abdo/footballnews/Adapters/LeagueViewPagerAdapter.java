package com.example.abdo.footballnews.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.abdo.footballnews.Fragments.AllLeaguesFragment;
import com.example.abdo.footballnews.Fragments.FixturesFragment;
import com.example.abdo.footballnews.Fragments.StandingFragment;
import com.example.abdo.footballnews.Fragments.TopScorersFragment;

public class LeagueViewPagerAdapter extends FragmentStatePagerAdapter {


    public LeagueViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        if (i==0)
            return new StandingFragment();
        else if (i==1)
            return new TopScorersFragment();
        else if (i==2)
            return new FixturesFragment();
        else
            return null;
    }

    @Override
    public int getCount() {
        return 3;
    }
}
