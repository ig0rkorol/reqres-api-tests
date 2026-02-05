package io.reqres.api.step_library;

import io.reqres.api.builders.JsonSchemaBuilder;
import io.restassured.response.Response;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetUserByIdApiLibrary extends BaseApiLibrary {

    private static final String USERS_PATH = "/api/users/{id}";


    @Autowired
    JsonSchemaBuilder jsonSchemaBuilder;
    @PostConstruct
    private void initUsersPath() {
    }

    public void getUserById(String id) {
        Response response = requestSpec
                .given()
                .with().pathParam("id", id)
                .when()
                .get(USERS_PATH);
        setResponse(response);
        response.prettyPrint();
    }

    public String getJsonSchemaPath(){
        return "jsonschema/GetUserResponseSchema.json";
    }

}
