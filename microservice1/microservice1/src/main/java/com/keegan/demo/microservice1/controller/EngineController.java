package com.keegan.demo.microservice1.controller;

import com.keegan.demo.microservice1.entity.Engine;
import com.keegan.demo.microservice1.service.PublishService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
@AllArgsConstructor
public class EngineController {

    public final PublishService publishService;

    @GetMapping(path = "/engine")
    public Engine GettingEngineData(@RequestParam(required = true) String engineType) {
        return publishService.publishEngine(engineType);
    }

}
