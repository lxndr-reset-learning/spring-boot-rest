package com.reset.spring.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class SpringBootProjApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootProjApplication.class, args);
    }

}
