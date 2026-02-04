package io.reqres.api.context;

import io.restassured.response.Response;
import org.springframework.stereotype.Component;

@Component
public class ScenarioContext {
    private Response lastResponse;
    private String createdUserId; // можна додавати будь-які інші дані

    public Response getLastResponse() {
        return lastResponse;
    }

    public void setLastResponse(Response lastResponse) {
        this.lastResponse = lastResponse;
    }

    public String getCreatedUserId() {
        return createdUserId;
    }

    public void setCreatedUserId(String createdUserId) {
        this.createdUserId = createdUserId;
    }
}
