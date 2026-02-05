package io.reqres.api.step_library;

import io.reqres.api.builders.JsonSchemaBuilder;
import io.reqres.api.config.ConfigProperties;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;


public abstract class BaseApiLibrary {
    @Autowired
    private JsonSchemaBuilder jsonSchemaBuilder;

    @Autowired
    protected ConfigProperties configProperties;
    protected RequestSpecification requestSpec;
    protected Response response;

    @PostConstruct
    protected void initBaseClient() {
        this.requestSpec = RestAssured
                .given()
                .baseUri(configProperties.getBaseUrl())
                .contentType("application/json")
                .header("x-api-key", configProperties.getXApiKey());

    }

    protected void setResponse(Response response) {
        this.response = response;
    }

    public Response getResponse() {
        return response;
    }

    public String getEndpointSchema(Class clazz) {
        return jsonSchemaBuilder.buildJSONSchema(clazz);
    }
}
