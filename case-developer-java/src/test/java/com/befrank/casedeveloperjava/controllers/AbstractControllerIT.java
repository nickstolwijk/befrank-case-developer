package com.befrank.casedeveloperjava.controllers;

import io.restassured.module.mockmvc.RestAssuredMockMvc;
import io.restassured.path.json.config.JsonPathConfig;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.web.context.WebApplicationContext;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import static io.restassured.config.JsonConfig.jsonConfig;
import static io.restassured.module.mockmvc.config.RestAssuredMockMvcConfig.newConfig;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
@Testcontainers
@ContextConfiguration(initializers = {DeelnemerControllerIT.Initializer.class})
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
class AbstractControllerIT {
    @Container
    private final static PostgreSQLContainer postgresqlContainer = new PostgreSQLContainer(
            "postgres:15-alpine" ).withDatabaseName( "foo" ).withUsername( "foo" ).withPassword( "secret" );
    @Autowired
    private WebApplicationContext webApplicationContext;

    @BeforeEach
    void initialiseRestAssuredMockMvcWebApplicationContext() {
        RestAssuredMockMvc.webAppContextSetup( webApplicationContext );
        RestAssuredMockMvc.config = newConfig().jsonConfig(jsonConfig().numberReturnType( JsonPathConfig.NumberReturnType.BIG_DECIMAL));
    }

    static class Initializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {
        public void initialize( ConfigurableApplicationContext configurableApplicationContext ) {
            TestPropertyValues.of( "spring.datasource.url=" + postgresqlContainer.getJdbcUrl(),
                    "spring.datasource.username=" + postgresqlContainer.getUsername(),
                    "spring.datasource.password=" + postgresqlContainer.getPassword() ).applyTo(
                    configurableApplicationContext.getEnvironment() );
        }
    }
}
