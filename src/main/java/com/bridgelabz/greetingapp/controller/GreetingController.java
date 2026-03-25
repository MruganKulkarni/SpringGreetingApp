package com.bridgelabz.greetingapp.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

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
}