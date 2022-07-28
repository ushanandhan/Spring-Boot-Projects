package com.example.structural.decorator;

public class HouseBlend extends Beverage{

    public HouseBlend(){
        description = "HouseBlend";
    }
    @Override
    int getCost() {
        return 55;
    }
}
