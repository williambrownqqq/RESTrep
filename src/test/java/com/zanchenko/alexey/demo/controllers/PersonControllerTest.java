package com.zanchenko.alexey.demo.controllers;

import com.zanchenko.alexey.demo.models.Person;
import com.zanchenko.alexey.demo.services.PersonService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.HashSet;
import java.util.Set;

import static org.mockito.Mockito.*;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class PersonControllerTest {

    @Mock
    PersonService personService;

    @InjectMocks
    PersonController personController;

    MockMvc mockMvc;
    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders
                .standaloneSetup(personController)
                .build();
    }
    @Test
    void getPersonById() throws Exception{
        when(personService.findById(anyLong())).thenReturn(Person.builder().id(1L).build());

        mockMvc.perform(get("/person/1"))
                //.andExpect(status().is(200));
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));

        verify(personService).findById(1L);
    }
}