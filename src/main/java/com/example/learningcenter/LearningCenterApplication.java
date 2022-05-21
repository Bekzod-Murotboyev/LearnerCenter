package com.example.learningcenter;

import com.example.learningcenter.config.openApiConfig.OpenApiProperties;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@OpenAPIDefinition
@EnableConfigurationProperties({
        OpenApiProperties.class
})
public class LearningCenterApplication {

    public static void main(String[] args) {
        SpringApplication.run(LearningCenterApplication.class, args);
    }

}
