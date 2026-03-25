package com.bridgelabz.greetingapp.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import com.bridgelabz.greetingapp.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import com.bridgelabz.greetingapp.repository.GreetingRepository;
import com.bridgelabz.greetingapp.model.Greeting;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("/greeting")
public class GreetingController {

    @Autowired
    private GreetingService greetingService;
    @Autowired
    private GreetingRepository repository;

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
    @PostMapping("/save")
    public Greeting saveGreeting(@RequestBody Greeting greeting) {
        return repository.save(greeting);
    }
    @GetMapping("/{id}")
    public Greeting getGreetingById(@PathVariable Long id) {
        return repository.findById(id);
    }
    @GetMapping("/all")
    public List<Greeting> getAllGreetings() {
        return repository.findAll();
    }
    @PutMapping("/{id}")
    public Greeting updateGreeting(@PathVariable Long id,
                                   @RequestBody Greeting greeting) {
        return repository.update(id, greeting);
    }
    @DeleteMapping("/{id}")
    public String deleteGreeting(@PathVariable Long id) {
        repository.delete(id);
        return "Greeting deleted successfully";
    }
}