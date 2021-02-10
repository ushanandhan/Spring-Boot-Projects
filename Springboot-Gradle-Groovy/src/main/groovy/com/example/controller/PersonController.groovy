package com.example.controller


import com.example.model.Person
import com.example.service.PersonService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(path = "/people")
class PersonController {

    @Autowired
    PersonService personService

    @GetMapping(path="/", produces = "application/json")
    public List<Person> getPeople()
    {
        return personService.findAll()
    }
}
