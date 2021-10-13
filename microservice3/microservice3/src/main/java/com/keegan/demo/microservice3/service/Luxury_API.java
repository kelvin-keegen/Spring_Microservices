package com.keegan.demo.microservice3.service;

import com.keegan.demo.microservice3.entity.LuxuryType;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@AllArgsConstructor
public class Luxury_API {

    private final WebClient.Builder clientbuilder;

    @HystrixCommand(fallbackMethod = "LuxuryTypeAPI_Fallback")
    public LuxuryType luxuryApi_response(String link, String type) {

        LuxuryType returnedLuxuryType = clientbuilder.build()
                .get()
                .uri(link+type)
                .retrieve()
                .bodyToMono(LuxuryType.class)
                .block();

        System.out.println("Grabbed LuxuryTpe: "+returnedLuxuryType);

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

        return none;
    }

}
