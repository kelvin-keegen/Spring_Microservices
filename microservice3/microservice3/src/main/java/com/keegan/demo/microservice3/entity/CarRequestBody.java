package com.keegan.demo.microservice3.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarRequestBody {

    @NonNull
    private String engineType;
    @NonNull
    private String performanceType;
    @NonNull
    private String bodyType;

}
