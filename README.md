# Spring_Microservices
 A project showcasing microservices in Spring using Spring Boot.
 
 Added Hystrix for fault tolerance.
 
 *Start config server first to load App configurations before application start-up.*
 
 Jar files are in folder name **"Jar-Files"**
 
 # Sample request
 ```
 {
    "engineType":"v6",
    "performanceType":"sport",
    "bodyType":"suv"
}
 ```
 
 # Sample response
```
{
    "type_name": "V6",
    "type_cc": 2500,
    "createdIn": "1991-10-14",
    "performanceType": "sport",
    "transmission": "Manual",
    "driveTrain": "RWD",
    "price": 23499.0,
    "bodyDetails": {
        "bodyType": "suv",
        "yearOfManufature": "2020-01-25",
        "extraOptions": false
    }
}
``` 

# Demo Hystrix dashboard of APIs

![alt text](https://github.com/kelvin-keegen/Spring_Microservices/blob/main/Screenshots/Screenshot1.png?raw=true)
