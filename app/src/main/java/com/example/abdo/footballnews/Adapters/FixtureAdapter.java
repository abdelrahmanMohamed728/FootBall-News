package com.example.abdo.footballnews.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.abdo.footballnews.Classes.Fixture;

import com.example.abdo.footballnews.R;

import java.util.List;

public class FixtureAdapter extends ArrayAdapter<Fixture> {
    public FixtureAdapter(@NonNull Context context, @NonNull List<Fixture> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView= LayoutInflater.from(getContext()).inflate(R.layout.fixtureslayout,parent,false);
        TextView home = convertView.findViewById(R.id.fixtureHomeTextView);
        TextView away = convertView.findViewById(R.id.fixtureAwayTextView);
        TextView score = convertView.findViewById(R.id.fixtureScoreTextView);
        Fixture fixture = getItem(position);
        home.setText(fixture.getHome());
        away.setText(fixture.getAway());
        score.setText(fixture.getScore());
        return convertView;
    }
}
