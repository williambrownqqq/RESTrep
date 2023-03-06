package com.zanchenko.alexey.demo.repositories;

import com.zanchenko.alexey.demo.models.Person;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PersonRepository extends CrudRepository<Person, Long> {
    Optional<Person> findById(Long id);
}