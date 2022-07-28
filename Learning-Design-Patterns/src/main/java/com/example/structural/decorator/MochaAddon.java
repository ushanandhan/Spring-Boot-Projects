package com.example.structural.decorator;

public class MochaAddon extends CondimentDecorator{
    Beverage beverage;

    public MochaAddon(Beverage beverage){
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription()+", Mocha";
    }

    @Override
    public int getCost() {
        return beverage.getCost()+10;
    }
}
