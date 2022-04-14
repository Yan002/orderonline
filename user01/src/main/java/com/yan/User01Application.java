package com.yan;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.yan.repository")
public class User01Application {
    public static void main(String[] args) {
        SpringApplication.run(User01Application.class,args);
    }
}
