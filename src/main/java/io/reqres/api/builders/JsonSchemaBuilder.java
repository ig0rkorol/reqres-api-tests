package io.reqres.api.builders;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.victools.jsonschema.generator.*;
import org.springframework.stereotype.Component;

@Component
public class JsonSchemaBuilder {

    public static String buildJSONSchema(Class clazz) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();

            SchemaGeneratorConfigBuilder configBuilder =
                    new SchemaGeneratorConfigBuilder(objectMapper, SchemaVersion.DRAFT_7, OptionPreset.PLAIN_JSON);

            SchemaGenerator generator = new SchemaGenerator(configBuilder.build());

            com.fasterxml.jackson.databind.JsonNode jsonSchema = generator.generateSchema(clazz);

            return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonSchema);

        } catch (Exception e) {
            throw new RuntimeException("Failed to generate JSON schema for class " + clazz.getSimpleName(), e);
        }
    }

}
