/*
    -----------------------------------//-----------------------------------
        Copyright AUDSAT
    -----------------------------------//-----------------------------------
        Copyright (c) Audsat, Todos os direitos reservados

        Este arquivo e uma propriedade confidencial da Audsat. Nenhuma parte do mesmo
        pode ser copiada, reproduzida, impressa ou transmitida por qualquer meio sem
        autorizacao expressa e por escrito de um representante legal da Audsat.

        All rights reserved

        This file is a confidential property of Audsat. No part of this file may be
        reproduced or copied in any form or by any means without written permission
        from an authorized person from Audsat.

 */
package br.com.demo.annotations;

import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Component;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface WSClient {
    /**
     * The value may indicate a suggestion for a logical component name,
     * to be turned into a Spring bean in case of an autodetected component.
     * @return the suggested component name, if any (or empty String otherwise)
     */
    @AliasFor(annotation = Component.class)
    String value() default "";
}
