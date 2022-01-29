package com.omerozturk.N11GraduationProject.gen.configuration;


import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfiguration {
    @Bean
    public OpenAPI springShopOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("N11Graduation API")
                        .description("N11 Graduation Project Application")
                        .version("v0.0.1")
                        .license(new License().name("Ömer Öztürk").url("https://github.com/n11-TalentHub-Java-Bootcamp/n11-talenthub-bootcamp-graduation-project-omerozturk18")))
                .externalDocs(new ExternalDocumentation()
                        .description("N11Graduation Documentation")
                        .url("https://github.com/n11-TalentHub-Java-Bootcamp/n11-talenthub-bootcamp-graduation-project-omerozturk18/blob/main/README.md"));
    }
}
