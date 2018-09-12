package com.cskaoyan.smzdm;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.cskaoyan.smzdm.mapper")
public class SmzdmApplication {

    public static void main(String[] args) {
        SpringApplication.run(SmzdmApplication.class, args);
    }
}
