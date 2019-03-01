package com.example.khadija.smartfridge;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;

public class RecipiesAdapter extends ArrayAdapter<Recipies> {
ArrayList<Recipies> Recipies;
Context context;

    public RecipiesAdapter(Context context, int resource, ArrayList<Recipies> recipies ) {
        super(context, resource, recipies);
        Recipies = recipies;
        this.context = context;
    }

    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View ListView =null;
        if (convertView == null)
            ListView = LayoutInflater.from(getContext()).inflate(R.layout.recipies_view, parent, false);




        return ListView;
    }
}
