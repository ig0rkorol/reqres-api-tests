package io.reqres.api;

import org.junit.platform.suite.api.*;
import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;

@Suite
@IncludeEngines("cucumber")
@SelectDirectories("src/test/java/io/reqres/api/features")
@ConfigurationParameter(
        key = GLUE_PROPERTY_NAME,
//        value = "io.reqres.api.step_definitions")
        value = "io.reqres.api")
public class RunCucumberTest {
}


