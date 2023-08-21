package com.befrank.casedeveloperjava.controllers;

import com.befrank.casedeveloperjava.DeelnemerMother;
import com.befrank.casedeveloperjava.repositories.jpa.DeelnemerSpringDataRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static org.hamcrest.Matchers.equalTo;

class CaseControllerIT extends AbstractControllerIT {

    @Autowired
    private DeelnemerSpringDataRepository deelnemerRepository;
    @Test
    void call_to_controller_returns_calculated_case() {
        var janeDoe = deelnemerRepository.save( DeelnemerMother.janeDoe() );

        given()
            .param( "verwachtePensioenLeeftijd", 65 ).
        when()
            .get("/case/{id}", janeDoe.getId() )
        .then()
            .statusCode( 200 )
            .body( "verwachteWaarde", equalTo( BigDecimal.valueOf( 3320.33 ) ) );
    }
}
