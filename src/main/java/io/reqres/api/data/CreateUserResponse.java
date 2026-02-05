package io.reqres.api.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CreateUserResponse {

//    @JsonProperty(value = "name", required = true)
    private String name;
//    @JsonProperty(value = "job", required = true)
    private String job;
//    @JsonProperty(value = "id", required = true)
    private String id;
//    @JsonProperty(value = "createdAt", required = true)
    private String createdAt;
//    @JsonProperty(value = "_meta", required = true)
    private Meta _meta;

    @Data
    public static class Meta {
        private String powered_by;
        private String docs_url;
        private String upgrade_url;
        private String example_url;
        private String variant;
        private String message;
        private Cta cta;
        private String context;
    }

    @Data
    public static class Cta {
        private String label;
        private String url;
    }
}
