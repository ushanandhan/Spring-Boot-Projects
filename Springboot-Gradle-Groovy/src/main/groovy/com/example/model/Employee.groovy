package com.example.model

public class Employee {

    public Employee() {

    }

    public Employee(Integer id, String firstName, String lastName, String email) {
        super()
        this.id = id
        this.firstName = firstName
        this.lastName = lastName
        this.email = email
    }

    private Integer id
    private String firstName
    private String lastName
    private String email

    Integer getId() {
        return id
    }

    void setId(Integer id) {
        this.id = id
    }

    String getFirstName() {
        return firstName
    }

    void setFirstName(String firstName) {
        this.firstName = firstName
    }

    String getLastName() {
        return lastName
    }

    void setLastName(String lastName) {
        this.lastName = lastName
    }

    String getEmail() {
        return email
    }

    void setEmail(String email) {
        this.email = email
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", firstName=" + firstName + ",lastName=" + lastName + ", email=" + email + "]"
    }
}