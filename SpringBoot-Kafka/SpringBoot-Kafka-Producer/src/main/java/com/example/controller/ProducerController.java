package com.example.controller;

import com.example.dto.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProducerController {

    @Autowired
    KafkaTemplate<String, Car> kafkaTemplate;

    private static final String TOPIC = "New-Topic";

    @PostMapping("/publish")
    public String publishMessage(@RequestBody Car car){
        kafkaTemplate.send(TOPIC, car);
        return "Published successfully";
    }
}
