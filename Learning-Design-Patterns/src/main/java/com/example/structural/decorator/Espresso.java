package com.example.structural.decorator;

public class Espresso extends Beverage{

    public Espresso(){
        description = "Espresso";
    }
    @Override
    int getCost() {
        return 50;
    }
}
