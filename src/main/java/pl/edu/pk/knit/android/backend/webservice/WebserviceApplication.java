package pl.edu.pk.knit.android.backend.webservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@SpringBootApplication
@EnableWebMvc
@PropertySource({
		"classpath:application.properties",
		"classpath:db-connection.properties"
})
public class WebserviceApplication {

	public static void main(String[] args) {

		SpringApplication.run(WebserviceApplication.class, args);

	}


}
