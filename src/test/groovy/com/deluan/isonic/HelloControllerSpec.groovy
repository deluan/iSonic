package com.deluan.isonic

import spock.lang.Specification

class HelloControllerSpec extends Specification {

    def "should return a greeting"() {
        expect:
          new HelloController().index() == 'Greetings from iSonic!'
    }
}
