package com.keegan.demo.microservice3.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "config")
@RefreshScope
public class AppConfigs {

    private String service1;
    private String service2;
    private String defaultlink;
    private String port;

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

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    @Override
    public String toString() {
        return "AppConfigs{" +
                "service1='" + service1 + '\'' +
                ", service2='" + service2 + '\'' +
                ", defaultlink='" + defaultlink + '\'' +
                ", port='" + port + '\'' +
                '}';
    }
}
