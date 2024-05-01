package br.com.demo.daos

import br.com.demo.AbstractIntegTest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.dao.DataIntegrityViolationException
import spock.lang.Unroll

import static br.com.demo.TestDataFactory.createAccountEntity

class AccountDAOTest extends AbstractIntegTest {

    @Autowired
    AccountDAO accountDAO

    def 'should save driver account'() {
        given:
            def account = createAccountEntity(
                    name: 'Leandro',
                    email: 'leandro@br.com',
                    cpf: '12345678901',
                    carPlate: 'ABC-1234',
                    isPassenger: false,
                    isDriver: true,
            )

        when:
            def savedAccount = accountDAO.save(account)

        then:
            savedAccount
            savedAccount.id != null
            savedAccount.name == 'Leandro'
            savedAccount.email == 'leandro@br.com'
            savedAccount.cpf == '12345678901'
            savedAccount.carPlate == 'ABC-1234'
            !savedAccount.isPassenger
            savedAccount.isDriver
    }

    def 'should save passenger account'() {
        given:
        def account = createAccountEntity(
                name: 'Leandro',
                email: 'leandro@br.com',
                cpf: '12345678901',
                isPassenger: true,
                isDriver: false,
        )

        when:
        def savedAccount = accountDAO.save(account)

        then:
        savedAccount
        savedAccount.id != null
        savedAccount.name == 'Leandro'
        savedAccount.email == 'leandro@br.com'
        savedAccount.cpf == '12345678901'
        savedAccount.carPlate == null
        savedAccount.isPassenger
        !savedAccount.isDriver
    }

    @Unroll
    def 'should not save account with #scenario'() {
        given:
        def account = createAccountEntity(
                name: name,
                email: email,
                cpf: cpf,
                carPlate: 'ABC-1234',
                isPassenger: false,
                isDriver: true,
        )

        when:
        accountDAO.save(account)

        then:
        thrown(DataIntegrityViolationException)

        where:
        scenario | name | email | cpf
        'name is null' | null | 'leandro@br.com' | '12345678901'
        'email is null' | 'Leandro' | null | '12345678901'
        'cpf is null' | 'Leandro' | 'leandro@br.com' | null
    }
}
