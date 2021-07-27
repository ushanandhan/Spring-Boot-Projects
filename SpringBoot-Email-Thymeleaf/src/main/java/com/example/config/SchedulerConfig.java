package com.example.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDate;

@Configuration
@EnableScheduling
@Slf4j
public class SchedulerConfig {

    @Scheduled(cron = "0 5 12 * * MON-FRI") // At 12:05 on every day-of-week from Monday through Friday
    public void firstJob() {
        for (int i = 0; i <10;i++){
            log.info("[first job] {} at {}  ",i, LocalDate.now());
        }
        log.info("Now is "+ LocalDate.now());
    }

    @Scheduled(cron = "0 5 12 * * MON-FRI") // At 12:05 on every day-of-week from Monday through Friday
    public void secondJob() {
        for (int i = 0; i <5;i++){
            log.info("[second job] {} at {}  ",i, LocalDate.now());
        }
        log.info("Now is "+ LocalDate.now());
    }
}
