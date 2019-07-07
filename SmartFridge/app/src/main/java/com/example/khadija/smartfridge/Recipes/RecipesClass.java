package com.example.khadija.smartfridge.Recipes;

import com.example.khadija.smartfridge.RecipesDetails.Description;
import com.example.khadija.smartfridge.RecipesDetails.IngredientsClass;
import com.example.khadija.smartfridge.RecipesDetails.StepsClass;

import java.io.Serializable;
import java.util.ArrayList;

public class RecipesClass implements Serializable {
    private String name;
    private String imageUrl;
    private ArrayList<IngredientsClass> ingredients;
    private ArrayList<StepsClass> Steps;
    private int calories;
    private ArrayList<String> goodFor;
    private ArrayList<String> badFor;




    public RecipesClass(String name, String imageUrl, ArrayList<IngredientsClass> ingredients, ArrayList<StepsClass> steps, int calories, ArrayList<String> goodFor, ArrayList<String> badFor) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.ingredients = ingredients;
        this.Steps = steps;
        this.calories = calories;
        this.goodFor = goodFor;
        this.badFor = badFor;
    }

    public String getName() {
        return name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public ArrayList<IngredientsClass> getIngredients() {
        return ingredients;
    }

    public ArrayList<StepsClass> getSteps() {
        return Steps;
    }

    public int getCalories() {
        return calories;
    }

    public ArrayList<String> getGoodFor() {
        return goodFor;
    }

    public ArrayList<String> getBadFor() {
        return badFor;
    }
}