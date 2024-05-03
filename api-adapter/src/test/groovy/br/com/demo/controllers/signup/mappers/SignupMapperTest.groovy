package br.com.demo.controllers.signup.mappers

import br.com.demo.ports.in.dtos.AccountType
import org.mapstruct.factory.Mappers
import spock.lang.Specification

import static br.com.demo.ObjectMother.createSignupRequestDTO

class SignupMapperTest extends Specification {

    def signupMapper = Mappers.getMapper(SignupMapper)

    def 'toAccountCriteriaDTO - should return AccountCriteriaDTO'() {
        given:
        def request = createSignupRequestDTO()

        when:
        def response = signupMapper.toAccountCriteriaDTO(request)

        then:
        response.name == request.name
        response.email == request.email
        response.cpf == request.cpf
        response.accountType == AccountType.DRIVER
        response.carPlate == request.carPlate
    }

    def 'toAccountCriteriaDTO - should return null when input is null'() {
        when:
        def response = signupMapper.toAccountCriteriaDTO(null)

        then:
        !response
        noExceptionThrown()
    }
}
