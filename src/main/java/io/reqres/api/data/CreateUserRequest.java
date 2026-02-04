package io.reqres.api.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
public class CreateUserRequest {
    String name;
    String job;
}
