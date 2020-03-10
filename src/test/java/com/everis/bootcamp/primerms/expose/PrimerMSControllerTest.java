package com.everis.bootcamp.primerms.expose;

import com.everis.bootcamp.primerms.model.Response;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;

@ExtendWith(SpringExtension.class)
@WebFluxTest
public class PrimerMSControllerTest {

    @Autowired
    private WebTestClient webClient;

    private static Response responseTest;

    @BeforeAll
    public static void setup() {
        responseTest = new Response();
        responseTest.setSaludo("Hola Mundo!");
    }

    @Test
    public void test_controller_hola_mundo(){
        webClient.get()
            .uri("/primerms/v1/saludo")
            .accept(MediaType.APPLICATION_JSON)
            .exchange()
            .expectStatus().isOk()
            .expectBody(Response.class)
            .isEqualTo(responseTest);
    }
}