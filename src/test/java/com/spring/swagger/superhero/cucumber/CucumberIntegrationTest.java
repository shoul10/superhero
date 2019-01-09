package com.spring.swagger.superhero.cucumber;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features", glue = {"com.spring.swagger.superhero"}, plugin = {"pretty", "html:target/cucumber"})
public class CucumberIntegrationTest {

}