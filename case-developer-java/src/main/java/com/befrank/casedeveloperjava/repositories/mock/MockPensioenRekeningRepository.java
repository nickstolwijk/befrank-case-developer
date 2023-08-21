package com.befrank.casedeveloperjava.repositories.mock;

import com.befrank.casedeveloperjava.domain.adapters.pensioenrekening.PensioenRekening;
import com.befrank.casedeveloperjava.domain.adapters.pensioenrekening.PensioenRekeningRepository;
import com.befrank.casedeveloperjava.domain.model.Deelnemer;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Optional;

@Repository
public class MockPensioenRekeningRepository implements PensioenRekeningRepository {
    @Override
    public Optional<PensioenRekening> retrieve( Deelnemer.PensioenRekeningNummer pensioenRekeningNummer ) {
        return Optional.of(() -> new BigDecimal(pensioenRekeningNummer.pensioenRekeningNummer()));
    }
}
