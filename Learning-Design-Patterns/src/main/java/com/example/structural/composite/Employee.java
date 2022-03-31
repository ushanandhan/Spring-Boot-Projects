package com.example.structural.composite;

import java.util.*;

public class Employee {

    private String name;
    private String department;
    private int salary;
    private List<Employee> subordinates;

    public Employee(String name, String department, int salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
        subordinates = new ArrayList<>();
    }

    public void add(Employee employee){
        subordinates.add(employee);
    }

    public void remove(Employee employee){
        subordinates.remove(employee);
    }

    public List<Employee> getSubordinates(){
        return subordinates;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                ", subordinates=" + subordinates +
                '}';
    }
}
