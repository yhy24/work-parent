package com.sentinel.work;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ApplicationSentinel {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationSentinel.class, args);
    }
}
