package io.reqres.api.step_library;

import io.reqres.api.data.CreateUserRequest;
import io.restassured.response.Response;
import org.springframework.stereotype.Component;

@Component
public class CreateUsersApiLibrary extends BaseApiLibrary {

    private static final String USERS_PATH = "/api/users";

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
