package com.deluan.isonic.subsonic.system

import com.deluan.isonic.subsonic.responses.SubsonicError
import com.deluan.isonic.subsonic.responses.SubsonicResponse
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

import static com.deluan.isonic.subsonic.responses.SubsonicError.GENERIC

@RestController
class CatchAllController {

    @RequestMapping("/rest/*.view")
    def getLicense() {
        SubsonicResponse.withError(new SubsonicError(GENERIC.code, "Not yet implemented"))
    }

}
