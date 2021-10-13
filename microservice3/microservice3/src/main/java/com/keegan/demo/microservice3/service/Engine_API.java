package com.keegan.demo.microservice3.service;

import com.keegan.demo.microservice3.entity.Engine;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class Engine_API {

    private final WebClient.Builder clientbuilder;

    @HystrixCommand(fallbackMethod = "EngineAPI_Fallback")
    public Engine engineApi_response(String link, String type) {

        Engine returnedEngine = clientbuilder.build()
                .get()
                .uri(link+type)
                .retrieve()
                .bodyToMono(Engine.class)
                .block();

        System.out.println("Grabbed engine: "+returnedEngine);

        return returnedEngine;
    }

    public Engine EngineAPI_Fallback(String link, String type) {

        Engine none = new Engine(
                "N/A",
                "N/A",
                0,
                LocalDateTime.now()
        );

        return none;
    }


}
