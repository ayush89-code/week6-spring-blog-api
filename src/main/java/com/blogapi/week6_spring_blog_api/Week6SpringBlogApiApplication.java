package com.blogapi.week6_spring_blog_api;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Blog Management API", version = "1.0",
description = "REST API for Blog Posts, Categories, Comments"))
public class Week6SpringBlogApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(Week6SpringBlogApiApplication.class, args);
	}

}
