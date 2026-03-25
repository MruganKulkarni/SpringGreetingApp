package com.bridgelabz.greetingapp.repository;

import com.bridgelabz.greetingapp.model.Greeting;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class GreetingRepository {

    private Map<Long, Greeting> repo = new HashMap<>();
    private Long idCounter = 1L;

    public Greeting save(Greeting greeting) {
        greeting.setId(idCounter++);
        repo.put(greeting.getId(), greeting);
        return greeting;
    }
    public Greeting findById(Long id) {
        return repo.get(id);
    }
}