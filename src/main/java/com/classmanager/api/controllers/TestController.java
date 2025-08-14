package com.classmanager.api.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(name = "/test")
public class TestController {

    @GetMapping("/")
    public String TestController(){
        return "Willkommen bei server!";
    }
}