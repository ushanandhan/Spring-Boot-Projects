package com.example.service;

import com.example.model.Car;
import com.example.repository.CarRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@ActiveProfiles("test")
class EmailServiceImplTest {

    @Autowired
    EmailService emailService;

    @Autowired
    CarRepository carRepository;

    @Test
    void send() {
        Map<String,Object> templateModel = new HashMap<>();
        templateModel.put("username","Ushan");
        templateModel.put("link","www.google.co.in");
        String fileName = "src\\main\\resources\\static\\test.csv";
        emailService.send("ushan@email.com","test-email-2.html",templateModel,fileName);

    }

    @Test
    void sendMailWithThymeleafTemplate() throws AddressException {
        InternetAddress[] toAddresses = {
                new InternetAddress("user1@email.com",false),
                new InternetAddress("user2@email.com",false)
        };

        InternetAddress[] ccAddresses = {
                new InternetAddress("bossuser1@email.com",false),
                new InternetAddress("bossuser2@email.com",false)
        };

        Map<String,Object> templateModel = new HashMap<>();
        templateModel.put("taskTitle","Test Title");
        templateModel.put("taskDescription","Test Description");
        templateModel.put("taskDueDate","30-03-2021");
        templateModel.put("taskStatus","In-Progress");
        emailService.send(toAddresses,ccAddresses,"Testing-Email-Using-Thymeleaf","test-email-1.html",templateModel);
    }

    @Test
    void sendMailCarList() throws AddressException {
        InternetAddress[] toAddresses = {
                new InternetAddress("user1@email.com",false)
        };

        InternetAddress[] ccAddresses = {
                new InternetAddress("bossuser1@email.com",false)
        };

        List<Car> cars = carRepository.findAll();

        Map<String,Object> templateModel = new HashMap<>();
        templateModel.put("taskTitle","Test Title");
        templateModel.put("taskDescription","Test Description");
        templateModel.put("taskDueDate","30-03-2021");
        templateModel.put("taskStatus","In-Progress");
        templateModel.put("cars",cars);
        templateModel.put("url","http://localhost:8080");
        templateModel.put("token",1234);
        emailService.send(toAddresses,ccAddresses,"Testing-Email-Using-Thymeleaf","test-email-3.html",templateModel);
    }
}