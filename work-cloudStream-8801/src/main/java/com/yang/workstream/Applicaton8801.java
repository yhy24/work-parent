package com.yang.workstream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class Applicaton8801 {
    public static void main(String[] args) {
        SpringApplication.run(Applicaton8801.class, args);
    }
}
