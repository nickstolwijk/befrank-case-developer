package com.befrank.casedeveloperjava.domain.services;

import com.befrank.casedeveloperjava.domain.model.DienstVerband;
import com.befrank.casedeveloperjava.domain.model.PensioenRekening;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Slf4j
class CaseCalculator {

    public BigDecimal calculate(final DienstVerband dienstVerband, final PensioenRekening pensioenRekening, final BigDecimal verwachtRendement ) {
        var jaarlijksePremieStoring = jaarlijksePremieStorting(dienstVerband);

        return verwachteWaarde(pensioenRekening.huidigeWaarde(), jaarlijksePremieStoring, verwachtRendement);
    }

    private BigDecimal verwachteWaarde(final BigDecimal huidigeWaarde, final BigDecimal jaarlijksePremieStorting, final BigDecimal rendement) {
        //Huidige waarde + Jaarlijkse premiestorting + (Huidige waarde + Jaarlijkse premiestorting/2) * rendement

        BigDecimal something = huidigeWaarde.add( jaarlijksePremieStorting ).add(
                huidigeWaarde.add( jaarlijksePremieStorting ).divide( BigDecimal.TWO, RoundingMode.UP ) );
        return percentage(something, rendement.add( BigDecimal.valueOf( 100 ) ) );
    }

    BigDecimal jaarlijksePremieStorting(final DienstVerband dienstVerband) {
        //(Full-time salaris – Franchise) * Parttime percentage * Beschikbare premie percentage

        BigDecimal pensioenSalaris = dienstVerband.fullTimeSalaris().subtract( dienstVerband.franchise() );
        log.info("Fulltime Pensioensalaris: {}", pensioenSalaris);

        BigDecimal partTimePensioenSalaris = percentage(pensioenSalaris, dienstVerband.parttimePercentage() );
        log.info("partTime Pensioensalaris: {}", partTimePensioenSalaris);

        BigDecimal jaarlijksePremiestorting = percentage(partTimePensioenSalaris, dienstVerband.beschikbarePremie());
        log.info("jaarlijkse premiestorting: {}", jaarlijksePremiestorting);

        return jaarlijksePremiestorting;

    }

    public static BigDecimal percentage(BigDecimal base, BigDecimal pct){
        return base.multiply(pct).divide(new BigDecimal(100));
    }
}
