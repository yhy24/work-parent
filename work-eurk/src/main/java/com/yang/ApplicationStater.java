package com.yang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ApplicationStater {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationStater.class, args);
// ./nginx -v
// ./nginx -s stop
// ./nginx -s reload
//
    }
}
