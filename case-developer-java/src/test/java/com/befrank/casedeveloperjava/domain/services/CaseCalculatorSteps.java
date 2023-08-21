package com.befrank.casedeveloperjava.domain.services;

import com.befrank.casedeveloperjava.domain.model.Deelnemer;
import com.befrank.casedeveloperjava.domain.model.DienstVerband;
import com.befrank.casedeveloperjava.domain.model.PensioenRekening;
import com.befrank.casedeveloperjava.domain.services.CaseCalculator;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

public class CaseCalculatorSteps {

    private final Deelnemer.DeelnemerBuilder deelnemerBuilder = Deelnemer.builder();

    private final DienstVerband.DienstVerbandBuilder dienstVerbandBuilder = DienstVerband.builder();
    private final PensioenRekening.PensioenRekeningBuilder pensioenRekeningBuilder = PensioenRekening.builder();
    private BigDecimal rendement;

    @Given( "een deelnemer met de naam {word} {word}" )
    public void eenDeelnemerMetDeNaam(final String voornaam, final String achternaam) {
        deelnemerBuilder.naam(
            Deelnemer.Naam.builder()
                .voornaam( voornaam )
                .achternaam( achternaam )
                .build()
        );
    }

    @Given( "de deelnemer is {int} jaar oud" )
    public void deDeelnemerIsJaarOud(final int leeftijd) {
        deelnemerBuilder.geboorteDatum( LocalDate.now().minusYears( leeftijd ) );
    }

    @Given( "een huidige waarde van {bigdecimal} euro" )
    public void eenHuidigeWaardeVan(final BigDecimal huidigeWaarde) {
        pensioenRekeningBuilder.huidigeWaarde( huidigeWaarde );
    }

    @Given( "een full-time salaris van {bigdecimal} euro" )
    public void eenFullTimeSalarisVan(final BigDecimal fullTimeSalaris ) {
        dienstVerbandBuilder.fullTimeSalaris( fullTimeSalaris );
    }

    @Given( "een part-time percentage van {bigdecimal}%" )
    public void eenPartTimePercentageVan(final BigDecimal partTimePercentage ) {
        dienstVerbandBuilder.parttimePercentage( partTimePercentage );
    }

    @Given( "een franchise van {bigdecimal} euro" )
    public void eenFranchiseVan(final BigDecimal franchise ) {
        dienstVerbandBuilder.franchise(franchise);
    }

    @Given( "een beschikbare premie percentage van {bigdecimal}%" )
    public void eenBeschikbarePremiePercentageVan(final BigDecimal premiePercentage ) {
        dienstVerbandBuilder.beschikbarePremie( premiePercentage );
    }

    @Given( "een rendement van {bigdecimal}% per jaar" )
    public void eenRendementVanPerJaar(final BigDecimal rendement ) {
        this.rendement = rendement;
    }

    @When( "een gewenste pensioenleeftijd van {int} jaar" )
    public void eenGewenstePensioenleeftijdVanJaar(final int pensioenLeeftijd ) {

    }

    @Then( "een verwachte waarde op pensioendatum van {bigdecimal} euro" )
    public void eenVerwachteWaardeOpPensioendatumVanEuro(final BigDecimal verwachteWaarde ) {

        var caseCalculator = new CaseCalculator();

        assertThat(caseCalculator.calculate(dienstVerbandBuilder.build(), pensioenRekeningBuilder.build(), rendement)).isEqualTo( verwachteWaarde );
    }
}
