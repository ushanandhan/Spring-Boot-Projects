package com.example.structural.composite;

public class CompositePatternDemo {
    public static void main(String[] args) {
        Employee ceo = new Employee("John","CEO",30000);
        Employee headSales = new Employee("Robert","Head Sales",20000);
        Employee headMarketing = new Employee("Kevin","Head Marketing",20000);
        Employee clerk1 = new Employee("Alex","Marketing",10000);
        Employee clerk2 = new Employee("Coal","Marketing",10000);
        Employee salesExecutive1 = new Employee("Jenifer","Sales",10000);
        Employee salesExecutive2 = new Employee("Danny","Sales",10000);
        ceo.add(headMarketing);
        ceo.add(headSales);
        headSales.add(salesExecutive1);
        headSales.add(salesExecutive2);
        headMarketing.add(clerk1);
        headMarketing.add(clerk2);
        System.out.println(ceo);
        ceo.getSubordinates().forEach(headEmployee -> {
            System.out.println(headEmployee);
            headEmployee.getSubordinates().forEach(subordinate->{
                System.out.println(subordinate);
            });
        });
    }
}
