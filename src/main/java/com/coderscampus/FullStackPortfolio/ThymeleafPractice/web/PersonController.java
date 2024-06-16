package com.coderscampus.FullStackPortfolio.ThymeleafPractice.web;

import com.coderscampus.FullStackPortfolio.ThymeleafPractice.domain.Person;
import com.coderscampus.FullStackPortfolio.ThymeleafPractice.service.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class PersonController {
    private final PersonService personService;

    PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/persons")
    public String getPersons(ModelMap model) {
//        "View" in this context refers to an html file
//        The returned String should point to the location of the html file to show
//        Default is src/main/resources/templates/{filename}.html
//        String firstName = "Polites";
//        model.put("firstName", firstName);
        List<Person> people = personService.findAll();

        Person person = new Person();
        model.put("person", person);
        model.put("people", people);
//        Could also do this instead of .put
//        Which would allow method chaining
//        According to Claude .addAttribute is preferred with Spring MVC but Trevor is using .put
//        model.addAttribute("people", people);

//        this returns the html file to view, it has nothing to do with the key on the model
//        nor with the name of the list, this is terribly confusing naming practices
        return "people";
    }

    @GetMapping("/persons/{personId}")
    public String getPerson(@PathVariable Long personId, ModelMap model) {
        Person person = personService.findById(personId);
        model.put("person", person);
        return "people";
    }

//    When doing a @PostMapping return a redirect
    @PostMapping("/persons")
    public String postPerson(Person person) {
//        controllers should only really interact with the models, views, and services
//        so don't stick repo calls directly in them
        Person savedPerson = personService.save(person);
        System.out.println(savedPerson);
        return "redirect:/persons";
    }

    @PostMapping("/persons/{personId}")
    public String updatePerson(Person person) {
        personService.save(person);
        return "redirect:/persons/" + person.getId();
    }

    @PostMapping("/persons/{personId}/delete")
    public String deletePerson(@PathVariable Integer personId) {
        personService.deletePerson(personId);
        return "redirect:/persons";
    }
}
