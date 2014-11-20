package com.deluan.isonic

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
public class HelloController {

    @RequestMapping("/")
    def index() {
        return "Greetings from iSonic!"
    }
}