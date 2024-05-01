package br.com.demo.strategies.accountcreator

import br.com.demo.exceptions.IllegalArgumentException
import br.com.demo.ports.in.dtos.AccountType
import br.com.demo.ports.out.SaveDriverAccountUseCase
import spock.lang.Specification

import static br.com.demo.ObjectMother.createAccountCriteriaDTO

class DriverAccountCreatorTest extends Specification {

    def saveDriverAccountUseCase = Mock(SaveDriverAccountUseCase)
    def driverAccountCreator = new DriverAccountCreator(saveDriverAccountUseCase);

    def "create - Should create a driver account and return its id"() {
        given:
        def accountCriteriaDTO = createAccountCriteriaDTO(
                accountType: AccountType.DRIVER,
                carPlate: "ABC1234",
        )

        and:
        1 * saveDriverAccountUseCase.execute(*_) >> 1

        when:
        def result = driverAccountCreator.create(accountCriteriaDTO)

        then:
        result == 1L
    }

    def "create - Should throw an exception because the given DTO is null"() {
        when:
        def result = driverAccountCreator.create(null)

        then:
        def exception = thrown(IllegalArgumentException)
        exception.message == "Failed saving driver account, account data is null"
    }
}
