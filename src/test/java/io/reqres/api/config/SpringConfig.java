package io.reqres.api.config;

import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@PropertySources({
        @PropertySource("classpath:environment/${env:dev}/config.properties"),
        @PropertySource("classpath:environment/${env:dev}/testdata.properties")
})
@ComponentScan(basePackages = {"io.reqres.api"})
@Log4j2
public class SpringConfig {
    static {
        String env = System.getProperty("env", "dev");
        log.info("Running tests with environment: {}", env);
    }

    public static PropertySourcesPlaceholderConfigurer propertyConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
