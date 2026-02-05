package io.reqres.api.hooks;

import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.spring.CucumberContextConfiguration;
import io.reqres.api.step_definitions.SpringConfig;
import org.springframework.test.context.ContextConfiguration;

@CucumberContextConfiguration
@ContextConfiguration(classes = {SpringConfig.class})
public class Hooks {

    public Hooks() {

    }

    @BeforeAll
    public static void setUp() {

    }

    @AfterAll
    public static void tearDownAll() {
    }
}