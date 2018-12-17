package com.softtech.cloud.service;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping(path = "/api/person", produces = APPLICATION_JSON_UTF8_VALUE)
public class PersonService {

    @GetMapping()
    public Page<Person> findAll(final Pageable pageable) {
        throw new UnsupportedOperationException();
    }

    @PostMapping()
    public Person create(@RequestBody Person person) {
        throw new UnsupportedOperationException();
    }

    @GetMapping("{id}")
    public Person findById(String id) {
        throw new UnsupportedOperationException();
    }

    @PutMapping("{id}")
    public Person update(@PathVariable(name = "id", required = true) String id, @RequestBody Person person) {
        throw new UnsupportedOperationException();
    }

    @DeleteMapping("{id}")
    public Person delete(@PathVariable(name = "id", required = true) String id) {
        throw new UnsupportedOperationException();
    }

}
