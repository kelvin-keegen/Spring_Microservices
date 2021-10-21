package com.keegan.demo.microservice3.config;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "link")
@RequiredArgsConstructor
public class AppConfigs {

    private String service1;
    private String service2;
    private String defaultlink;


    public String getService1() {
        return service1;
    }

    public void setService1(String service1) {
        this.service1 = service1;
    }

    public String getService2() {
        return service2;
    }

    public void setService2(String service2) {
        this.service2 = service2;
    }

    public String getDefaultlink() {
        return defaultlink;
    }

    public void setDefaultlink(String defaultlink) {
        this.defaultlink = defaultlink;
    }
}
