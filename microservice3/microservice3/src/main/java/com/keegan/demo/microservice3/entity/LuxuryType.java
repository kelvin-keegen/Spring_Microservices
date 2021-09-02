package com.keegan.demo.microservice3.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LuxuryType {

    private String id;
    private String performanceType;
    private String transmission;
    private String driveTrain;
    private double price;

}
