package com.udemy.spring.springselenium.operations.config;

import com.github.javafaker.Faker;
import com.udemy.spring.springselenium.operations.annotation.LazyConfiguration;
import org.springframework.context.annotation.Bean;

@LazyConfiguration
public class FakerConfig {

    @Bean
    public Faker getFaker(){
        return new Faker();
    }
}
