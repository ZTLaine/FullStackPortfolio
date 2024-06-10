package com.coderscampus.ThymeleafPractice.web;

import com.coderscampus.ThymeleafPractice.domain.Person;
import com.coderscampus.ThymeleafPractice.service.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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

        Person person = new Person();
        model.put("person", person);
        return "people";
    }

//    When doing a @PostMapping return a redirect
    @PostMapping("/persons")
    public String postRootWebpage(Person person) {
//        controllers should only really interact with the models, views, and services
//        so don't stick repo calls directly in them
        Person savedPerson = personService.save(person);
        System.out.println(savedPerson);
        return "redirect:/persons";
    }

    @GetMapping("/people/{personId}")
    public String getPerson(@PathVariable Long personId, ModelMap model) {
        Person person = personService.findById(personId);
        model.put("person", person);
        return "people";
    }
}
