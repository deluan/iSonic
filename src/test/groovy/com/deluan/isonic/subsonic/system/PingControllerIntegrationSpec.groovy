package com.deluan.isonic.subsonic.system

import com.deluan.isonic.ISonicApplication
import com.deluan.isonic.subsonic.model.SubsonicResponse
import org.springframework.boot.test.IntegrationTest
import org.springframework.boot.test.SpringApplicationContextLoader
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.web.WebAppConfiguration
import org.springframework.web.client.RestTemplate
import spock.lang.Specification

@IntegrationTest
@WebAppConfiguration
@ContextConfiguration(loader = SpringApplicationContextLoader, classes = ISonicApplication)
class PingControllerIntegrationSpec extends Specification {

    void "should return a valid ping response"() {
        when:
          ResponseEntity entity = new RestTemplate().getForEntity("http://localhost:8080/rest/ping.view", SubsonicResponse)

        then:
          def expected = SubsonicResponse.withEmptyElement()
          entity.statusCode == HttpStatus.OK
          entity.body.status == expected.status
          entity.body.version == expected.version
    }
}
