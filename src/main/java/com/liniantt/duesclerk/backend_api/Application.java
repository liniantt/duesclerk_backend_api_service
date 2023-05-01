package com.liniantt.duesclerk.backend_api;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "DuesClerk",
				description = "DuesClerk Web and backend API service",
				version = "1.0.0",
				termsOfService = "Terms of service will be updated soon.",
				contact = @Contact(
						name = "DAVID KARIUKI",
						email = "dkaris.k@gmail.com"
				),
				license = @License(
						name = "Apache Licence 2.0",
						url = "https://www.apache.org/licenses/LICENSE-2.0"
				)
		),
		tags = @Tag(
				name = "DuesClerk",
				description = "Application to manage dues for personal and business use"
		),
		externalDocs = @ExternalDocumentation(
				url = "https://github.com/liniantt/duesclerk_backend_api_service",
				description = "Opensource Documentation"
		)
)
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
