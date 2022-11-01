package com.befrank.casedeveloperjava;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DeelnemerRepository extends CrudRepository<Deelnemer, Long> {
    List<Deelnemer> findAll();
}
