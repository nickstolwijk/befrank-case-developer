package com.befrank.casedeveloperjava.controllers;

import com.befrank.casedeveloperjava.domain.services.CaseService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/case")
@AllArgsConstructor
public class CaseController {

    private final CaseService caseService;

    @GetMapping("/{id}")
    public Case calculate( @PathVariable Long id, @RequestParam int verwachtePensioenLeeftijd ) {
        BigDecimal verwachteWaarde = caseService.calculate( id, verwachtePensioenLeeftijd );
        return new Case( verwachteWaarde );
    }

    public record Case(BigDecimal verwachteWaarde) {}
}
