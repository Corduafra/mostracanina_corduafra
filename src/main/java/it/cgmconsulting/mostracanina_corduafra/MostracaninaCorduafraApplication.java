package it.cgmconsulting.mostracanina_corduafra;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class MostracaninaCorduafraApplication {

	public static void main(String[] args) {
		SpringApplication.run(MostracaninaCorduafraApplication.class, args);
	}

}
