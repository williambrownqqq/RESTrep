package com.zanchenko.alexey.demo.controllers;

import com.zanchenko.alexey.demo.models.Person;
import com.zanchenko.alexey.demo.services.PersonService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PersonController {

    private final PersonService personService;
    public List<Person> crowd = new ArrayList<>();
    {
        crowd.add(new Person(1L, "alex", "zanchenko", 20));
        crowd.add(new Person(2L, "artem", "zanchenko", 25));
        crowd.add(new Person(3L, "anton", "zanchenko", 55));
    }

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

//    @GetMapping("/persons")
//    public List<Person> list(){
//        return crowd;
//    }

    @GetMapping("/person/{id}")
    public Person getPersonById(@PathVariable Long id){
       //return crowd.get(Math.toIntExact(id));
//        return crowd.stream()
//                .filter(person -> person.getId().equals(id))
//                .findFirst()
//                .orElseThrow(() -> new NotFoundException("i can't find anything!1!1!1!"));
        return personService.findById(id);
    }
}
