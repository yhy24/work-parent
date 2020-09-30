package com.yang.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RutesConfig {
    @Bean
    public RouteLocator custerLocate(RouteLocatorBuilder routeLocatorBuilder) {
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        routes.route("path-id",
                r -> r.path("/guonei").uri("http://news.baidu.com/guonei"));
        return routes.build();
    }
}
