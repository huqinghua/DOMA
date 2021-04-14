package com.github.huqinghua.mgm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class MgmApplication {

    public static void main(String[] args) {
        SpringApplication.run(MgmApplication.class, args);
    }

}
