package io.reqres.api.step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.reqres.api.context.ScenarioContext;
import io.restassured.response.Response;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Log4j2
public class CommonApiStepsDefinitions {

    @Autowired
    ScenarioContext scenarioContext;
    @And("response match JSON schema")
    public void responseMatchJsonSchema() {
        Response response = scenarioContext.getLastResponse();
        String schemaExpectedPath = scenarioContext.getJsonSchemaPath();
        assertThat(
                response.getBody().asString(),
                matchesJsonSchemaInClasspath(schemaExpectedPath)
        );
    }

    @Then("the response code should be {int}")
    public void verifyStatusCode(int expectedStatus) {
        assertEquals(
                expectedStatus,
                scenarioContext.getLastResponse().getStatusCode()
        );
    }
    @And("response error is {string}")
    public void verifyResponseError(String value) {
        String errorActual =  scenarioContext.getLastResponse().getBody().jsonPath().getString("error");
        assertThat(errorActual, equalTo(value));
    }
    @And("response message is {string}")
    public void verifyResponseMessage(String value) {
        String messageActual =  scenarioContext.getLastResponse().getBody().jsonPath().getString("message");
        assertThat(messageActual, equalTo(value));
    }


}
