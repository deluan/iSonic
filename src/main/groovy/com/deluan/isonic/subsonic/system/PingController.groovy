package com.deluan.isonic.subsonic.system

import com.deluan.isonic.subsonic.advice.Advisable
import com.deluan.isonic.subsonic.responses.SubsonicResponse
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class PingController implements Advisable {

    @RequestMapping("/rest/ping.view")
    def ping() {
        SubsonicResponse.withEmptyElement()
    }

}
