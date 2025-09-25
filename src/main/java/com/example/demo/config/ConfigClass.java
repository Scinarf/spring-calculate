package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Scanner;

@Configuration
public class ConfigClass {
    @Bean
    public Scanner scan(){
        return new Scanner(System.in);
    }
}
