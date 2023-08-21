package com.befrank.casedeveloperjava.domain.services;


import com.befrank.casedeveloperjava.domain.adapters.deelnemer.DeelnemerRepository;
import com.befrank.casedeveloperjava.domain.adapters.pensioenrekening.PensioenRekening;
import com.befrank.casedeveloperjava.domain.adapters.pensioenrekening.PensioenRekeningRepository;
import com.befrank.casedeveloperjava.domain.model.Deelnemer;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.function.Function;

@Service
@AllArgsConstructor
public class CaseService {

    private final PensioenRekeningRepository pensioenRekeningRepository;

    private final DeelnemerRepository deelnemerRepository;
    private final BigDecimal verwachtRendement = BigDecimal.valueOf( 3L );

    public BigDecimal calculate( final Long deelnemerId ) throws DeelnemerNotFound, PensioenRekeningNotFound {
        var maybeDeelnemer = deelnemerRepository.findById(deelnemerId);
        return maybeDeelnemer.map( deelnemer -> {
            var maybePensioenRekening = pensioenRekeningRepository.retrieve(deelnemer.getPensioenRekeningNummer());

            return maybePensioenRekening.map( calculateCase( deelnemer ) )
                    .orElseThrow(PensioenRekeningNotFound::new);
            }
        )
        .orElseThrow( DeelnemerNotFound::new );


    }

    private Function<PensioenRekening, BigDecimal> calculateCase( Deelnemer deelnemer )
    {
        return pensioenRekening -> {
            var caseCalculator = new CaseCalculator();
            return caseCalculator.calculate( deelnemer.getDienstVerband(), pensioenRekening, verwachtRendement );
        };
    }

    @AllArgsConstructor (access = AccessLevel.PRIVATE)
    public static class DeelnemerNotFound extends RuntimeException {

    }
    @AllArgsConstructor (access = AccessLevel.PRIVATE)
    public static class PensioenRekeningNotFound extends RuntimeException {

    }
}
