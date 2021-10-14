package com.keegan.demo.microservice3.service;

import com.keegan.demo.microservice3.entity.Engine;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class Engine_API {

    private final WebClient.Builder clientbuilder;

    @HystrixCommand(fallbackMethod = "EngineAPI_Fallback",
            threadPoolKey = "engineAPI_threadpoolKey",
            threadPoolProperties = {

                    @HystrixProperty(name = "coreSize", value = "20"),
                    @HystrixProperty(name = "maxQueueSize", value = "10"),

            },

            commandProperties = {

                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000"),
                    @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "6"),
                    @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "5000"),
                    @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50"),
            }
    )
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
                LocalDate.now()
        );

        return none;
    }


}
