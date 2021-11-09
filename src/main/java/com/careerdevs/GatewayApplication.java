package com.careerdevs;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
@RestController
public class GatewayApplication {

	private static final String MY_API_KEY = "VD4aSgn9cxh7HPv0NQ0ygecENulZjl182e8mAsNX";

	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

 	@GetMapping("/")
	public String rootRoute() {
		return "Welcome Home!";
	}

	@GetMapping("/apod")
	public APOD apodInfo(RestTemplate restTemplate) {
		String URL = "https://api.nasa.gov/planetary/apod?api_key=";

		APOD apod = restTemplate.getForObject(URL, APOD.class);

		return apod;
	}

}
