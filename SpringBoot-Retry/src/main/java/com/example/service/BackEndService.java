package com.example.service;

import com.example.exception.RemoteServiceNotAvailableException;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;

import java.rmi.RemoteException;

public interface BackEndService {

    @Retryable(value = {RemoteServiceNotAvailableException.class},maxAttempts = 3,backoff = @Backoff(delay = 1000,multiplier = 2))
    public String getBackendResponse(boolean simulateRetry,boolean simulateRetryFallback);

    @Recover
    public String getBackendResponseFallback(RemoteServiceNotAvailableException e);
}
