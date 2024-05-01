package br.com.demo

import br.com.demo.controllers.signup.dtos.SignupRequestDTO

class TestDataFactory {

    static def createSignupRequest(props=null) {
        applyProperties(new SignupRequestDTO(), props) as SignupRequestDTO
    }
    static def applyProperties(object, props) {
        props?.each { key, value ->
            object.metaClass.setAttribute(object, key, value)
        }
        object
    }
}
