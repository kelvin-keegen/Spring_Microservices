package com.keegan.demo.microservice1.service;

import com.keegan.demo.microservice1.entity.Engine;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublishService {

    private List<Engine> All_engines;

    public List<Engine> SaveListofEngines(List<Engine> engines) {
        All_engines = engines;
        System.out.println("Size of list: "+All_engines.size());
        return All_engines;

    }

    public Engine publishEngine(String enginetype) {

        if (!All_engines.isEmpty()) {

            for (Engine all_engine : All_engines) {

                if (all_engine.getType_name().equals(enginetype.toUpperCase())) {

                    return all_engine;
                }
            }

            throw new IllegalArgumentException("Engine type does not exist");
        }

        return null;

    }



}
