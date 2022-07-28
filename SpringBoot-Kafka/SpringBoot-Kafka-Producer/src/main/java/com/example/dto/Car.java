package com.example.dto;

public class Car {

    private String name;
    private String model;
    private String type;

    public Car() {
    }

    public Car(String name, String model, String type) {
        this.name = name;
        this.model = model;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
