package com.example.khadija.smartfridge.contents;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.khadija.smartfridge.R;

import java.util.List;

public class ContentAdapter extends ArrayAdapter<String> {


    public ContentAdapter(@NonNull Context context, int resource, @NonNull List<String> objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = null;
        if (convertView == null)
            view = LayoutInflater.from(getContext()).inflate(R.layout.contents_view, parent, false);
        String item = getItem(position);
        TextView textView = view.findViewById(R.id.content_tv);
        textView.setText(item);

        return view;
    }
}

