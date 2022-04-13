package com.keegan.demo.microservice3.service;

import com.keegan.demo.microservice3.entity.LuxuryType;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@AllArgsConstructor
@Slf4j
public class Luxury_API {

    private final WebClient.Builder clientbuilder;

    @HystrixCommand(fallbackMethod = "LuxuryTypeAPI_Fallback",
            threadPoolKey = "luxuryAPI_threadpoolKey",
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
    public LuxuryType luxuryApi_response(String link, String type) {

        link = link+"/luxury?performanceType=";

        LuxuryType returnedLuxuryType = clientbuilder.build()
                .get()
                .uri(link+type)
                .retrieve()
                .bodyToMono(LuxuryType.class)
                .block();

        return returnedLuxuryType;
    }

    public LuxuryType LuxuryTypeAPI_Fallback(String link, String type) {

        LuxuryType none = new LuxuryType(
                "N/A",
                "N/A",
                "N/A",
                "N/A",
                0.0
        );

        log.error("Luxury API is down! returning null...");

        return none;
    }

}
