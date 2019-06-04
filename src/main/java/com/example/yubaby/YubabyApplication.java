package com.example.yubaby;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.yubaby.dao")
public class YubabyApplication {

    public static void main(String[] args) {
        SpringApplication.run(YubabyApplication.class, args);
    }

}
