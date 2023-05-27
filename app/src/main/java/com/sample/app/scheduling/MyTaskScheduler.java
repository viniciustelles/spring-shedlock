package com.sample.app.scheduling;

import net.javacrumbs.shedlock.core.SchedulerLock;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class MyTaskScheduler {

    @Scheduled(cron = "0 0/1 * * * ?")
    @SchedulerLock(name = "TaskScheduler_scheduledTask", lockAtLeastForString = "PT30S", lockAtMostForString = "PT2M")
    public void scheduledTask() {
        System.out.println(LocalDateTime.now() + " - Running task syncronized with shedlock");
    }

}