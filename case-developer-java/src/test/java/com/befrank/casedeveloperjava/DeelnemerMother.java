package com.befrank.casedeveloperjava;

import com.befrank.casedeveloperjava.domain.model.Deelnemer;

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
