package com.dovile.simplerestwithgradle.api;

import com.dovile.simplerestwithgradle.exception.ResourceNotFoundException;
import com.dovile.simplerestwithgradle.model.Person;
import com.dovile.simplerestwithgradle.service.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javax.validation.Valid;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/person")
@AllArgsConstructor
public class PersonController {

    private final PersonService personService;

    @PostMapping
    public ResponseEntity addPerson(@Valid @NotNull @RequestBody Person person) {
        personService.addPerson(person);
        return new ResponseEntity(person.getName(), HttpStatus.OK);
    }

    @GetMapping
    public List<Person> getAllPerson() {
        return personService.getAllPerson();
    }

    @GetMapping("/{id}")
    public Person getPersonById( @PathVariable(value = "id") UUID id) throws ResourceNotFoundException {
        return personService.getPersonById(id);
    }

    @DeleteMapping("/{id}")
    public Map<String, Boolean> deletePerson(@PathVariable(value = "id") UUID id) throws Exception {
        return personService.deletePerson(id);
    }
    @PutMapping("/{id}")
    public ResponseEntity updatePerson(@PathVariable(value = "id") UUID id,@RequestBody Person person){
        personService.updatePerson(id, person);
        return new ResponseEntity( id+" "+person.getName(), HttpStatus.OK);
    }
}
