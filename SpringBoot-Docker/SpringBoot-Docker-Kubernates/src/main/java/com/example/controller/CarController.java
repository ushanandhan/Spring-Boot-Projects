package com.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("cars")
public class CarController {

    @GetMapping("/")
    public List<String> getCars(){
        return List.of("Tesla","Renault","Nissan","Mahindra","TATA");
    }
}
