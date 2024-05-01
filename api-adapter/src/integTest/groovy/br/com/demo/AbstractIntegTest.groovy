package br.com.demo

import io.restassured.http.ContentType
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.server.LocalServerPort
import org.springframework.test.context.ActiveProfiles
import org.testcontainers.spock.Testcontainers
import spock.lang.Specification

import static io.restassured.RestAssured.given

@Testcontainers
@ActiveProfiles('integTest')
@SpringBootTest(classes = [Application], webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class AbstractIntegTest extends Specification {

    @LocalServerPort
    int port

    def createRequest() {
        given().log()
                .all()
                .accept(ContentType.JSON)
                .port(port)
    }
}
