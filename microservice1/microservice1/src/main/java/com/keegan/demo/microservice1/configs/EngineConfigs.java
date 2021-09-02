package com.keegan.demo.microservice1.configs;

import com.keegan.demo.microservice1.entity.Engine;
import com.keegan.demo.microservice1.service.PublishService;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Component
@AllArgsConstructor
public class EngineConfigs implements CommandLineRunner {

    private final PublishService publishService;


    @Override
    public void run(String... args) throws Exception {


        System.out.println("Configuring demo data");
        String type;
        LocalDateTime time = LocalDateTime.now();

        Engine v4 = new Engine(

                UUID.randomUUID().toString(),
                type = "V4",
                1500,
                time.minusYears(50)
        );

        Engine v6 = new Engine(

                UUID.randomUUID().toString(),
                type = "V6",
                2500,
                time.minusYears(30)
        );

        Engine v8 = new Engine(

                UUID.randomUUID().toString(),
                type = "V8",
                3500,
                time.minusYears(20)
        );

        publishService.SaveListofEngines(List.of(v4,v6,v8));

    }
}
