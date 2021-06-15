package com.example.controller;

import com.example.service.BackEndService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.rmi.RemoteException;

@RestController
public class MyController {

    @Autowired
    BackEndService backEndService;

    @GetMapping("/retry")
    @ExceptionHandler({ Exception.class })
    public String validateSpringRetryCapability(@RequestParam(required = false) boolean simulateRetry,
                                                @RequestParam(required = false) boolean simulateRetryFallback) throws RemoteException {
        System.out.println("===============================");
        System.out.println("Inside RestController method..");

        return backEndService.getBackendResponse(simulateRetry, simulateRetryFallback);
    }
}
