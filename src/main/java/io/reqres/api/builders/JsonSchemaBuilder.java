package io.reqres.api.builders;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.victools.jsonschema.generator.*;
import com.github.victools.jsonschema.module.jackson.JacksonModule;
import com.github.victools.jsonschema.module.jakarta.validation.JakartaValidationModule;
import com.github.victools.jsonschema.module.javax.validation.JavaxValidationModule;
import com.github.victools.jsonschema.module.javax.validation.JavaxValidationOption;
import jakarta.annotation.Nullable;
import org.springframework.stereotype.Component;

import static com.github.victools.jsonschema.module.jackson.JacksonOption.RESPECT_JSONPROPERTY_ORDER;
import static com.github.victools.jsonschema.module.jackson.JacksonOption.RESPECT_JSONPROPERTY_REQUIRED;
import static com.github.victools.jsonschema.module.jakarta.validation.JakartaValidationOption.INCLUDE_PATTERN_EXPRESSIONS;
import static com.github.victools.jsonschema.module.jakarta.validation.JakartaValidationOption.NOT_NULLABLE_FIELD_IS_REQUIRED;

@Component
public class JsonSchemaBuilder {
    public String buildJSONSchema(Class clazz) {
        JacksonModule jacksonModule = new JacksonModule(RESPECT_JSONPROPERTY_REQUIRED, RESPECT_JSONPROPERTY_ORDER);
        JakartaValidationModule jakartaValidationModule = new JakartaValidationModule(NOT_NULLABLE_FIELD_IS_REQUIRED, INCLUDE_PATTERN_EXPRESSIONS);
        JavaxValidationModule javaxValidationModule = new JavaxValidationModule(JavaxValidationOption.NOT_NULLABLE_FIELD_IS_REQUIRED);

        SchemaGeneratorConfigBuilder configBuilder = new SchemaGeneratorConfigBuilder(SchemaVersion.DRAFT_2020_12, OptionPreset.PLAIN_JSON)
                .with(jacksonModule)
                .with(jakartaValidationModule)
                .with(javaxValidationModule);
        configBuilder.forFields()
                .withNullableCheck(field -> field.getAnnotationConsideringFieldAndGetter(Nullable.class) == null);

        SchemaGeneratorConfig config = configBuilder
                .with(Option.EXTRA_OPEN_API_FORMAT_VALUES)
                .with(Option.FLATTENED_ENUMS_FROM_TOSTRING)
                .build();

        SchemaGenerator generator = new SchemaGenerator(config);
        JsonNode jsonSchema = generator.generateSchema(clazz);
        return jsonSchema.toPrettyString();
    }

}
