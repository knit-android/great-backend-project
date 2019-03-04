package pl.edu.pk.knit.android.backend.webservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource({
		"classpath:application.properties",
		"classpath:db-connection.properties"
})
public class WebserviceApplication {

	public static void main(String[] args) {

		SpringApplication.run(WebserviceApplication.class, args);

	}

}
