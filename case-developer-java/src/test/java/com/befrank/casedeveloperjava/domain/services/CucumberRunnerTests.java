package com.befrank.casedeveloperjava.domain.services;

import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;
import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("com/befrank/casedeveloperjava/domain/services")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "com/befrank/casedeveloperjava/domain/services")

public class CucumberRunnerTests  {

}
