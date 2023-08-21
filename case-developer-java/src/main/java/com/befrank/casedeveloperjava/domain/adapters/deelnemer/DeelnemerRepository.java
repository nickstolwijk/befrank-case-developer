package com.befrank.casedeveloperjava.domain.adapters.deelnemer;

import com.befrank.casedeveloperjava.domain.model.Deelnemer;

import java.util.Optional;

public interface DeelnemerRepository {
    Optional<Deelnemer> findById(final Long id);

    Iterable<Deelnemer> findAll();

    Deelnemer save(final Deelnemer deelnemer);
}
