package com.befrank.casedeveloperjava.domain.model;


import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Deelnemer {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Embedded
    private Naam naam;

    @Embedded
    private Adres adres;

    @Embedded
    private EmailAdres emailAdres;

    private LocalDate geboorteDatum;

    @Embeddable
    @Builder
    public record Naam(String voornaam, String tussenvoegsel, String achternaam) {
    }

    @Embeddable
    @Builder
    public record Adres(String straat, String huisnummer, String woonplaats) {
    }
    @Embeddable
    @Builder
    public record EmailAdres(String emailAdres) {
    }
}
