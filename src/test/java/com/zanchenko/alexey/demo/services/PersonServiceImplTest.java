package com.zanchenko.alexey.demo.services;

import com.zanchenko.alexey.demo.models.Person;
import com.zanchenko.alexey.demo.repositories.PersonRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

class PersonServiceImplTest {
    PersonService personService;
    @Mock
    PersonRepository personRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        personService = new PersonServiceImpl(personRepository);
    }

    @Test
    void findById() throws Exception{
        // given
        Person alex = new Person(1L, "alex", "zanchenko", 20);
        Optional<Person> optionalPerson = Optional.of(alex);

        when(personRepository.findById(1L)).thenReturn(optionalPerson);

        assertEquals(Long.valueOf(1L), alex.getId());
    }

    @Test
    void save() {
        Person alex = new Person(1L, "alex", "zanchenko", 20);
        Optional<Person> optionalPerson = Optional.of(alex);
        when(personRepository.findById(anyLong())).thenReturn(optionalPerson);
        when(personRepository.save(any())).thenReturn(alex);

        Person savedPerson = personService.save(alex);
        personService.findById(1L);
        assertEquals(Long.valueOf(1L), savedPerson.getId());
        verify(personRepository, times(1)).findById(anyLong());
        verify(personRepository, times(1)).save(any(Person.class));
    }
}