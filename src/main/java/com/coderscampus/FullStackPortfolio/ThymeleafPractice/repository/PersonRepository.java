package com.coderscampus.FullStackPortfolio.ThymeleafPractice.repository;

import com.coderscampus.FullStackPortfolio.ThymeleafPractice.domain.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

    public List<Person> findAll() {
        return new ArrayList<>(people.values());
    }

    public void deletePerson(Integer personId) {
        people.remove(personId);
    }
}
