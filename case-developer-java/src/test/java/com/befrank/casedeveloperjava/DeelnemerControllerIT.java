package com.befrank.casedeveloperjava;

import com.befrank.casedeveloperjava.repositories.DeelnemerRepository;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.web.context.WebApplicationContext;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.when;
import static org.hamcrest.Matchers.equalTo;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
@Testcontainers
@ContextConfiguration(initializers = {DeelnemerControllerIT.Initializer.class})
class DeelnemerControllerIT {

    @Container
    private final static PostgreSQLContainer postgresqlContainer = new PostgreSQLContainer("postgres:15-alpine")
            .withDatabaseName("foo")
            .withUsername("foo")
            .withPassword("secret");

    static class Initializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {
        public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
            TestPropertyValues.of(
                    "spring.datasource.url=" + postgresqlContainer.getJdbcUrl(),
                    "spring.datasource.username=" + postgresqlContainer.getUsername(),
                    "spring.datasource.password=" + postgresqlContainer.getPassword()
            ).applyTo(configurableApplicationContext.getEnvironment());
        }
    }

    @Autowired
    private WebApplicationContext webApplicationContext;

    @BeforeEach
    void initialiseRestAssuredMockMvcWebApplicationContext() {
        RestAssuredMockMvc.webAppContextSetup(webApplicationContext);
    }

    @Autowired
    private DeelnemerRepository deelnemerRepository;
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
