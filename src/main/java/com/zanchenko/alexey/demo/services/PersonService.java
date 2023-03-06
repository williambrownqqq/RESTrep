package com.zanchenko.alexey.demo.services;

import com.zanchenko.alexey.demo.models.Person;
import org.springframework.stereotype.Service;

public interface PersonService extends CrudService<Person, Long> {

    Person findById(Long id);
    Person save(Person person);
}
