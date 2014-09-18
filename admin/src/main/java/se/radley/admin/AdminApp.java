package se.radley.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import se.radley.domain.Domain;

@Configuration
@ComponentScan
@Import(Domain.class)
@EnableAutoConfiguration
@PropertySource({ "classpath:admin.properties" })
public class AdminApp implements EmbeddedServletContainerCustomizer {

	@Override
	public void customize(ConfigurableEmbeddedServletContainer container) {
		container.setContextPath("/admin");
	}

	/*@Bean
	public EmbeddedServletContainerCustomizer containerCustomizer() {
		return (container -> {
			container.addErrorPages(
				new ErrorPage(HttpStatus.UNAUTHORIZED, "/401.html"),
				new ErrorPage(HttpStatus.NOT_FOUND, "/404.html"),
				new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/500.html")
			);
		});
	}*/

	public static void main(String[] args) {
		SpringApplication.run(AdminApp.class, args);
	}
}

