package com.coderscampus.FullStackPortfolio.ThymeleafPractice.service;

import com.coderscampus.FullStackPortfolio.ThymeleafPractice.repository.PersonRepository;
import com.coderscampus.FullStackPortfolio.ThymeleafPractice.domain.Person;
import org.springframework.stereotype.Service;

import java.util.List;

//Services should do the interacting with the repo
@Service
public class PersonService {
    private final PersonRepository personRepository;
    private Integer personId = 1;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Person save(Person person) {
        if(person.getId() == null) {
            person.setId(personId++);
        }
        personRepository.save(person);
        return person;
    }

    public Person findById(Long personId) {
        return personRepository.findById(Math.toIntExact(personId));
    }

    public List<Person> findAll() {
        return personRepository.findAll();
    }

    public void deletePerson(Integer personId) {
        personRepository.deletePerson(personId);
    }
}
