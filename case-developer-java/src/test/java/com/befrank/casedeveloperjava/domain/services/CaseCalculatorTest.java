package com.befrank.casedeveloperjava.domain.services;

import com.befrank.casedeveloperjava.domain.model.DienstVerband;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

class CaseCalculatorTest {

    @Test
    void calculate_yearly() {
        var caseCalculator = new CaseCalculator();

        DienstVerband dienstVerband = DienstVerband.builder()
                .fullTimeSalaris( BigDecimal.valueOf( 100_000L ) )
                .parttimePercentage( BigDecimal.valueOf( 80L) )
                .franchise( BigDecimal.valueOf( 15_599L ) )
                .beschikbarePremie( BigDecimal.valueOf( 5L ) )
                .build();

        assertThat(caseCalculator.jaarlijksePremieStorting( dienstVerband )).isEqualTo( BigDecimal.valueOf( 3376.04 ) );
    }
}
