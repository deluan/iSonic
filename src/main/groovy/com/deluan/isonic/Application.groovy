package com.deluan.isonic

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration

@Configuration
@EnableAutoConfiguration
@ComponentScan
public class Application {

    static void main(String[] args) {
        def ctx = SpringApplication.run(Application.class, args)

        println("Let's inspect the beans provided by Spring Boot:")

        ctx.beanDefinitionNames.sort().each { beanName ->
            println("   ${beanName}");
        }
    }

}