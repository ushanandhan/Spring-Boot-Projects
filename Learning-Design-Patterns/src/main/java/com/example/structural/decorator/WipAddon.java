package com.example.structural.decorator;

public class WipAddon extends CondimentDecorator{
    Beverage beverage;
    WipAddon(Beverage beverage){
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription()+", Wip";
    }
    @Override
    int getCost() {
        return beverage.getCost()+20;
    }
}
