package com.dovile.crudusingr2dbcwebflux.controller;

import com.dovile.crudusingr2dbcwebflux.entity.Person;
import com.dovile.crudusingr2dbcwebflux.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author Dovile Barkauskaite <barkauskaite.dovile@gmail.com>
 */
@RestController
@RequestMapping("people")
public class PeopleController {

    @Autowired
    private PersonService personService;

    @GetMapping("/all")
    public Flux<Person> getAll(){
        return this.personService.getAllPeople();
    }
//
//    @GetMapping("/hello")
//    public Mono<String> getHello(){
//        return Mono.just("Hello") ;
//    }
}
