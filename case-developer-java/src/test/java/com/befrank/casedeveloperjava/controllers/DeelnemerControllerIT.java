package com.befrank.casedeveloperjava.controllers;

import com.befrank.casedeveloperjava.DeelnemerMother;
import com.befrank.casedeveloperjava.repositories.jpa.DeelnemerSpringDataRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.when;
import static org.hamcrest.Matchers.equalTo;


class DeelnemerControllerIT extends AbstractControllerIT {

    @Autowired
    private DeelnemerSpringDataRepository deelnemerRepository;
    @Test
    void call_to_controller_returns_deelnemer() {
        var janeDoe = deelnemerRepository.save( DeelnemerMother.janeDoe() );

        when()
            .get("/deelnemer/{id}", janeDoe.getId() )
        .then()
            .statusCode( 200 )
            .body( "naam.voornaam", equalTo( janeDoe.getNaam().voornaam() ) )
            .body( "naam.achternaam", equalTo( janeDoe.getNaam().achternaam() ) );
    }

    @Test
    void call_to_controller_returns_all_deelnemers() {
        var janeDoe = deelnemerRepository.save( DeelnemerMother.janeDoe() );
        var johnDoe = deelnemerRepository.save( DeelnemerMother.johnDoe() );

        when()
            .get("/deelnemer")
        .then()
            .statusCode( 200 )
            .body( "naam[0].voornaam", equalTo( janeDoe.getNaam().voornaam()) )
            .body( "naam[0].achternaam", equalTo( janeDoe.getNaam().achternaam()) )
            .body( "naam[1].voornaam", equalTo( johnDoe.getNaam().voornaam()) )
            .body( "naam[1].achternaam", equalTo( johnDoe.getNaam().achternaam()) );
    }
}
