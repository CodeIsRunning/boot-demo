package com.lxf.schedul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class SchedulDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SchedulDemoApplication.class, args);
    }

}
