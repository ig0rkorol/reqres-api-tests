package io.reqres.api.context;

import io.restassured.response.Response;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Component
@Data
@ToString
@Getter @Setter
public class ScenarioContext {
    private Response lastResponse;
    private String jsonSchemaPath;
}
