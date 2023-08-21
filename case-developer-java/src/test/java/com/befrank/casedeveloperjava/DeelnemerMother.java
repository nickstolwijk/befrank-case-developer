package com.befrank.casedeveloperjava;

import com.befrank.casedeveloperjava.domain.model.Deelnemer;
import com.befrank.casedeveloperjava.domain.model.DienstVerband;

import java.math.BigDecimal;
import java.time.LocalDate;

public final class DeelnemerMother {
    private DeelnemerMother() {

    }


    public static Deelnemer janeDoe() {
        return Deelnemer.builder()
                .naam( Deelnemer.Naam.builder()
                        .voornaam( "Jane" )
                        .achternaam( "Doe" )
                        .build() )
                .adres( Deelnemer.Adres.builder()
                        .straat( "Sesamstraat" )
                        .huisnummer( "1A" )
                        .woonplaats( "Hilversum" )
                        .build())
                .emailAdres( Deelnemer.EmailAdres.builder()
                        .emailAdres( "janedoe@example.com" )
                        .build() )
                .geboorteDatum( LocalDate.now().minusYears( 60 ) )
                .dienstVerband( DienstVerband.builder()
                        .fullTimeSalaris( BigDecimal.valueOf(100_000))
                        .parttimePercentage( new BigDecimal( 80 ) )
                        .franchise( BigDecimal.valueOf( 15_599 ) )
                        .beschikbarePremie( BigDecimal.valueOf( 3 ) )
                        .build() )
                .pensioenRekeningNummer( Deelnemer.PensioenRekeningNummer.builder()
                        .pensioenRekeningNummer( "123.456" )
                        .build() )
                .build();
    }

    public static Deelnemer johnDoe() {
        return Deelnemer.builder()
                .naam( Deelnemer.Naam.builder()
                        .voornaam( "John" )
                        .achternaam( "Doe" )
                        .build() )
                .adres( Deelnemer.Adres.builder()
                        .straat( "Privet Drive" )
                        .huisnummer( "4" )
                        .woonplaats( "Little Whinging" )
                        .build())
                .emailAdres( Deelnemer.EmailAdres.builder()
                        .emailAdres( "johndoe@example.com" )
                        .build() )
                .build();
    }
}
