package com.deluan.isonic.subsonic.system

import com.deluan.isonic.subsonic.model.License
import com.deluan.isonic.subsonic.model.SubsonicResponse
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class LicenseController {

    @RequestMapping("/rest/getLicense.view")
    def getLicense() {
        SubsonicResponse.withElement(new License())
    }

}
