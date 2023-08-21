package com.befrank.casedeveloperjava.domain.model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

import static jakarta.persistence.GenerationType.IDENTITY;

@Embeddable
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DienstVerband {
    private BigDecimal fullTimeSalaris;
    private BigDecimal parttimePercentage;
    private BigDecimal franchise;
    private BigDecimal beschikbarePremie;

}
