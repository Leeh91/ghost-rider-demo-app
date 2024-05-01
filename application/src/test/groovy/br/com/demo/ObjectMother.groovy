package br.com.demo

import br.com.demo.ports.in.dtos.AccountCriteriaDTO

class ObjectMother {

    static def createAccountCriteriaDTO(props=null) {
        applyProperties(new AccountCriteriaDTO(
                name: 'Leandro',
                email: 'leandro@me.com',
                cpf: '818.812.278-55',
        ), props) as AccountCriteriaDTO
    }

    static def applyProperties(object, props) {
        props?.each { key, value ->
            object.metaClass.setAttribute(object, key, value)
        }
        object
    }
}
