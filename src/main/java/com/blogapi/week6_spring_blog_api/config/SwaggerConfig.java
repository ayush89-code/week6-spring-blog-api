package com.blogapi.week6_spring_blog_api.config;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
    info = @Info(
        title = "Blog Management API",
        description = "RESTful API for managing blog posts, categories, and comments",
        version = "1.0.0",
        contact = @Contact(name = "Ayush Mourya", email = "ayush@example.com"),
        license = @License(name = "Apache 2.0", url = "https://www.apache.org/licenses/LICENSE-2.0")
    ),
    servers = {
        @Server(url = "http://localhost:8080", description = "Development"),
        @Server(url = "${spring.profiles.active:prod-server}", description = "Production")
    }
)
public class SwaggerConfig {
}

