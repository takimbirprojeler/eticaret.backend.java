package com.eticaret.java;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class ETicaretJavaApplication {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        SpringApplication.run(ETicaretJavaApplication.class, args);
    }

}
