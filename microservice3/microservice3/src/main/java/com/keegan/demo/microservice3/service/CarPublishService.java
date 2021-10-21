package com.keegan.demo.microservice3.service;

import com.keegan.demo.microservice3.config.AppConfigs;
import com.keegan.demo.microservice3.entity.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CarPublishService {

    private final AppConfigs appConfigs;

    private final Engine_API engineAPI;
    private final Luxury_API luxuryAPI;


    private List<BodyDetails> AllbodyDetails;


    public List<BodyDetails> SaveAllModels(List<BodyDetails> cars) {

        // Debugging links
        System.out.println(appConfigs.getService1());
        System.out.println(appConfigs.getService2());

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

        Engine grabbedEngine = engineAPI.engineApi_response(appConfigs.getService1(),engineType);

        // Get service 2 Data

        LuxuryType grabbedLuxuryType = luxuryAPI.luxuryApi_response(appConfigs.getService2(),performanceType);

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

