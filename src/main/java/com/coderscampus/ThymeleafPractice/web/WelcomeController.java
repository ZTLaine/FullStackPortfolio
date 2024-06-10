package com.coderscampus.ThymeleafPractice.web;

import com.coderscampus.ThymeleafPractice.domain.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class WelcomeController {

    @GetMapping("")
    public String getRootWebpage(ModelMap model) {
//        "View" in this context refers to an html file
//        The returned String should point to the location of the html file to show
//        Default is src/main/resources/templates/{filename}.html
//        String firstName = "Polites";
//        model.put("firstName", firstName);

        Person person = new Person();
        model.put("person", person);
        return "welcome";
    }

//    When doing a @PostMapping return a redirect
    @PostMapping("")
    public String postRootWebpage(Person person) {
        System.out.println(person.toString());
        return "redirect:/";
    }
}
