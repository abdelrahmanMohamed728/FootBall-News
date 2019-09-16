package com.example.abdo.footballnews.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.abdo.footballnews.Classes.Team;
import com.example.abdo.footballnews.R;

import java.util.List;

public class TeamAdapter extends ArrayAdapter<Team> {
    public TeamAdapter(@NonNull Context context, @NonNull List<Team> objects) {
        super(context,0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView= LayoutInflater.from(getContext()).inflate(R.layout.teamlayout,parent,false);
        TextView num = convertView.findViewById(R.id.teamPlayerNumber);
        TextView name = convertView.findViewById(R.id.teamPlayerName);
        Team player = getItem(position);
        num.setText(player.getNum());
        name.setText(player.getName());
        return convertView;
    }
}
