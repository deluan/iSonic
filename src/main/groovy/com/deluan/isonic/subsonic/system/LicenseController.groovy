package com.deluan.isonic.subsonic.system

import com.deluan.isonic.subsonic.advice.AdvisableController
import com.deluan.isonic.subsonic.responses.License
import com.deluan.isonic.subsonic.responses.SubsonicResponse
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class LicenseController implements AdvisableController {

    @RequestMapping("/rest/getLicense.view")
    def getLicense() {
        SubsonicResponse.withElement(new License())
    }

}
