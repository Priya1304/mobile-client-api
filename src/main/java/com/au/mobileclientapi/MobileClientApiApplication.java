package com.au.mobileclientapi;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class MobileClientApiApplication {

    public static void main(String[] args) {
        log.info("#### APPLICATION STARTED ######");
        SpringApplication.run(MobileClientApiApplication.class, args);
    }

}
