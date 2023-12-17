package com.persoonlijk.backendpersoonlijk;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class configuration implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // dedicated path that is allowed to be used.
                .allowedOrigins("http://localhost:3000", "ws://localhost:3000", "ws://localhost:5000", "http://localhost:5000") // Allow requests from this origin
                .allowedMethods("GET", "POST", "PUT", "DELETE") // allowes what is allowed to do.
                .allowedHeaders("Content-Type", "Authorization")
                .maxAge(3600); // Max age for preflight (OPTIONS) requests
    }
}