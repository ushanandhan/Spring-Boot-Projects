package com.example.creational.singleton;

public class SingletonObject {

    private static SingletonObject object ;

    private SingletonObject(){}

    public static SingletonObject getInstance(){
        if(object==null){
            object = new SingletonObject();
        }
        return object;
    }
}
