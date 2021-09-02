package com.keegan.demo.microservice2.controller;

import com.keegan.demo.microservice2.entity.LuxuryType;
import com.keegan.demo.microservice2.service.Publishservice;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@AllArgsConstructor
public class LuxuryController {

    private final Publishservice publishservice;

    @GetMapping(path = "/luxury")
    public LuxuryType ReturnLuxury(@RequestParam(required = true) String performanceType) {

        return publishservice.PublishLuxuryType(performanceType);
    }

}
