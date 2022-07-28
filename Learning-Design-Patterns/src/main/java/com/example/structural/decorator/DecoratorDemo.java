package com.example.structural.decorator;

public class DecoratorDemo {

    public static void main(String[] args) {
        System.out.println("Espresso with Mocha : ");
        Beverage beverage = new Espresso();
        beverage = new MochaAddon(beverage);
        System.out.println(beverage.getDescription()+" $ "+beverage.getCost());
        System.out.println("Double Mocha with Wip in the HouseBlend : ");
        Beverage beverage2 = new HouseBlend();
        beverage2 = new MochaAddon(beverage2);
        beverage2 = new MochaAddon(beverage2);
        beverage2 = new WipAddon(beverage2);
        System.out.println(beverage2.getDescription()+" $ "+beverage2.getCost());

    }
}
