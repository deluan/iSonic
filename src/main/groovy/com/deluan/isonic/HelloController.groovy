package com.deluan.isonic

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.ApplicationContext
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
public class HelloController {

    @Autowired
    private ApplicationContext context;

    @RequestMapping("/")
    def index() {
        return "Greetings from iSonic!"
    }

    @RequestMapping("/beans")
    def beans() {
        [beans: context.beanDefinitionNames.sort()]
    }
}