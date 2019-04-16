package com.master.group.application.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "apps.master.group.config")
public class ApplicationProperties {
    private RestApi rest;

    @Data
    public static class RestApi{
        private String apiUri;
    }

}
