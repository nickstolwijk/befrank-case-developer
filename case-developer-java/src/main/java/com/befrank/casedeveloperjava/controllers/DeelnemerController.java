package com.befrank.casedeveloperjava.controllers;

import com.befrank.casedeveloperjava.domain.model.Deelnemer;
import com.befrank.casedeveloperjava.repositories.jpa.DeelnemerSpringDataRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/deelnemer")
@AllArgsConstructor
public class DeelnemerController {
    private final DeelnemerSpringDataRepository repository;

    @GetMapping
    public Iterable<Deelnemer> findAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Deelnemer> getUser( @PathVariable Long id) {
        return repository.findById( id );
    }
}
