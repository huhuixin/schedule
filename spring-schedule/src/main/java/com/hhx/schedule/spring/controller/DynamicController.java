package com.hhx.schedule.spring.controller;

import com.hhx.schedule.spring.worker.dynamic.DynamicWorker1;
import com.hhx.schedule.spring.worker.dynamic.DynamicWorker2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hhx
 */
@RestController
public class DynamicController {

    @PutMapping("/dynamic/rate/{rate}")
    public Integer setDynamicWorker1(@PathVariable Integer rate){
        DynamicWorker2.RATE = rate;
        return DynamicWorker2.RATE;
    }

    @GetMapping("/dynamic/rate")
    public Integer getRate(){
        return DynamicWorker2.RATE;
    }

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
