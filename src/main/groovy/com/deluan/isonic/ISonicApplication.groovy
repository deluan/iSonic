package com.deluan.isonic

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.annotation.ComponentScan

@EnableAutoConfiguration
@ComponentScan
public class ISonicApplication {

    static void main(String[] args) {
        def ctx = SpringApplication.run(ISonicApplication.class, args)

        println("Let's inspect the beans provided by Spring Boot:")

        ctx.beanDefinitionNames.sort().each { beanName ->
            println("   ${beanName}")
        }
    }

}