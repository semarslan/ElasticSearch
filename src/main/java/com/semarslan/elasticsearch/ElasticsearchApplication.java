package com.semarslan.elasticsearch;

import com.semarslan.elasticsearch.entity.Person;
import com.semarslan.elasticsearch.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

import java.util.Date;
import java.util.UUID;

@SpringBootApplication
@EnableElasticsearchRepositories
public class ElasticsearchApplication {

	@Autowired
	PersonRepository personRepository;

	public static void main(String[] args) {
		SpringApplication.run(ElasticsearchApplication.class, args);
	}

	@Bean
	CommandLineRunner createPerson() {
		return (args -> {
			for (int i=1; i<=5; i++) {
				Person person = new Person();
				person.setId(UUID.randomUUID().toString());
				person.setName("Name" + i);
				person.setLastName("Lastname" + i);
				person.setAddress("Address" + i);
				person.setBirthDate(new Date());
				personRepository.save(person);
			}
		});
	}
}
