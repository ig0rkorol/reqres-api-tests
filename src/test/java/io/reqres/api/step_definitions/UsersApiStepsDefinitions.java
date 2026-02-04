package io.reqres.api.step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.reqres.api.data.CreateUserRequest;
import io.reqres.api.step_library.UsersApiLibrary;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Log4j2
public class UsersApiStepsDefinitions  {
    @Autowired
    private UsersApiLibrary usersApiLibrary;

    private CreateUserRequest request;

    @Given("correct user data provided")
    public void correctUserDataProvided() {
        request = new CreateUserRequest("Igor", "QA Engineer");
    }

    @When("POST request is executed via Users endpoint")
    public void postRequestExecuted() {
        usersApiLibrary.createUser(request);
    }

    @Then("the response code should be {int}")
    public void verifyStatusCode(int expectedStatus) {
        assertEquals(
                expectedStatus,
                usersApiLibrary.getResponse().getStatusCode()
        );
    }

}