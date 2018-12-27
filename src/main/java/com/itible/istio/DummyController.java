package com.itible.istio;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@Slf4j
public class DummyController {

    @Autowired
    private Service service;

    @Value("${version.number}")
    private String baseUrl;

    @GetMapping("/version")
    public String getVersion() {
        return baseUrl;
    }

    @GetMapping("/normal")
    public String getNormalVersion() {
        return service.getData();
    }

    @GetMapping("/mono")
    public Mono<String> getMonoVersion() {
        System.out.println("Som v mone");
        return service.getDataMono();
    }


//    @RequestMapping("/chaining")
//    public String chaining() {
//        ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:8456/version", String.class);
//        return "Chaining + " + response.getBody();
//    }
}
