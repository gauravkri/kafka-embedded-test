package com.grv.embedded_kafka_example.controller;


import com.grv.embedded_kafka_example.service.TestService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    private final TestService testService;

    public TestController(TestService testService) {
        this.testService = testService;
    }


    @GetMapping("/hello")
    public String test(){
        testService.produceMessageToKafka("public to kafka");
        return "testing";
    }
}
