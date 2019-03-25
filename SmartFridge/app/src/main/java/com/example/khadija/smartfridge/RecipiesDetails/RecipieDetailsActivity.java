package com.example.khadija.smartfridge.RecipiesDetails;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.khadija.smartfridge.R;
import com.example.khadija.smartfridge.Recipes.RecipiesClass;

import java.util.ArrayList;

public class RecipieDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipie_details);

        Intent intent =getIntent();
        RecipiesClass recipiesClass1 = (RecipiesClass) intent.getSerializableExtra("RecipieKey");
        ImageView RecImage =findViewById(R.id.RecImage);
        ListView ingredientslistView=findViewById(R.id.ingredientslist);
        ListView StepsListView=findViewById(R.id.stepslist);


        final IngredientsAdapter Nadapter =new IngredientsAdapter(this,R.layout.ingredients_view, recipiesClass1.getIngredients());
        ingredientslistView.setAdapter(Nadapter);

        final StepsAdapter Sadapter =new StepsAdapter(this,R.layout.steps_view, recipiesClass1.getSteps());
        StepsListView.setAdapter(Sadapter);
    }
}
