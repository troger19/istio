package com.itible.istio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.util.Date;

import static sun.misc.Version.println;

@org.springframework.stereotype.Service
public class Service {

    private WebClient client = WebClient.create("http://localhost:8124/v1/skp");

    Mono<String> getDataMono(){
        System.out.println("Som v mone : " + Thread.currentThread().getName() + "   " +  LocalDateTime.now());
        Mono<String> employeeMono =client.get()
                .uri("http://localhost:8124/v1/skp/spi")
                .retrieve()
                .bodyToMono(String.class);
        employeeMono.subscribe();

        System.out.println("Som v mone 1: " + Thread.currentThread().getName() + "   " +  LocalDateTime.now());
        Mono<String> employeeMono1 =client.get()
                .uri("http://localhost:8124/v1/skp/spi")
                .retrieve()
                .bodyToMono(String.class);

        employeeMono1.log().subscribe();

        return employeeMono;
    }

    String getData(){
        System.out.println("Som v normal : " + Thread.currentThread().getName() + "   " +  LocalDateTime.now());
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:8124/v1/skp/spi", String.class);

        System.out.println("Som v normal1 : " + Thread.currentThread().getName() + "   " +  LocalDateTime.now());
        ResponseEntity<String> response1 = restTemplate.getForEntity("http://localhost:8124/v1/skp/spi", String.class);
        System.out.println(response1.getStatusCode() + " : " + LocalDateTime.now());
        return response.getBody();
    }
}
