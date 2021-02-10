package com.example.service

import com.example.model.Person
import com.example.repository.PersonRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class PersonService {

    @Autowired
    PersonRepository personRepository

    List<Person> findAll(){
        return personRepository.findAll()
    }
}
