package com.yan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ConfigServerApplication {
    //启动类
    public static void main(String[] args) {
        SpringApplication.run(ConfigServerApplication.class,args);
    }
}
