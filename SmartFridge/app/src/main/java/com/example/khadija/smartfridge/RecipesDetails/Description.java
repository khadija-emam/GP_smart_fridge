package com.example.khadija.smartfridge.RecipesDetails;

import java.util.ArrayList;

public class Description {
    int calories;
    ArrayList<String>GoodFor;
    ArrayList<String>BadFor;

    public Description(int calories, ArrayList<String> goodFor, ArrayList<String> badFor) {
        this.calories = calories;
        GoodFor = goodFor;
        BadFor = badFor;
    }

    public int getCalories() {
        return calories;
    }

    public ArrayList<String> getGoodFor() {
        return GoodFor;
    }

    public ArrayList<String> getBadFor() {
        return BadFor;
    }
}

