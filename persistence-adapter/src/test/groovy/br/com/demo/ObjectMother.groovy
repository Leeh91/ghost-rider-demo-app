package br.com.demo

import br.com.demo.entities.Account

class ObjectMother {

    static def createAccountEntity(props=null) {
        applyProperties(new Account(), props)
    }
    static def applyProperties(object, props) {
        props?.each { key, value ->
            object.metaClass.setAttribute(object, key, value)
        }
        object
    }
}
