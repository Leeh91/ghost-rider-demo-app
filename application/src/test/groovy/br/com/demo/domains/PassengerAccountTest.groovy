package br.com.demo.domains

import br.com.demo.exceptions.ValidationException
import spock.lang.Specification
import spock.lang.Unroll

class PassengerAccountTest extends Specification {

    @Unroll
    def 'build - Build a passenger- account when id #scenario'() {
        when:
        def passengerAccount = PassengerAccount
                .getBuilder()
                .id(id)
                .name('Leandro')
                .email('leandro@me.com')
                .cpf('818.812.278-55')
                .build()
        then:
        passengerAccount != null
        passengerAccount.id.orElse(null) == id
        passengerAccount.name == 'Leandro'
        passengerAccount.email == 'leandro@me.com'
        passengerAccount.cpf == '818.812.278-55'

        where:
        scenario     | id
        'is present' | 1L
        'is null'    | null
    }

    @Unroll
    def 'build - Build a passenger account when name #scenario fails'() {
        when:
        PassengerAccount
                .getBuilder()
                .id(1L)
                .name(name)
                .email('leandro@me.com')
                .cpf('818.812.278-55')
                .build()
        then:
        def ex = thrown(ValidationException)
        ex.constraintExceptions.get().constraintViolations[0].message == 'Campo nome obrigatório'

        where:
        scenario   | name
        'is null'  | null
        'is empty' | ''
        'is blank' | ' '
    }

    @Unroll
    def 'build - Build a passenger account when email #scenario fails'() {
        when:
        PassengerAccount
                .getBuilder()
                .id(1L)
                .name('Leandro')
                .email(email)
                .cpf('818.812.278-55')
                .build()
        then:
        def ex = thrown(ValidationException)
        ex.constraintExceptions.get().constraintViolations[0].message == message

        where:
        scenario     | email            | message
        'is null'    | null             | 'Campo email obrigatório'
        'is empty'   | ''               | 'Campo email obrigatório'
        'is invalid' | 'leandro.com.br' | 'Campo email inválido'
    }

    def 'build - Build a passenger account when email is blank fails with two constraints'() {
        when:
        PassengerAccount
                .getBuilder()
                .id(1L)
                .name('Leandro')
                .email(' ')
                .cpf('818.812.278-55')
                .build()
        then:
        def ex = thrown(ValidationException)
        ex.constraintExceptions.get().constraintViolations.size() == 2
        def messages = ex.constraintExceptions.get().constraintViolations*.message
        messages.containsAll('Campo email inválido', 'Campo email obrigatório')
    }

    @Unroll
    def 'build - Build a driver account when cpf #scenario fails'() {
        when:
        PassengerAccount
                .getBuilder()
                .id(1L)
                .name('Leandro')
                .email('leandro@me.com')
                .cpf(cpf)
                .build()
        then:
        def ex = thrown(ValidationException)
        ex.constraintExceptions.get().constraintViolations[0].message == message

        where:
        scenario     | cpf         | message
        'is null'    | null        | 'Campo cpf obrigatório'
        'is empty'   | ''          | 'Campo cpf obrigatório'
        'is blank'   | ' '         | 'Campo cpf obrigatório'
        'is invalid' | '123456789' | 'Campo cpf inválido'
    }
}
