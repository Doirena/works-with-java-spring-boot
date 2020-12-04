package com.dovile.simplerestwithgradle.dao;

import com.dovile.simplerestwithgradle.exception.ResourceNotFoundException;
import com.dovile.simplerestwithgradle.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("fakeDao")
public class FakePersonDataAccessService implements PersonDao {

    private static List<Person> DB = new ArrayList<Person>();

    @Override
    public int insertPerson(UUID id, Person person) {
        DB.add(new Person(id, person.getName()));
        return 1;
    }

    @Override
    public List<Person> getAllPerson() {
        return DB;
    }

    @Override
    public Optional<Person> selectPersonById(UUID id) {
        return DB.stream()
                .filter(person -> person.getId().equals(id))
                .findFirst();
    }

    @Override
    public void deletePersonById(UUID id) throws ResourceNotFoundException {
        Optional<Person> personMaybe = Optional.ofNullable(selectPersonById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No found this person")));
        DB.remove(personMaybe.get());
    }

    @Override
    public Person updatePersonById(UUID id, Person updatePerson) {
        return selectPersonById(id)
                .map(person->{
                    int indexOfPersonToUpdate = DB.indexOf(person);
                    if (indexOfPersonToUpdate >= 0){
                        DB.set(indexOfPersonToUpdate, new Person(id, updatePerson.getName()));
                        return person;
                    }
                    return null;
                })
                .orElse(null);
    }
}
