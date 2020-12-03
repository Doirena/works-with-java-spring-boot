package com.dovile.simplerestwithgradle.dao;

import com.dovile.simplerestwithgradle.exception.ResourceNotFoundException;
import com.dovile.simplerestwithgradle.model.Person;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("postgres")
public class PersonDataAccessService implements PersonDao {
    @Override
    public int insertPerson(UUID id, Person person) {
        return 0;
    }

    @Override
    public List<Person> getAllPerson() {
        return List.of(new Person(UUID.randomUUID(), "FROM POSTGRES DB"));
    }

    @Override
    public Optional<Person> selectPersonById(UUID id) {
        return Optional.empty();
    }

    @Override
    public void deletePersonById(UUID id) throws ResourceNotFoundException {
    }

    @Override
    public Person updatePersonById(UUID id, Person person) {
        return null;
    }
}
