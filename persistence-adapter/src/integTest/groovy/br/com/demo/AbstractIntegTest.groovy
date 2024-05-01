package br.com.demo

import org.springframework.test.context.ActiveProfiles
import org.testcontainers.spock.Testcontainers
import spock.lang.Specification
import org.springframework.boot.test.context.SpringBootTest

@ActiveProfiles('integTest')
@SpringBootTest(classes = [Application])
@Testcontainers
class AbstractIntegTest extends Specification {

    
}
