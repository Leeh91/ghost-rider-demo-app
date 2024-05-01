package br.com.demo.domains

import br.com.demo.exceptions.ValidationException
import spock.lang.Specification

class CarTest extends Specification {

    def "build - Build a car"() {
        when:
            def car = Car.getBuilder().carPlate("ABC-1234").build()
        then:
            car != null
            car.getCarPlate() == "ABC-1234"
    }

    def "build - Build a car with null car plate"() {
        when:
            def car = Car.getBuilder().carPlate(null).build()
        then:
        def exception = thrown ValidationException
        exception.message == "Erro na validação dos dados"
        exception.constraintExceptions.isPresent()

        and:
        def violations = exception.constraintExceptions.get().constraintViolations
        violations.size() == 1
        violations[0].message == "Placa do carro é inválida"
    }

    def "build - Build a car with empty car plate"() {
        when:
            def car = Car.getBuilder().carPlate("").build()
        then:
            def exception = thrown ValidationException
            exception.message == "Erro na validação dos dados"
            exception.constraintExceptions.isPresent()

        and:
            def violations = exception.constraintExceptions.get().constraintViolations
            violations.size() == 1
            violations[0].message == "Placa do carro é inválida"
    }

    def "build - Build a car with blank car plate"() {
        when:
            def car = Car.getBuilder().carPlate(" ").build()
        then:
        def exception = thrown ValidationException
        exception.message == "Erro na validação dos dados"
        exception.constraintExceptions.isPresent()

        and:
        def violations = exception.constraintExceptions.get().constraintViolations
        violations.size() == 1
        violations[0].message == "Placa do carro é inválida"


    }
}
