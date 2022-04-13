package com.keegan.demo.microservice3.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "config")
@RefreshScope
@Data
public class AppConfigs {

    private String service1;
    private String service2;

}
