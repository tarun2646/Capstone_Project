package com.example.tarun.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.tarun.filter.JwtAuthenticationFilter;


@Configuration
public class GatewayConfig {

    @Autowired
    private JwtAuthenticationFilter jwtAuthenticationFilter;

    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder) {
        return builder.routes()
                // Auth service route - publicly accessible
                .route("userauth-service-route", r -> r.path("/api/auth/**")
                        .uri("lb://USER-AUTHENTICATION-SERVICE"))
                
                // Question service route - requires ADMIN role
                .route("question-service-route", r -> r.path("/api/v1/question/**")
                        .filters(f -> {
                            JwtAuthenticationFilter.Config config = new JwtAuthenticationFilter.Config();
                            config.setRequiredRole("ADMIN");
                            return f.filter(jwtAuthenticationFilter.apply(config));
                        })
                        .uri("lb://QUESTION-SERVICE"))
                
                // Quiz service route - requires either ADMIN or USER role
                .route("quiz-service-route", r -> r.path("/api/v1/quiz/**")
                        .filters(f -> {
                            JwtAuthenticationFilter.Config config = new JwtAuthenticationFilter.Config();
                            // We don't set a specific required role here because both USER and ADMIN can access
                            // The filter will check if the user has a valid token
                            return f.filter(jwtAuthenticationFilter.apply(config));
                        })
                        .uri("lb://QUIZ-SERVICE"))
                .build();
    }
}