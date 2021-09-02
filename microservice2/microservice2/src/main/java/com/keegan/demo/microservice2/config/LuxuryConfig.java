package com.keegan.demo.microservice2.config;

import com.keegan.demo.microservice2.entity.LuxuryType;
import com.keegan.demo.microservice2.service.Publishservice;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
@AllArgsConstructor
public class LuxuryConfig implements CommandLineRunner {

    private final Publishservice publishservice;

    @Override
    public void run(String... args) throws Exception {

        LuxuryType normal = new LuxuryType(

                UUID.randomUUID().toString(),
                "base",
                "Automatic",
                "FWD",
                13500.00
        );

        LuxuryType sport = new LuxuryType(

                UUID.randomUUID().toString(),
                "sport",
                "Manual",
                "RWD",
                23499.00

        );

        LuxuryType confmy = new LuxuryType(

                UUID.randomUUID().toString(),
                "comfy",
                "dual",
                "4WD",
                35999.00
        );

        publishservice.SaveAllModels(List.of(sport,confmy,normal));

    }
}
