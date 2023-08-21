package com.befrank.casedeveloperjava.domain.services;

import com.befrank.casedeveloperjava.domain.adapters.pensioenrekening.PensioenRekening;
import com.befrank.casedeveloperjava.domain.model.DienstVerband;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Slf4j
class CaseCalculator {

    public BigDecimal calculate( final DienstVerband dienstVerband, final PensioenRekening pensioenRekening, final BigDecimal verwachtRendement, final int verwachtePensioenLeeftijd ) {
        var jaarlijksePremieStoring = jaarlijksePremieStorting(dienstVerband);

        return verwachteWaarde(pensioenRekening.getHuidigeWaarde(), jaarlijksePremieStoring, verwachtRendement);
    }

    private BigDecimal verwachteWaarde(final BigDecimal huidigeWaarde, final BigDecimal jaarlijksePremieStorting, final BigDecimal rendement) {
        //Huidige waarde + Jaarlijkse premiestorting + (Huidige waarde + Jaarlijkse premiestorting/2) * rendement

        BigDecimal something = huidigeWaarde.add( jaarlijksePremieStorting ).add(
                huidigeWaarde.add( jaarlijksePremieStorting ).divide( BigDecimal.TWO, RoundingMode.UP ) );
        return percentage(something, rendement.add( BigDecimal.valueOf( 100 ) ) ).setScale( 2, RoundingMode.HALF_UP );
    }

    BigDecimal jaarlijksePremieStorting(final DienstVerband dienstVerband) {
        //(Full-time salaris – Franchise) * Parttime percentage * Beschikbare premie percentage

        BigDecimal pensioenSalaris = dienstVerband.getFullTimeSalaris().subtract( dienstVerband.getFranchise() );
        log.info("Fulltime Pensioensalaris: {}", pensioenSalaris);

        BigDecimal partTimePensioenSalaris = percentage(pensioenSalaris, dienstVerband.getParttimePercentage() );
        log.info("partTime Pensioensalaris: {}", partTimePensioenSalaris);

        BigDecimal jaarlijksePremiestorting = percentage(partTimePensioenSalaris, dienstVerband.getBeschikbarePremie());
        log.info("jaarlijkse premiestorting: {}", jaarlijksePremiestorting);

        return jaarlijksePremiestorting;

    }

    public static BigDecimal percentage(BigDecimal base, BigDecimal pct){
        return base.multiply(pct).divide(new BigDecimal(100), RoundingMode.HALF_UP);
    }
}
