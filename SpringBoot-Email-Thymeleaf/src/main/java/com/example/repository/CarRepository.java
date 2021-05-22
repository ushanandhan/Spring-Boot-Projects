package com.example.repository;

import com.example.model.Car;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CarRepository extends CrudRepository<Car, Long> {

    public Optional<Car> findByName(String name);
    public List<Car> findAll();
    public List<Car> findByTypeContaining(String type);
}