# Spring_Microservices
 A project showcasing microservices in Spring using Spring Boot
 Added Hystrix for fault tolerance.
 
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
