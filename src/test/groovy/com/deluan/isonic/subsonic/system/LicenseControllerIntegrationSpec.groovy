package com.deluan.isonic.subsonic.system

import com.deluan.isonic.subsonic.IntegrationSpec
import com.deluan.isonic.subsonic.responses.License
import com.deluan.isonic.subsonic.responses.SubsonicResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.client.RestTemplate

class LicenseControllerIntegrationSpec extends IntegrationSpec {

    void "should return a valid license response"() {
        when:
          ResponseEntity entity = new RestTemplate().getForEntity("${baseUrl()}/rest/getLicense.view", SubsonicResponse)

        then:
          def expected = new SubsonicResponse(license: new License())
          entity.statusCode == HttpStatus.OK
          entity.body.status == expected.status
          entity.body.version == expected.version
          entity.body.license.valid == expected.license.valid
    }
}
