package com.elk.elk.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

import com.elk.elk.dto.HelloWorldLog;

import java.time.LocalDateTime;

@RestController
@Slf4j
public class HelloWorldController {


    @Autowired
    ObjectMapper objectMapper;

    @GetMapping("/")
    public String HomePage() throws JsonProcessingException{
        // Prepare log response
        String helloWorldLog = prepareHHelloWorldLogRespose();
        log.info(helloWorldLog);
        return "INFO -> Home Page";
    }



    @GetMapping("/logs")
    public String LogsPage() throws JsonProcessingException{
        String helloWorldLog = prepareHHelloWorldLogRespose();
        log.warn(helloWorldLog);
        return "LOGS";
    }

    @GetMapping("/warn")
    public String WarnPage() throws JsonProcessingException{
        String helloWorldLog = prepareHHelloWorldLogRespose();
        log.warn(helloWorldLog);
        return "WARN";
    }


    @GetMapping("/er")
    public String ErrorPage() throws JsonProcessingException{
        String  helloWordLog = prepareHHelloWorldLogRespose();
        log.error(helloWordLog);
        return "ERROR";
    }

    private String prepareHHelloWorldLogRespose() throws JsonProcessingException {
        HelloWorldLog helloWorldLog = new HelloWorldLog();
        helloWorldLog.setLogName("Spring Boot Home Page");
        helloWorldLog.setLevel("INFO");
        helloWorldLog.setMessage(" This is INFO from Home Page");

        return objectMapper.writeValueAsString(helloWorldLog);
    }
}