package com.example.khadija.smartfridge.RecipiesDetails;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.List;

public class StepsAdapter extends ArrayAdapter<StepsClass> {
    public StepsAdapter(@NonNull Context context, int resource, @NonNull List<StepsClass> objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

    }
}
