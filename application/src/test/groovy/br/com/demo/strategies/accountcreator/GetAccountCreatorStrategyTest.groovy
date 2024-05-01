package br.com.demo.strategies.accountcreator

import br.com.demo.ports.in.dtos.AccountType
import br.com.demo.ports.out.SaveDriverAccountUseCase
import br.com.demo.ports.out.SavePassengerAccountUseCase
import spock.lang.Specification

class GetAccountCreatorStrategyTest extends Specification {

    def savePassengerAccountUseCase = Mock(SavePassengerAccountUseCase)
    def saveDriverAccountUseCase = Mock(SaveDriverAccountUseCase)
    def passengerAccountCreator = new PassengerAccountCreator(savePassengerAccountUseCase)
    def driverAccountCreator = new DriverAccountCreator(saveDriverAccountUseCase)
    def accountCreatorStrategy = new GetAccountCreatorStrategy(passengerAccountCreator, driverAccountCreator)

    def "test getStrategy for Passenger"() {
        when:
        def strategy = accountCreatorStrategy.getStrategy(AccountType.PASSENGER)

        then:
        strategy == passengerAccountCreator
    }

    def "test getStrategy for Driver"() {
        when:
        def strategy = accountCreatorStrategy.getStrategy(AccountType.DRIVER)

        then:
        strategy == driverAccountCreator
    }
}
