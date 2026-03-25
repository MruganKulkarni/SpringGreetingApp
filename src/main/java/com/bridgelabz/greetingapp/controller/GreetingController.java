package com.bridgelabz.greetingapp.controller;

import org.springframework.web.bind.annotation.*;
import com.bridgelabz.greetingapp.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/greeting")
public class GreetingController {

    @Autowired
    private GreetingService greetingService;

    @GetMapping
    public String getGreeting() {
        return "Hello World";
    }

    @PostMapping
    public String postGreeting() {
        return "Hello from POST";
    }

    @PutMapping
    public String putGreeting() {
        return "Hello from PUT";
    }

    @DeleteMapping
    public String deleteGreeting() {
        return "Hello from DELETE";
    }

    @GetMapping("/service")
    public String getGreetingFromService() {
        return greetingService.getSimpleGreeting();
    }

    @GetMapping("/custom")
    public String customGreeting(
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String lastName) {

        return greetingService.getGreeting(firstName, lastName);
    }
}