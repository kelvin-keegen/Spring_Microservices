package com.keegan.demo.microservice3.service;

import com.keegan.demo.microservice3.entity.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CarPublishService {

    private final Engine_API engineAPI;
    private final Luxury_API luxuryAPI;

    private final String microserice1 = "http://localhost:7001/engine?engineType=";
    private final String microserice2 = "http://localhost:7002/luxury?performanceType=";

    private List<BodyDetails> AllbodyDetails;


    public List<BodyDetails> SaveAllModels(List<BodyDetails> cars) {

        return AllbodyDetails = cars;
    }

    public BodyDetails PublishBodyDetails(String bodyType) {

        if (!AllbodyDetails.isEmpty() && bodyType != null) {

            for (BodyDetails bodyDetails : AllbodyDetails ) {

                if (bodyDetails.getBodyType().equals(bodyType.toLowerCase())) {

                    return bodyDetails;
                }
            }
            throw new IllegalArgumentException("Body type does not exist");
        }
        return null;
    }

    public Car ConsumeData(CarRequestBody carRequestBody) {

        // Parsing request body

        String engineType = carRequestBody.getEngineType();
        String performanceType = carRequestBody.getPerformanceType();
        String bodyType = carRequestBody.getBodyType();

        // Get service 1 Data

        Engine grabbedEngine = engineAPI.engineApi_response(microserice1,engineType);

        // Get service 2 Data

        LuxuryType grabbedLuxuryType = luxuryAPI.luxuryApi_response(microserice2,performanceType);

        // Getting BodyDetails

        BodyDetails formedBody = PublishBodyDetails(bodyType);

        // Merge data objects

        if (grabbedEngine != null && grabbedLuxuryType != null && !bodyType.isEmpty()) {

            Car requestedCar = new Car(
                    grabbedEngine.getType_name(),
                    grabbedEngine.getType_cc(),
                    grabbedEngine.getCreatedIn(),
                    grabbedLuxuryType.getPerformanceType(),
                    grabbedLuxuryType.getTransmission(),
                    grabbedLuxuryType.getDriveTrain(),
                    grabbedLuxuryType.getPrice(),
                    formedBody
            );
            return requestedCar;
        }
        return null;

    }
}

