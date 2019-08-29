package com.example.abdo.footballnews.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.abdo.footballnews.Classes.League;
import com.example.abdo.footballnews.R;

import java.util.List;

public class LeagueAdapter extends ArrayAdapter<League> {
    public LeagueAdapter(@NonNull Context context,  @NonNull List<League> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView= LayoutInflater.from(getContext()).inflate(R.layout.leaguelayout,parent,false);
        TextView name = convertView.findViewById(R.id.leagueTextView);
        League league = getItem(position);
        name.setText(league.getName());
        return convertView;
    }
}
