package com.keegan.demo.microservice3.controller;

import com.keegan.demo.microservice3.config.AppConfigs;
import com.keegan.demo.microservice3.entity.BodyDetails;
import com.keegan.demo.microservice3.entity.Car;
import com.keegan.demo.microservice3.entity.CarRequestBody;
import com.keegan.demo.microservice3.service.CarPublishService;
import lombok.AllArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
@AllArgsConstructor
public class CarController {

    private final CarPublishService carPublishService;
    private final Environment environment;
    private final AppConfigs appConfigs;

    @PostMapping(path = "/car")
    public Car RequestCar(@RequestBody CarRequestBody requestBody) {

        return carPublishService.ConsumeData(requestBody);
    }

    @GetMapping(path = "/env")
    public String CheckEnvironment() {
        return environment.toString();
    }

    @GetMapping(path = "/configfile")
    public String TestConfigFile() {

        System.out.println(appConfigs.toString());

        return appConfigs.toString();
    }


}
