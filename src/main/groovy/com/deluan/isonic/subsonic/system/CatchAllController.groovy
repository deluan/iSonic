package com.deluan.isonic.subsonic.system

import com.deluan.isonic.subsonic.advice.AdvisableController
import com.deluan.isonic.subsonic.responses.SubsonicResponse
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class CatchAllController implements AdvisableController {

    @RequestMapping("/rest/*.view")
    def getLicense() {
        SubsonicResponse.withGenericError("Not yet implemented")
    }

}
