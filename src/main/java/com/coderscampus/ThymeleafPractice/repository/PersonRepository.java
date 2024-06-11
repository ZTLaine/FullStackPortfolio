package com.coderscampus.ThymeleafPractice.repository;

import com.coderscampus.ThymeleafPractice.domain.Person;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class PersonRepository {
    private Map<Integer, Person> people = new HashMap<>();

    public Person save(Person person) {
        people.put(person.getId(), person);
        return person;
    }

    public Person findById(Integer id) {
        return people.get(id);
    }
}
