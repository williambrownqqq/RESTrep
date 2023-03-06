package com.zanchenko.alexey.demo.services;

import com.zanchenko.alexey.demo.exceptions.NotFoundException;
import com.zanchenko.alexey.demo.models.Person;
import com.zanchenko.alexey.demo.repositories.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class PersonServiceImpl implements PersonService{

    private final PersonRepository personRepository;

    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public Person findById(Long aLong) {
        Optional<Person> optionalPerson = personRepository.findById(aLong);

        return optionalPerson.orElseThrow(() -> new NotFoundException("i can't find anything!1!1!1!"));
    }

    @Override
    public Person save(Person person) {
        return personRepository.save(person);
    }
}
