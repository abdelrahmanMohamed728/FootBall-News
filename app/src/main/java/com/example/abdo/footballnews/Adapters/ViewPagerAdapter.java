package com.example.abdo.footballnews.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import com.example.abdo.footballnews.Fragments.LeaguesFragment;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {
    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        if (i==0)
            return new LeaguesFragment();

        else
            return null;
    }

    @Override
    public int getCount() {
        return 1;
    }
}
