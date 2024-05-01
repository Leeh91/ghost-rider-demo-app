package br.com.demo.strategies.accountcreator

import br.com.demo.exceptions.IllegalArgumentException
import br.com.demo.ports.in.dtos.AccountType
import br.com.demo.ports.out.SavePassengerAccountUseCase
import spock.lang.Specification

import static br.com.demo.ObjectMother.createAccountCriteriaDTO

class PassengerAccountCreatorTest extends Specification {

    def savePassengerAccountUseCase = Mock(SavePassengerAccountUseCase)
    def passengerAccountCreator = new PassengerAccountCreator(savePassengerAccountUseCase);

    def "create - Should create a passenger account and return its id"() {
        given:
        def accountCriteriaDTO = createAccountCriteriaDTO(accountType: AccountType.PASSENGER)

        and:
        1 * savePassengerAccountUseCase.execute(*_) >> 1

        when:
        def result = passengerAccountCreator.create(accountCriteriaDTO)

        then:
        result == 1L
    }

    def "create - Should throw an exception because the given DTO is null"() {
        when:
        def result = passengerAccountCreator.create(null)

        then:
        def exception = thrown(IllegalArgumentException)
        exception.message == "Failed saving passenger account, account data is null"
    }
}
