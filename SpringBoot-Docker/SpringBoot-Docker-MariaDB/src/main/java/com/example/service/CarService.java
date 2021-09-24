package com.example.service;

import com.example.entity.Car;
import com.example.repository.CarRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CarService {

    private final CarRepository carRepository;

    public Car getCarByName(String name) throws Exception {
        Optional<Car> optionalCar = carRepository.findByNameIgnoreCase(name);
        if(optionalCar.isPresent()){
            return optionalCar.get();
        }else {
            throw new Exception("Car Not found");
        }
    }

    public Car saveCar(Car car){
        Car savedCar = carRepository.save(car);
        return savedCar;
    }

    public List<Car> getAllCars(){
        return carRepository.findAll();
    }
}
