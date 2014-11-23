package com.deluan.isonic.subsonic.system

import com.deluan.isonic.subsonic.IntegrationSpec
import com.deluan.isonic.subsonic.responses.SubsonicResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.client.RestTemplate

class PingControllerIntegrationSpec extends IntegrationSpec {

    void "should return a valid ping response"() {
        when:
          ResponseEntity entity = new RestTemplate().getForEntity("${baseUrl()}/rest/ping.view", SubsonicResponse)

        then:
          def expected = new SubsonicResponse()
          entity.statusCode == HttpStatus.OK
          entity.body.status == expected.status
          entity.body.version == expected.version
    }
}
