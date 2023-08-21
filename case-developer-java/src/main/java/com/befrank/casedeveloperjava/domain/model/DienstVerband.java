package com.befrank.casedeveloperjava.domain.model;

import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record DienstVerband(BigDecimal fullTimeSalaris, BigDecimal parttimePercentage, BigDecimal franchise, BigDecimal beschikbarePremie)
{
}
