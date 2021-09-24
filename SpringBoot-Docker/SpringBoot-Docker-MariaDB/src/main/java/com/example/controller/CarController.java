package com.example.controller;

import com.example.entity.Car;
import com.example.service.CarService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CarController {

    private final CarService carService;

    @PostMapping("/cars")
    public Car saveCar(@RequestBody Car car){
        return carService.saveCar(car);
    }

    @GetMapping("/cars/")
    public List<Car> getAllCars(){
        return carService.getAllCars();
    }

    @GetMapping("/cars/{name}")
    public Car getCarByName(@PathVariable String name) throws Exception {
        return carService.getCarByName(name);
    }
}
