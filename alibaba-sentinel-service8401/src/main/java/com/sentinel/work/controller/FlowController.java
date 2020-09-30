package com.sentinel.work.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FlowController {
    @GetMapping("/testA")
    public String testA() {
        return "----------testA";
    }
    @GetMapping("/testB")
    public String testB() {
        return "----------testB";
    }
}
