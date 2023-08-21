package com.befrank.casedeveloperjava.repositories;

import com.befrank.casedeveloperjava.domain.model.Deelnemer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Set;

public interface DeelnemerRepository extends CrudRepository<Deelnemer, Long> {

}
