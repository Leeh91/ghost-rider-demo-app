package br.com.demo.controllers.signup

import br.com.demo.AbstractIntegTest
import br.com.demo.controllers.signup.dtos.SignupResponseDTO
import io.restassured.http.ContentType

import static br.com.demo.TestDataFactory.createSignupRequest

class SignupControllerTest extends AbstractIntegTest {

    def '/signup - signup driver account response 200 ok'() {
        given:
        def requestPayload = createSignupRequest(
                name: 'Leandro',
                email: 'leandro@me.com',
                cpf: '818.812.278-55',
                isDriver: true,
                isPassenger: false,
                carPlate: 'ABC-1234',
        )

        when:
        def response = createRequest()
                .when()
                .contentType(ContentType.JSON)
                .body(requestPayload)
                .post('/signup')

        then:
        response.statusCode == 200
        def responsePayload = response.body().jsonPath().get() as SignupResponseDTO
        responsePayload.id != null
    }

    def '/signup - signup driver account missing car plate response 400 ok'() {
        given:
        def requestPayload = createSignupRequest(
                name: 'Leandro',
                email: 'leandro@me.com',
                cpf: '818.812.278-55',
                isDriver: true,
                isPassenger: false,
        )

        when:
        def response = createRequest()
                .when()
                .contentType(ContentType.JSON)
                .body(requestPayload)
                .post('/signup')

        then:
        response.statusCode == 400
        def responsePayload = response.body().jsonPath().get()
        responsePayload.errorMessages.size() > 0
        responsePayload.errorMessages[0] == 'Placa do carro é inválida'
    }

    def '/signup - signup passenger account response 200 ok'() {
        given:
        def requestPayload = createSignupRequest(
                name: 'Leandro',
                email: 'leandro@me.com',
                cpf: '818.812.278-55',
                isDriver: false,
                isPassenger: true,
        )

        when:
        def response = createRequest()
                .when()
                .contentType(ContentType.JSON)
                .body(requestPayload)
                .post('/signup')

        then:
        response.statusCode == 200
        def responsePayload = response.body().jsonPath().get() as SignupResponseDTO
        responsePayload.id != null
    }
}
