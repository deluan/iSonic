package com.deluan.isonic.subsonic.controllers

import com.deluan.isonic.subsonic.IntegrationSpec
import com.deluan.isonic.subsonic.responses.License
import com.deluan.isonic.subsonic.responses.SubsonicResponse
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.client.RestTemplate

import static org.springframework.http.MediaType.*

class LicenseControllerIntegrationSpec extends IntegrationSpec {

    void "should return a valid license response"() {
        when:
          ResponseEntity entity = restTemplate.getForEntity("${baseUrl}/rest/getLicense.view", SubsonicResponse)

        then:
          def expected = new SubsonicResponse(license: new License())
          entity.statusCode == HttpStatus.OK
          entity.body.status == expected.status
          entity.body.version == expected.version
          entity.body.license.valid == expected.license.valid
    }
}
