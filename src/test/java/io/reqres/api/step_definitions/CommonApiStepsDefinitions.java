package io.reqres.api.step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.reqres.api.context.ScenarioContext;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CommonApiStepsDefinitions {

    @Autowired
    ScenarioContext scenarioContext;
    @And("response match JSON schema")
    public void responseMatchJsonSchema() {
//        request = new CreateUserRequest("Igor", "QA Engineer");
    }

    @Then("the response code should be {int}")
    public void verifyStatusCode(int expectedStatus) {
        assertEquals(
                expectedStatus,
                scenarioContext.getLastResponse().getStatusCode()
        );
    }
}
