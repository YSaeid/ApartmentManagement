package app.apartment.management.apartmentmanagement.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(info = @Info(
        title = "Apartment Management API",
        description = "Apartment Management Swagger Api for easy using",
        contact = @Contact(
                name = "Saeid Yazdani(Backend) & Mohammad Erfan Karami(Frontend)",
                email = "saeidyazdany@gmail.com"
        ),
        license = @License(
                name = "Open Licence"
        ),
        version = "v1")
)
//@SecurityScheme(
//        name = "bearerAuth",
//        type = SecuritySchemeType.HTTP,
//        bearerFormat = "JWT",
//        scheme = "bearer"
//)
public class SwaggerConfig {

    @Bean
    public GroupedOpenApi userApi() {
        return GroupedOpenApi.builder()
                .group("User")
                .pathsToMatch("/api/v1/users/".concat("**"))
                .build();
    }
}
