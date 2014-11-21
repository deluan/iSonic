package com.deluan.isonic

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.annotation.ComponentScan

@EnableAutoConfiguration
@ComponentScan
public class ISonicApplication {

    static void main(String[] args) {
        SpringApplication.run(ISonicApplication.class, args)
    }

}