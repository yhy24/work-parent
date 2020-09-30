package com.yang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ApplicationStaterClient {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationStaterClient.class, args);
    }
}
