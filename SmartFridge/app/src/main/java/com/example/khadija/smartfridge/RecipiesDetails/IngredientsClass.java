package com.example.khadija.smartfridge.RecipiesDetails;

public class IngredientsClass
{
    String name;
    int Count;
    public IngredientsClass(String name, int count) {
        this.name = name;
        Count = count;
    }

    public String getName() {
        return name;
    }

    public int getCount() {
        return Count;
    }
}
