package io.reqres.api.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Data
@Component
@PropertySource("classpath:config.properties")
@ConfigurationProperties(prefix = "api")
public class ConfigProperties {

    @Value("${base.url}")
    private String baseUrl;

    @Value("${x.api.key}")
    private String xApiKey;


}
