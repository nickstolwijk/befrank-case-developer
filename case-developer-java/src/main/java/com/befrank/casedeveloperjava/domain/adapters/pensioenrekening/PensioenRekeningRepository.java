package com.befrank.casedeveloperjava.domain.adapters.pensioenrekening;

import com.befrank.casedeveloperjava.domain.model.Deelnemer;

import java.util.Optional;

public interface PensioenRekeningRepository
{
    Optional<PensioenRekening> retrieve( Deelnemer.PensioenRekeningNummer pensioenRekeningNummer );
}
