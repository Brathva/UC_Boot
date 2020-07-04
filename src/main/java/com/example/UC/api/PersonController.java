package com.example.UC.api;

import com.example.UC.model.Person;
import com.example.UC.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/v1/person")
@RestController
public class PersonController {

    private final PersonService personService;
    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }
    @PostMapping
    public void addPerson(@RequestBody Person person)
    {
        personService.addperson(person);
    }

    @GetMapping
    public List<Person> getAllPeople()
    {
       return personService.getAllPeople();
    }
}