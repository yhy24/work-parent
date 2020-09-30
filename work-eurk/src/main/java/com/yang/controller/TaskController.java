package com.yang.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@RestController
public class TaskController {

    @Autowired
    ThreadPoolTaskExecutor poolTaskExecutor;

    @RequestMapping("/test")
    public String asyncTest() {

        poolTaskExecutor.execute(()->{
            System.out.println(poolTaskExecutor.getThreadNamePrefix());
            System.out.println("测试数据");
            System.out.println(Thread.currentThread().getName());
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Future<?> submit = poolTaskExecutor.submit(() -> {
        });
        try {
            submit.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        Object object = new Object();

        return "测试数据";
    }
}
