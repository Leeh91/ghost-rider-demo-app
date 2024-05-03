package br.com.demo

import br.com.demo.controllers.signup.dtos.SignupRequestDTO

class ObjectMother {

    static def createSignupRequestDTO(props=null) {
        applyProperties(new SignupRequestDTO(
                name: 'Leandro',
                email: 'leandro@me.com',
                cpf: '818.812.278-55',
                driver: true,
                carPlate: 'ABC-1234'
        ), props) as SignupRequestDTO
    }
    static def applyProperties(object, props) {
        props?.each { key, value ->
            object.metaClass.setAttribute(object, key, value)
        }
        object
    }
}
