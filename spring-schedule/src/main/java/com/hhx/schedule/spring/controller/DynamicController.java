package com.hhx.schedule.spring.controller;

import com.hhx.schedule.spring.worker.dynamic.DynamicWorker1;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hhx
 */
@RestController
public class DynamicController {

    @PutMapping("/dynamic/cron")
    public String setDynamicWorker1(String cron){
        DynamicWorker1.CRON = cron;
        return DynamicWorker1.CRON;
    }

    @GetMapping("/dynamic/cron")
    public String getCron(){
        return DynamicWorker1.CRON;
    }

}
