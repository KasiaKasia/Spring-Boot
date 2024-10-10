package com.example.demo;

import com.example.demo.person.dto.PersonDTO;
import com.example.demo.person.generator.PersonGenerator;
import com.example.demo.person.services.PersonService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import java.util.List;

@SpringBootApplication
public class DemoApplication {

	private static final int NUMBER_OF_NEW_PERSONS =10;

	@Bean
	public RestTemplate testTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Bean
	public CommandLineRunner run(RestTemplate restTemplate)  throws Exception {
		return args -> {
			for (int i = 0; i < NUMBER_OF_NEW_PERSONS; i++) {
				var person = PersonGenerator.generate();
				restTemplate.postForEntity("http://localhost:8083/persons", person, String.class);
			}
		};
	}

	public static void main(String[] args) {

		ApplicationContext appCtx = SpringApplication.run(DemoApplication.class, args);
		PersonService service = appCtx.getBean(PersonService.class);
		List<PersonDTO> persons = service.findAll();
		persons.forEach(System.out::println);

		PersonDTO firstPerson = service.findById(1);
		System.out.println("First person  "+firstPerson);
	}
}
