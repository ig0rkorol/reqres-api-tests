package io.reqres.api.config;

import io.cucumber.spring.CucumberContextConfiguration;
import io.reqres.api.config.SpringConfig;
import org.springframework.test.context.ContextConfiguration;

@CucumberContextConfiguration
@ContextConfiguration(classes = SpringConfig.class)
public class CucumberSpringConfiguration {
}