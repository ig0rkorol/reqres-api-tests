package io.reqres.api.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CreateUserResponse {

    private String name;
    private String job;
    private String id;
    private String createdAt;
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
