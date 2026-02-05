package io.reqres.api.testdata;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "api")
public class TestDataProperties {

    @Value("${user.exist.id}")
    private String userExistId;

    @Value("${userid.not.exist}")
    private String userIdNotExist;
}
