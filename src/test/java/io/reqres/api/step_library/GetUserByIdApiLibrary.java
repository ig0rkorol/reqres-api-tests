package io.reqres.api.step_library;

import io.restassured.response.Response;
import org.springframework.stereotype.Component;

@Component
public class GetUserByIdApiLibrary extends BaseApiLibrary {

    private static final String USERS_PATH = "/api/users/{id}";

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
