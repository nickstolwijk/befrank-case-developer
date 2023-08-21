package com.befrank.casedeveloperjava.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DienstVerband {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private BigDecimal fullTimeSalaris;
    private BigDecimal parttimePercentage;
    private BigDecimal franchise;
    private BigDecimal beschikbarePremie;

}
