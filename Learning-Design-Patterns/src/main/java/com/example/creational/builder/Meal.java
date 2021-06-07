package com.example.creational.builder;

import java.util.ArrayList;
import java.util.List;

public class Meal {
    List<Item> items = new ArrayList<>();

    public void addItem(Item item){
        items.add(item);
    }

    public float getPrice(){
        float price = 0.0f;
        for(Item item : items) price += item.price();
        return price;
    }

    public void showItems(){
        items.forEach(item -> {
            System.out.println("Item : "+item.name()+", Packed in "+item.packing().pack()+" and Price is "+item.price());
       });
    }
}
