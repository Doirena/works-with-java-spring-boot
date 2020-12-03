package com.dovile.simplerestwithgradle.dao;

import com.dovile.simplerestwithgradle.exception.ResourceNotFoundException;
import com.dovile.simplerestwithgradle.model.Person;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PersonDao {

    int insertPerson(UUID id, Person person);

    default int insertPerson(Person person){
        UUID id =UUID.randomUUID();
        return insertPerson(id, person);
    }

    List<Person> getAllPerson();

    Optional<Person> selectPersonById(UUID id);

    void deletePersonById(UUID id) throws ResourceNotFoundException;

    Person updatePersonById(UUID id, Person person);
}
