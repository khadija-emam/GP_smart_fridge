package com.example.khadija.smartfridge.Recipes;

import com.example.khadija.smartfridge.RecipiesDetails.IngredientsClass;
import com.example.khadija.smartfridge.RecipiesDetails.StepsClass;

import java.io.Serializable;
import java.util.ArrayList;

public class RecipiesClass implements Serializable {
    private String name;
    private int image;
    private ArrayList<IngredientsClass> ingredients;
    private ArrayList<StepsClass> Steps;

    public RecipiesClass(String name, int image, ArrayList<IngredientsClass> ingredients, ArrayList<StepsClass> steps) {
        this.name = name;
        this.image = image;
        this.ingredients = ingredients;
        this.Steps = steps;
    }

    public String getName() {
        return name;
    }

    public int getImage() {
        return image;
    }

    public ArrayList<IngredientsClass> getIngredients() {
        return ingredients;
    }

    public ArrayList<StepsClass> getSteps() {
        return Steps;
    }
}