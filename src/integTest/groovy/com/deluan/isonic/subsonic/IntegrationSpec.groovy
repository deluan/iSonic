package com.deluan.isonic.subsonic

import com.deluan.isonic.ISonicApplication
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.test.IntegrationTest
import org.springframework.boot.test.SpringApplicationContextLoader
import org.springframework.boot.test.TestRestTemplate
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.web.WebAppConfiguration
import org.springframework.web.client.RestTemplate
import spock.lang.Specification

@IntegrationTest("server.port:0")
@WebAppConfiguration
@ContextConfiguration(loader = SpringApplicationContextLoader, classes = ISonicApplication)
abstract class IntegrationSpec extends Specification {

    @Value('${local.server.port}')
    String serverPort = '8080';

    RestTemplate restTemplate = new TestRestTemplate();

    protected getBaseUrl() { "http://localhost:${serverPort}" }
}
