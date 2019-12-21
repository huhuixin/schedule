package com.hhx.schedule.spring.worker;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author hhx
 */
@Slf4j
@Component
public class Worker1 {

    /**
     * 每隔11秒执行一次
     */
    @Scheduled(fixedRate = 11000)
    public void run1() throws InterruptedException {
        log.info("Worker1.run1...");
        Thread.sleep(3000);
    }

    /**
     * 任务执行完成之后, 间隔11秒之后再次执行
     */
    @Scheduled(fixedDelay = 11000)
    public void run2() throws InterruptedException {
        log.info("Worker1.run2...");
        Thread.sleep(3000);
    }

    /**
     * 每分钟的第00 13 26 39 52 执行
     */
    @Scheduled(cron = "*/13 * * * * ?")
    public void run3() throws InterruptedException {
        log.info("Worker1.run3...");
        Thread.sleep(3000);
    }
}
