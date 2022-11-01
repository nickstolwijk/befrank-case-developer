package com.befrank.casedeveloperjava;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/case")
public class Controller {
    @Autowired
    private DeelnemerRepository repository;

    @GetMapping
    public List<Integer> getUsers() {
        return repository.findAll()
                .stream()
                .map(Deelnemer::getId)
                .toList();
    }
}
