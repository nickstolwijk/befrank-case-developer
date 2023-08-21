package com.befrank.casedeveloperjava.domain.model;

import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record PensioenRekening(BigDecimal huidigeWaarde)
{
}
