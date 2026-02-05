package io.reqres.api.step_library;

import io.reqres.api.builders.JsonSchemaBuilder;
import io.reqres.api.data.CreateUserRequest;
import io.restassured.response.Response;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class CreateUsersApiLibrary extends BaseApiLibrary {

    private static final String USERS_PATH = "/api/users";


    @Autowired
    JsonSchemaBuilder jsonSchemaBuilder;
    @PostConstruct
    private void initUsersPath() {
    }

    public void createUser(CreateUserRequest request) {
        Response response = requestSpec
                            .body(request)
                            .post(USERS_PATH);

        setResponse(response);
        response.prettyPrint();
    }

    public String getJsonSchemaPath(){
        return "jsonschema/CreateUserResponseSchema.json";
    }

    public void createUserWithoutBodyRequest() {
        Response response = requestSpec.body("fake json data").post(USERS_PATH);
        setResponse(response);
        response.prettyPrint();
    }
}
