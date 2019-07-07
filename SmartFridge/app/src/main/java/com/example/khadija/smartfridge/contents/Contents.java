package com.example.khadija.smartfridge.contents;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.khadija.smartfridge.R;

import java.util.ArrayList;

public class Contents extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contents);
        ArrayList<String> content_list =new ArrayList<>();
        content_list.add("Rice");
        content_list.add("Tomato");
        content_list.add("Orange");
        content_list.add("bottle");


        ListView content_listView=findViewById(R.id.con_list);
        ContentAdapter adapter =new ContentAdapter(this,R.layout.contents_view,content_list);
        content_listView.setAdapter(adapter);

    }
}
