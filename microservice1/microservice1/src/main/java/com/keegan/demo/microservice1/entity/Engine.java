package com.keegan.demo.microservice1.entity;

import lombok.*;

import java.time.LocalDateTime;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Engine {

    private String id;
    private String type_name;
    private int type_cc;
    private LocalDateTime createdIn;

}
