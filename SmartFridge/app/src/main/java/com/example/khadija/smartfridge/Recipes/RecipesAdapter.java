package com.example.khadija.smartfridge.Recipes;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.khadija.smartfridge.R;

import java.util.ArrayList;

public class RecipesAdapter extends ArrayAdapter<RecipesClass> {

    public RecipesAdapter(Context context, int resource, ArrayList<RecipesClass> objects) {
        super(context, resource, objects);

    }


    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view =null;
        if (convertView == null)
            view = LayoutInflater.from(getContext()).inflate(R.layout.recipies_view, parent, false);
             RecipesClass item=getItem(position);
            ImageView imageView=view.findViewById(R.id.RecImage);
            TextView RecName =view.findViewById(R.id.Recname);
            RecName.setText(item.getName());
            /*
            * how to download image
            *
            * */

        return view;
    }
}
