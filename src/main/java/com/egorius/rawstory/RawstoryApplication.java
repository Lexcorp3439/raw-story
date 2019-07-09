package com.egorius.rawstory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.egorius.rawstory.config.AppConfig;

@SpringBootApplication
public class RawstoryApplication {

    public static void main(String[] args) {
        SpringApplication.run(new Class[] {RawstoryApplication.class, AppConfig.class}, args);
    }

}
