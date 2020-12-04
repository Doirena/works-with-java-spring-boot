package com.dovile.simplerestwithgradle.service;

import com.dovile.simplerestwithgradle.dao.PersonDao;
import com.dovile.simplerestwithgradle.exception.ResourceNotFoundException;
import com.dovile.simplerestwithgradle.model.Person;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
@AllArgsConstructor
public class PersonService {

    @Qualifier("fakeDao")
//    @Qualifier("postgres")
    private final PersonDao personDao;

    public int addPerson(Person person){
        return personDao.insertPerson(person);
    }

    public List<Person> getAllPerson(){
        return personDao.getAllPerson();
    }

    public Person getPersonById(UUID id) throws ResourceNotFoundException {
        return personDao.selectPersonById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No found this person"));
    }

    public Map<String, Boolean> deletePerson(UUID id) throws Exception {
        personDao.deletePersonById(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

    public Person updatePerson(UUID id, Person person){
        try {
            return personDao.updatePersonById(id, person);
        } catch (ArithmeticException e){
            throw new ArithmeticException("No found this person");
        }
    }
}
