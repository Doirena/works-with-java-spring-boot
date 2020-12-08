package com.dovile.crudusingr2dbcwebflux.service;

import com.dovile.crudusingr2dbcwebflux.entity.Person;
import com.dovile.crudusingr2dbcwebflux.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

/**
 * @author Dovile Barkauskaite <barkauskaite.dovile@gmail.com>
 */
@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public Flux<Person> getAllPeople(){
        return this.personRepository
                .findAll();
    }
}
