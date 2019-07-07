package com.example.khadija.smartfridge.RecipesDetails;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.example.khadija.smartfridge.RecipesDetails.IngredientsClass;

import java.util.List;

public class IngredientsAdapter extends ArrayAdapter<IngredientsClass> {


    public IngredientsAdapter( @NonNull Context context, int resource,  @NonNull List<IngredientsClass> objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {


        return convertView;
    }
}