package com.keegan.demo.microservice3.config;

import com.keegan.demo.microservice3.entity.BodyDetails;
import com.keegan.demo.microservice3.service.CarPublishService;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.UUID;

@Component
@AllArgsConstructor
public class BodyDetailsConfig implements CommandLineRunner {

    private final CarPublishService carPublishService;

    @Override
    public void run(String... args) throws Exception {

        BodyDetails saloon = new BodyDetails(
                UUID.randomUUID().toString(),
                "saloon",
                LocalDate.of(2020, Month.JANUARY,25),
                false
        );

        BodyDetails suv = new BodyDetails(
                UUID.randomUUID().toString(),
                "suv",
                LocalDate.of(2020, Month.JANUARY,25),
                false
        );

        BodyDetails wagon = new BodyDetails(
                UUID.randomUUID().toString(),
                "wagon",
                LocalDate.of(2020, Month.JANUARY,25),
                false
        );

        carPublishService.SaveAllModels(List.of(saloon,suv,wagon));


    }
}
