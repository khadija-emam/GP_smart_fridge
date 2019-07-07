package com.example.khadija.smartfridge.RecipesDetails;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.khadija.smartfridge.R;
import com.example.khadija.smartfridge.Recipes.RecipesClass;

public class RecipieDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipie_details);

        Intent intent =getIntent();
        RecipesClass recipesClass1 = (RecipesClass) intent.getSerializableExtra("RecipieKey");
        ImageView RecImage =findViewById(R.id.RecImage);
        ListView ingredientslistView=findViewById(R.id.ingredientslist);
        ListView StepsListView=findViewById(R.id.stepslist);


        final com.example.khadija.smartfridge.RecipesDetails.IngredientsAdapter Nadapter =new com.example.khadija.smartfridge.RecipesDetails.IngredientsAdapter(this,R.layout.ingredients_view, recipesClass1.getIngredients());
        ingredientslistView.setAdapter(Nadapter);

        final StepsAdapter Sadapter =new StepsAdapter(this,R.layout.steps_view, recipesClass1.getSteps());
        StepsListView.setAdapter(Sadapter);
    }
}
