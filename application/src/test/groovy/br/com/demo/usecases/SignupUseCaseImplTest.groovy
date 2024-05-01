package br.com.demo.usecases

import br.com.demo.strategies.accountcreator.AccountCreatorStrategy
import br.com.demo.strategies.accountcreator.GetAccountCreatorStrategy
import spock.lang.Specification

import static br.com.demo.ObjectMother.createAccountCriteriaDTO

class SignupUseCaseImplTest extends Specification {

    def accountCreatorStrategy = Mock(AccountCreatorStrategy)
    def getAccountCreatorStrategy = Mock(GetAccountCreatorStrategy)
    def useCaseImpl = new SignupUseCaseImpl(getAccountCreatorStrategy)

    def "execute"() {
        given:
        def accountCriteriaDTO = createAccountCriteriaDTO()

        and:
        getAccountCreatorStrategy
                .getStrategy(accountCriteriaDTO.getAccountType()) >> accountCreatorStrategy

        and:
        accountCreatorStrategy
            .create(accountCriteriaDTO) >> 1L

        when:
        def result = useCaseImpl.execute(accountCriteriaDTO)

        then:
        result != null
        result == 1L
    }
}