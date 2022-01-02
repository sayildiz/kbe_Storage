package com.sayildiz.kbe_storage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class KbeStorageApplication {

    public static void main(String[] args) {
        SpringApplication.run(KbeStorageApplication.class, args);
    }

}
