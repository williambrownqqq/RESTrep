package com.zanchenko.alexey.demo.dataloader;

import com.zanchenko.alexey.demo.models.Person;
import com.zanchenko.alexey.demo.services.PersonService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class DataLoader implements CommandLineRunner {
    private final PersonService personService;

    public DataLoader(PersonService personService) {
        this.personService = personService;
    }

    @Override
    public void run(String... args) throws Exception {
        loadData();
    }

    private void loadData(){
        Person alex = new Person(1L, "alex", "zanchenko", 20);
        Person anton = new Person(2L, "anton", "zanchenko", 25);
        Person artem = new Person(3L, "artem", "zanchenko", 55);
        personService.save(alex);
        personService.save(anton);
        personService.save(artem);
    }
}
