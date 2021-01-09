package com.semarslan.elasticsearch.controller;

import com.semarslan.elasticsearch.entity.Person;
import com.semarslan.elasticsearch.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/person")
public class PersonController {

    private final PersonRepository personRepository;

    @GetMapping("/{search}")
    public ResponseEntity<List<Person>> getPersonESQ(@PathVariable String search) {

        List<Person> people = personRepository.getByCustomQuery(search);
        return ResponseEntity.ok(people);
    }

    @GetMapping("/{search}")
    public ResponseEntity<List<Person>> getPerson(@PathVariable String search) {

        List<Person> people = personRepository.findByNameLikeOrLastNameLike(search, search);
        return ResponseEntity.ok(people);
    }
}
