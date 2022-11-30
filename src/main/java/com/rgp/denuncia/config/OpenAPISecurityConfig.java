package com.rgp.denuncia.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;
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
                        url = "http://localhost:8080",
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
public class OpenAPISecurityConfig {
}