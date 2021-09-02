package com.keegan.demo.microservice3.controller;

import com.keegan.demo.microservice3.entity.BodyDetails;
import com.keegan.demo.microservice3.entity.Car;
import com.keegan.demo.microservice3.entity.CarRequestBody;
import com.keegan.demo.microservice3.service.CarPublishService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@AllArgsConstructor
public class CarController {

    private final CarPublishService carPublishService;

    @PostMapping(path = "/car")
    public Car RequestCar(@RequestBody CarRequestBody requestBody) {

        return carPublishService.ConsumeData(requestBody);
    }


}
