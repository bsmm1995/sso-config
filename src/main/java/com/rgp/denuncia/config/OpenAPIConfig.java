package com.rgp.denuncia.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "RGP DENUNCIA API",
                version = "1.0.0",
                contact = @Contact(
                        name = "Pegasus", email = "info@pegasus.com", url = "https://www.pegasus.cl/"
                ),
                license = @License(
                        name = "OpenApi YML", url = "http://localhost:8080/v3/api-docs.yaml"
                ),
                termsOfService = "Rgp",
                description = "Sistema de gestión penal"
        ),
        servers = {
                @Server(
                        url = "http://localhost:${server.port:8080}${server.servlet.context-path:/}",
                        description = "Local"
                ),
                @Server(
                        url = "http://backend-dev.minpublico.com/api/v1/mp/rgp/denuncia",
                        description = "Development"
                ),
                @Server(
                        url = "http://backend-test.minpublico.com/api/v1/mp/rgp/denuncia",
                        description = "Staging"
                ),
                @Server(
                        url = "http://backend-prd.minpublico.com/api/v1/mp/rgp/denuncia",
                        description = "Production"
                )}
)
public class OpenAPIConfig {
    @Bean
    public OpenAPI customizeOpenAPI() {
        final String securitySchemeName = "bearerAuth";
        return new OpenAPI()
                .addSecurityItem(new SecurityRequirement()
                        .addList(securitySchemeName))
                .components(new Components()
                        .addSecuritySchemes(securitySchemeName, new SecurityScheme()
                                .name(securitySchemeName)
                                .type(SecurityScheme.Type.HTTP)
                                .scheme("bearer")
                                .bearerFormat("JWT")));
    }
}
