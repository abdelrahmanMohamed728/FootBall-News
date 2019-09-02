package com.example.abdo.footballnews.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.example.abdo.footballnews.Classes.Standing;
import com.example.abdo.footballnews.R;
import java.util.List;

public class StandingAdapter extends ArrayAdapter<Standing> {
    public StandingAdapter(@NonNull Context context,  @NonNull List<Standing> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView= LayoutInflater.from(getContext()).inflate(R.layout.standinglayout,parent,false);
        TextView name = convertView.findViewById(R.id.standingName);
        TextView points = convertView.findViewById(R.id.standingPoints);
        TextView rank = convertView.findViewById(R.id.standingRank);
        Standing standing = getItem(position);
        points.setText(standing.getPoints());
        name.setText(standing.getName());
        rank.setText(standing.getRank());
        return convertView;
    }
}
