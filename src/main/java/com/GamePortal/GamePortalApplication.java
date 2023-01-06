package com.GamePortal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.GamePortal")
@EnableAutoConfiguration
public class GamePortalApplication {

    public static void main(String[] args) {
        SpringApplication.run(GamePortalApplication.class, args);


	}

}
