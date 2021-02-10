package com.example.repository

import com.example.model.Person
import org.springframework.data.jpa.repository.JpaRepository

interface PersonRepository extends JpaRepository<Person,Integer>{
}
