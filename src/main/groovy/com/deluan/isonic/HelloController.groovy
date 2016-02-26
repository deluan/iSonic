package com.deluan.isonic

import com.deluan.isonic.itunes.ItunesTrackRepository
import com.deluan.isonic.itunes.LibraryImporter
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.ApplicationContext
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
public class HelloController {

    @Autowired
    private ApplicationContext context;

    @Autowired
    LibraryImporter libraryImporter

    @Autowired
    private ItunesTrackRepository trackRepository

    @RequestMapping("/")
    def index() {
        return "Greetings from iSonic!"
    }

    @RequestMapping("/beans")
    def beans() {
        [beans: context.beanDefinitionNames.sort()]
    }

    @RequestMapping("/itunes")
    def itunes() {
        libraryImporter.parse()
        "Total tracks: ${trackRepository.count()}".toString()
    }

    @RequestMapping("/search")
    def artists(@RequestParam(value = 'q', required = false) String query) {
        if (query) {
            trackRepository.findByName(query)
        } else {
            trackRepository.findAll()
        }
    }
}