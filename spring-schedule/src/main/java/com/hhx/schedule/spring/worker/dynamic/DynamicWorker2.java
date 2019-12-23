package com.hhx.schedule.spring.worker.dynamic;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.TriggerContext;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.PeriodicTrigger;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author hhx
 */
@Slf4j
@Component
public class DynamicWorker2 implements SchedulingConfigurer {

    @Override
    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
        log.info("DynamicWorker2.configureTasks");
        scheduledTaskRegistrar.addTriggerTask(new Task(), triggerContext -> {
            int nextTime = RandomUtils.nextInt(200, 10000);
            log.info("DynamicWorker2.addTriggerTask.nextExecutionTime : {}", nextTime);
            return new PeriodicTrigger(nextTime).nextExecutionTime(triggerContext);
        });
    }

    @Slf4j
    private static class Task implements Runnable {
        private Task() {
            log.info("DynamicWorker2.Task.construct");
        }
        @Override
        public void run() {
            log.info("DynamicWorker2.Task.run");
        }
    }
}
