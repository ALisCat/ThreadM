package com.lwwsec.threatms;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.lwwsec.threatms.mapper")
@SpringBootApplication
public class ThreatmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(ThreatmsApplication.class, args);
    }

}
