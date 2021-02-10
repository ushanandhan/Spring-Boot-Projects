package com.example.model

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "person")
class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id

    @Column(name="name")
    private String name

    @Column(name="address")
    private String address

    int getId() {
        return id
    }

    void setId(int id) {
        this.id = id
    }

    String getName() {
        return name
    }

    void setName(String name) {
        this.name = name
    }

    String getAddress() {
        return address
    }

    void setAddress(String address) {
        this.address = address
    }
}
