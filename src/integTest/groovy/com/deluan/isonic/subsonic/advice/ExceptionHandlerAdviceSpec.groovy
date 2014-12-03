package com.deluan.isonic.subsonic.advice

import com.deluan.isonic.subsonic.IntegrationSpec
import com.deluan.isonic.subsonic.responses.SubsonicResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.RestTemplate

import static com.deluan.isonic.subsonic.responses.SubsonicError.GENERIC
import static com.deluan.isonic.subsonic.responses.SubsonicResponse.withError

class ExceptionHandlerAdviceSpec extends IntegrationSpec {

    void "should return a valid error response"() {
        when:
          ResponseEntity entity = restTemplate.getForEntity("${baseUrl}/test/error", SubsonicResponse)

        then:
          def expected = withError(GENERIC)
          entity.statusCode == HttpStatus.OK
          entity.body.status == 'failed'
          entity.body.version == expected.version
          entity.body.error.code == 0
          entity.body.error.message != ''
    }

}

@RestController
class TestController implements Advisable {
    @RequestMapping("/test/error")
    def raiseError() {
        throw new Exception("Something bad just happened")
    }
}

