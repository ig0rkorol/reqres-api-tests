package io.reqres.api.factory;

import io.reqres.api.data.CreateUserRequest;

public class UsersFactory {

    public static CreateUserRequest addUserRequestData(){
        return new CreateUserRequest("Igor", "QA Engineer");
    }

}
