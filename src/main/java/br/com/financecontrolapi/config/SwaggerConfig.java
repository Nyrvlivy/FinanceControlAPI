package br.com.financecontrolapi.config;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
        info = @Info(
                title = "Finance Control API",
                version = "1.0.0",
                description = "Java RESTful API, built with Spring Boot for financial transaction management, featuring batch " +
                        "and individual transaction handling, CRUD operations, and date-based data filtering. Integration with Angular web app.",
                license = @License(
                        name = "MIT License",
                        url = "https://opensource.org/licenses/MIT"),
                contact = @Contact(
                        name = "Bruna Massi",
                        email = "dev.brunamassi@example.com"
                )
        ),
        servers = @Server(url = "/", description = "Principal Server"),
        externalDocs = @ExternalDocumentation(
                description = "Finance Control API - GitHub repository",
                url = "https://github.com/Nyrvlivy/FinanceControlAPI"
        )
)
public class SwaggerConfig {
}
