package com.example.khadija.smartfridge;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.khadija.smartfridge.Recipes.RecipiesActivity;

public class CamScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cam_screen);

    }
    public void RecipiesButton (View view){
        Intent RecipiesIntent =new Intent(this, RecipiesActivity.class);
        startActivity(RecipiesIntent);
    }
}
