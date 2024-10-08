package com.vetconnect.vetconnect.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.servers.Server;

import java.util.Arrays;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .servers(Arrays.asList(
                        new Server().url("https://accurate-adventure-production.up.railway.app").description("Production server"), // URL de producción
                        new Server().url("http://localhost:8080").description("Local server") // URL local
                ))
                .info(new Info()
                        .title("VetConnect API")
                        .version("1.0")
                        .description("API para la gestión de reservas, reseñas, dueños de mascotas y centros veterinarios.")
                        .license(new License().name("Apache 2.0").url("https://springdoc.org")));
    }
}
