package com.keegan.demo.microservice2.service;

import com.keegan.demo.microservice2.entity.LuxuryType;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class Publishservice {

    private List<LuxuryType> allLuxuryModels;

    public List<LuxuryType> SaveAllModels(List<LuxuryType> models) {

        return allLuxuryModels = models;
    }

    public LuxuryType PublishLuxuryType(String performanceType) {

        if (!allLuxuryModels.isEmpty() && performanceType != null) {

            for (LuxuryType luxuryType : allLuxuryModels) {
                if (luxuryType.getPerformanceType().equals(performanceType.toLowerCase())) {
                    return luxuryType;
                }
            }

            throw new IllegalArgumentException("Performance type does not exist");

        }

        return null;
    }
}
