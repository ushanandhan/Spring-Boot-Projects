package com.ushan.services;

import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

@Service
public class LongProcess {

    public ArrayList<Integer> longMethod(int start,int end) throws InterruptedException {
        LocalTime startTime = LocalTime.now();
        ArrayList<Integer> integers = new ArrayList<>();
        for (int i = start;i<end;i++){
            integers.add(i);
            TimeUnit.SECONDS.sleep(1);
        }
        LocalTime endtime = LocalTime.now();
        Duration duration = Duration.between(startTime,endtime);
        System.out.println("Current Thread : "+Thread.currentThread().getName()+" took "+duration.getSeconds());
        return integers;
    }
}
