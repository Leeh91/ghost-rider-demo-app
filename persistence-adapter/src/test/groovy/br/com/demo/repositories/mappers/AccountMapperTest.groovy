package br.com.demo.repositories.mappers

import br.com.demo.domains.Car
import br.com.demo.domains.DriverAccount
import br.com.demo.domains.PassengerAccount
import spock.lang.Specification

class AccountMapperTest extends Specification {

    def 'map - DriverAccount to AccountEntity'() {
        given:
            def driverAccount = DriverAccount
                    .getBuilder()
                    .id(1L)
                    .name('Leandro')
                    .email('leandro@me.com')
                    .cpf('818.812.278-55')
                    .car(Car.getBuilder().carPlate('ABC-1234').build())
                    .build()

        when:
        def account = AccountMapper.INSTANCE.driverAccountDomainToEntity(driverAccount)

        then:
        account != null
        account.id == 1L
        account.name == 'Leandro'
        account.email == 'leandro@me.com'
        account.cpf == '818.812.278-55'
        account.carPlate == 'ABC-1234'
    }

    def 'map - DriverAccount to AccountEntity should return null'() {
        when:
        def account = AccountMapper.INSTANCE.driverAccountDomainToEntity(null)

        then:
        account == null
    }

    def 'map - PassengerAccount to AccountEntity'() {
        given:
        def passengerAccount = PassengerAccount
                .getBuilder()
                .id(1L)
                .name('Leandro')
                .email('leandro@me.com')
                .cpf('818.812.278-55')
                .build()

        when:
        def account = AccountMapper.INSTANCE.passengerAccountDomainToEntity(passengerAccount)

        then:
        account != null
        account.id == 1L
        account.name == 'Leandro'
        account.email == 'leandro@me.com'
        account.cpf == '818.812.278-55'
    }

    def 'map - PassengerAccount to AccountEntity should return null'() {
        when:
        def account = AccountMapper.INSTANCE.passengerAccountDomainToEntity(null)

        then:
        account == null
    }
}
