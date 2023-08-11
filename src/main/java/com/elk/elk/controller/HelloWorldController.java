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
        // log.error(helloWorldLog);
        // log.warn(helloWorldLog);
        return "This is Demo Home API";
    }

    private String prepareHHelloWorldLogRespose() throws JsonProcessingException {
        HelloWorldLog helloWorldLog = new HelloWorldLog();
        helloWorldLog.setLogName("Spring Boot Home Page");
        helloWorldLog.setLevel("INFO");
        helloWorldLog.setMessage(" This is INFO from Home Page");

        return objectMapper.writeValueAsString(helloWorldLog);
    }

    @GetMapping("/logs")
    public String LogsPage(){
        LocalDateTime localDateTime = LocalDateTime.now();
        log.info("This Logs page " + localDateTime);
        return "Welcome to logs page";
    }

    @GetMapping("/warn")
    public String WarnPage(){
        LocalDateTime localDateTime = LocalDateTime.now();
        log.warn("This warn page " + localDateTime);
        return "Welcome to warn page";
    }


    @GetMapping("/er")
    public String ErrorPage(){
        LocalDateTime localDateTime = LocalDateTime.now();
        log.error("This error page " + localDateTime);
        return "Welcome to error page";
    }
}