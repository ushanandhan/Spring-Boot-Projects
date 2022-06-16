package com.example.structural.decorator;

public abstract class Beverage {
    String description;

    public String getDescription(){
        return description;
    }
    abstract int getCost();
}
