package io.reqres.api.step_library;

import io.reqres.api.builders.JsonSchemaBuilder;
import io.reqres.api.data.CreateUserRequest;
import io.reqres.api.data.CreateUserResponse;
import io.restassured.response.Response;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UsersApiLibrary extends BaseApiLibrary {

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

}
