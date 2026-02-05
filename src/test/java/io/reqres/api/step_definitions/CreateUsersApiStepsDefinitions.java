package io.reqres.api.step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.reqres.api.context.ScenarioContext;
import io.reqres.api.data.CreateUserRequest;
import io.reqres.api.step_library.CreateUsersApiLibrary;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;

@Log4j2
public class CreateUsersApiStepsDefinitions {
    @Autowired
    private CreateUsersApiLibrary createUsersApiLibrary;
    @Autowired
    ScenarioContext scenarioContext;

    private CreateUserRequest request;

    @Given("correct user data provided")
    public void correctUserDataProvided() {
        request = new CreateUserRequest("Igor", "QA Engineer");
        scenarioContext.setJsonSchemaPath(createUsersApiLibrary.getJsonSchemaPath());
    }

    @When("POST request is executed via Users endpoint")
    public void postRequestExecuted() {
        createUsersApiLibrary.createUser(request);
        scenarioContext.setLastResponse(createUsersApiLibrary.getResponse());
    }



}