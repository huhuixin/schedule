package com.hhx.schedule.spring.worker;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author hhx
 */
@Slf4j
//@Component
public class Worker2 {

    /**
     * 任务执行完成之前就开始另一个
     */
    @Scheduled(fixedRate = 1)
    public void run2() throws InterruptedException {
        log.info("Worker2.run2...");
        Thread.sleep(2300);
    }

}
