package com.everis.bootcamp.primerms.expose;

import com.everis.bootcamp.primerms.model.Response;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/primerms/v1/saludo")
public class PrimerMSController {

    @GetMapping
    public Mono<Response> saludo(){
        Response hola = new Response();
        hola.setSaludo("Hola Mundo!");
        return Mono.justOrEmpty(hola);
    }
}
