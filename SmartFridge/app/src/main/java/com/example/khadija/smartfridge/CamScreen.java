package com.example.khadija.smartfridge;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.khadija.smartfridge.Recipes.RecipesActivity;

public class CamScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cam_screen);
        String imageUrl ="http://planners.herokuapp.com/images/wedding_halls/hall1.jpg";
       // ImageView cameraPhoto = (ImageView) findViewById(R.id.camPhoto);
       // Picasso.with(this).load(imageUrl).into(cameraPhoto);
    }

    public void RecipesButton (View view){
        Intent RecipesIntent =new Intent(this, RecipesActivity.class);
        startActivity(RecipesIntent);
    }
}
