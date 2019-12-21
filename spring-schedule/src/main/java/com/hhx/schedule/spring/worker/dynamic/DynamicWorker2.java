package com.hhx.schedule.spring.worker.dynamic;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.PeriodicTrigger;
import org.springframework.stereotype.Component;

/**
 * @author hhx
 */
@Slf4j
@Component
public class DynamicWorker2 implements SchedulingConfigurer {

    /**
     * @see com.hhx.schedule.spring.controller.DynamicController#setDynamicWorker1(Integer)
     */
    public static Integer RATE = 10000;

    @Override
    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
        log.info("DynamicWorker2.configureTasks...");
        scheduledTaskRegistrar.addTriggerTask(new Task(),
                triggerContext -> {
                    log.info("DynamicWorker2.addTriggerTask ... RATE : {}", RATE);
                    return new PeriodicTrigger(RATE).nextExecutionTime(triggerContext);
                });
    }

    @Slf4j
    private static class Task implements Runnable {
        private Task() {
            log.info("DynamicWorker2.Task.construct ");
        }
        @Override
        public void run() {
            log.info("DynamicWorker2.Task.run... RATE : {}", RATE);
            try {
                Thread.sleep(1300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
