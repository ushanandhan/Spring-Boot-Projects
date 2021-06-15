package com.example.service;

import com.example.exception.RemoteServiceNotAvailableException;
import org.springframework.stereotype.Service;

import java.rmi.RemoteException;
import java.util.Random;

@Service
public class BackEndServiceImpl implements BackEndService{
    @Override
    public String getBackendResponse(boolean simulateRetry, boolean simulateRetryFallback) {
        if(simulateRetry){
            System.out.println("SimulateRetry is true, so try to simulate exception scenario.");
            if (simulateRetryFallback) {
                throw new RemoteServiceNotAvailableException(
                        "Don't worry!! Just Simulated for Spring-retry..Must fallback as all retry will get exception!!!");
            }
            int random = new Random().nextInt();

            System.out.println("Random Number : " + random);
            if (random % 2 == 0) {
                throw new RemoteServiceNotAvailableException("Don't worry!! Just Simulated for Spring-retry..");
            }
        }
        return "Hello from Remote Backend!!!";
    }

    @Override
    public String getBackendResponseFallback(RuntimeException e) {
        System.out.println("All retries completed, so Fallback method called!!!");
        return "All retries completed, so Fallback method called!!!";
    }
}
