package com.tienphuckx.toolset;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
//@EnableKafka
public class DigitalEasyToolsetApplication {

    public static void main(String[] args) {
        SpringApplication.run(DigitalEasyToolsetApplication.class, args);
    }

}
