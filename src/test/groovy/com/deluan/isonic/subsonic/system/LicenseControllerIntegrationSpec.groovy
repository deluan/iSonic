package com.deluan.isonic.subsonic.system

import com.deluan.isonic.ISonicApplication
import com.deluan.isonic.subsonic.responses.License
import com.deluan.isonic.subsonic.responses.SubsonicResponse
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
class LicenseControllerIntegrationSpec extends Specification {

    void "should return a valid license response"() {
        when:
          ResponseEntity entity = new RestTemplate().getForEntity("http://localhost:8080/rest/getLicense.view", SubsonicResponse)

        then:
          def expected = SubsonicResponse.withElement(new License())
          entity.statusCode == HttpStatus.OK
          entity.body.status == expected.status
          entity.body.version == expected.version
          entity.body.license.valid == expected.license.valid
    }
}
