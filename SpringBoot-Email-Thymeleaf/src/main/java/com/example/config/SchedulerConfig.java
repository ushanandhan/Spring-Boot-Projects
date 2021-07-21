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
    public void someJob() {
        log.info("Now is "+ LocalDate.now());
    }
}
