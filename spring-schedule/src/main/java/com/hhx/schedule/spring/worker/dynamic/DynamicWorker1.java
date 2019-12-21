package com.hhx.schedule.spring.worker.dynamic;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;


/**
 * @author hhx
 */
@Slf4j
//@Component
public class DynamicWorker1 implements SchedulingConfigurer {

    /**
     * @see com.hhx.schedule.spring.controller.DynamicController#setDynamicWorker1(String)
     */
    public static String CRON = "0/5 * * * * ?";

    @Override
    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
        log.info("DynamicWorker1.configureTasks...");
        scheduledTaskRegistrar.addTriggerTask(new Task(),
                triggerContext -> new CronTrigger(CRON).nextExecutionTime(triggerContext));
    }

    @Slf4j
    private static class Task implements Runnable {
        @Override
        public void run() {
            log.info("DynamicWorker1.Task.run... CRON : {}", CRON);
        }
    }
}
