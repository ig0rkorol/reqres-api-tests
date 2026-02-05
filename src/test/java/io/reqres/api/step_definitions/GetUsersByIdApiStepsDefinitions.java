package io.reqres.api.step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.reqres.api.context.ScenarioContext;
import io.reqres.api.step_library.GetUserByIdApiLibrary;
import io.reqres.api.testdata.TestDataProperties;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;

@Log4j2
public class GetUsersByIdApiStepsDefinitions {
    @Autowired
    private GetUserByIdApiLibrary getUserByIdApiLibrary;
    @Autowired
    ScenarioContext scenarioContext;

    @Autowired
    TestDataProperties testDataProperties;

    String id;

    @Given("correct user id provided")
    public void correctUserIdProvided() {
        id = testDataProperties.getUserExistId();
        scenarioContext.setJsonSchemaPath(getUserByIdApiLibrary.getJsonSchemaPath());
    }

    @When("GET request is executed via Retrieve User by Id endpoint")
    public void getUserByIdRequestExecuted() {
        getUserByIdApiLibrary.getUserById(id);
        scenarioContext.setLastResponse(getUserByIdApiLibrary.getResponse());
    }

}
