package com.keegan.demo.microservice3.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Car {

    // Engine
    private String type_name;
    private int type_cc;
    private LocalDate createdIn;

    // Luxury
    private String performanceType;
    private String transmission;
    private String driveTrain;
    private double price;

    // Body
    private BodyDetails bodyDetails;

}
