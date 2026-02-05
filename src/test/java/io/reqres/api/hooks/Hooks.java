package io.reqres.api.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.reqres.api.context.ScenarioContext;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;

@Log4j2
public class Hooks {
    @Autowired
    private ScenarioContext scenarioContext;
    @Before
    public void beforeScenario(Scenario scenario) {
        log.info("◀ START scenario: {}", scenario.getName());
    }

    @After
    public void afterScenario(Scenario scenario) {
        log.info("▶ END scenario: {} | status={}",
                scenario.getName(),
                scenario.getStatus());
    }
}
