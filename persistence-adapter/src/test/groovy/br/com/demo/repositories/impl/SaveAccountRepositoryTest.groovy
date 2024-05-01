package br.com.demo.repositories.impl

import br.com.demo.repositories.mappers.AccountMapper
import br.com.demo.daos.AccountDAO
import br.com.demo.domains.Car
import br.com.demo.domains.DriverAccount
import br.com.demo.domains.PassengerAccount
import spock.lang.Specification

import static br.com.demo.ObjectMother.createAccountEntity

class SaveAccountRepositoryTest extends Specification {

    def accountMapper = AccountMapper.INSTANCE
    def accountDAO = Mock(AccountDAO)
    def saveAccountRepository = new SaveAccountRepository(accountMapper, accountDAO)

    def 'execute - DriverAccount - saves the entity and returns the id'() {
        given:
        def account = DriverAccount
                .getBuilder()
                .id(null)
                .name('Leandro')
                .email('leandro@me.com')
                .cpf('818.812.278-55')
                .car(Car.getBuilder().carPlate('ABC-1234').build())
                .build()
        def accountEntity = createAccountEntity(id: 1L)

        when:
        def result = saveAccountRepository.execute(account)

        then:
        1 * accountDAO.save(*_) >> accountEntity

        and:
        result != null
        result == 1L
    }

    def 'execute - DriverAccount - throw an exception whenever the parameter is null'() {
        when:
        saveAccountRepository.execute(null as DriverAccount)

        then:
        def exception = thrown(IllegalArgumentException)
        exception.message == 'Failed on saving driver account, account data is null'
    }

    def 'execute - PassengerAccount - saves the entity and returns the id'() {
        given:
        def account = PassengerAccount
                .getBuilder()
                .id(null)
                .name('Leandro')
                .email('leandro@me.com')
                .cpf('818.812.278-55')
                .build()
        def accountEntity = createAccountEntity(id: 1L)

        when:
        def result = saveAccountRepository.execute(account)

        then:
        1 * accountDAO.save(*_) >> accountEntity

        and:
        result != null
        result == 1L
    }

    def 'execute - PassengerAccount - throw an exception whenever the parameter is null'() {
        when:
        saveAccountRepository.execute(null as PassengerAccount)

        then:
        def exception = thrown(IllegalArgumentException)
        exception.message == 'Failed on saving passenger account, account data is null'
    }
}
