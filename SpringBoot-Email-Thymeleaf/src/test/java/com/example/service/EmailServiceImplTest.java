package com.example.service;

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

    @Test
    void send() {
        Map<String,Object> templateModel = new HashMap<>();
        templateModel.put("username","Ushan");
        templateModel.put("link","www.google.co.in");
        emailService.send("ushan@email.com","test-email-2.html",templateModel);

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
}