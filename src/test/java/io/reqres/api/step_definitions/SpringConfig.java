package io.reqres.api.step_definitions;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan(basePackages = {"io.reqres.api"})
public class SpringConfig {
//    @Bean(name = "configProperties")
//    public ConfigProperties testConfigProperties() {
//        return new ConfigProperties();
//    }

}