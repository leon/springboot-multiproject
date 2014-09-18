package se.radley.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import se.radley.admin.AdminApp;
import se.radley.domain.Domain;

@Configuration
@ComponentScan
@Import(Domain.class)
@EnableAutoConfiguration
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	/*
	// How Do I launch both the main app mapped to / and admin app mapped to /admin?

	public static void main(String[] args) {
		//new SpringApplicationBuilder()
		//	.showBanner(false)
		//	.sources(Domain.class, Application.class, Webshop.class)
		//	.sibling(Application.class, Webshop.class)
		//	.run(args);

		new SpringApplicationBuilder(Application.class)
			.showBanner(false)
			.sibling(Domain.class)
			.child(AdminApp.class)
			.run(args);
	}*/
}
