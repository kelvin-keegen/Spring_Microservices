package com.keegan.demo.microservice3.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.beans.Transient;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BodyDetails {

    @JsonIgnore
    private String id;
    private String bodyType;
    private LocalDate yearOfManufature;
    private boolean extraOptions;


}
