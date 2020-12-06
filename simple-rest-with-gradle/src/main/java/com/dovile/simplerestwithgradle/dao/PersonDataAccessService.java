package com.dovile.simplerestwithgradle.dao;

import com.dovile.simplerestwithgradle.exception.ResourceNotFoundException;
import com.dovile.simplerestwithgradle.model.Person;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@AllArgsConstructor
@Repository("postgres")
public class PersonDataAccessService implements PersonDao {

    private final JdbcTemplate jdbcTemplate;
    @Override
    public int insertPerson(UUID personId, Person person) {
        final String sql = "INSERT INTO person (id, name) VALUES (?, ?)";
        return jdbcTemplate.update(
                sql, personId, person.getName());
    }

    @Override
    public List<Person> getAllPerson() {
        final String sql = "SELECT id, name FROM person";
        return jdbcTemplate.query(sql, (resultSet, i) ->{
            UUID id = UUID.fromString(resultSet.getString("id"));
            String name = resultSet.getString("name");
            return new Person(id, name);
        });
    }

    @Override
    public Optional<Person> selectPersonById(UUID id) {
        final String sql = "SELECT id, name FROM person WHERE id = ? ";
        Person person = jdbcTemplate.queryForObject(sql, new Object[]{id},
                (resultSet, i) ->{
                    UUID personId = UUID.fromString(resultSet.getString("id"));
                    String name = resultSet.getString("name");
                    return new Person(personId, name);
                });
        return Optional.ofNullable(person);
    }

    @Override
    public void deletePersonById(UUID personId) throws ResourceNotFoundException {
        final String sql = "DELETE FROM person WHERE id = ?";
        jdbcTemplate.update(sql, personId);

    }

    @Override
    public Person updatePersonById(UUID id, Person person) {
        final String sql = "UPDATE person SET name = ? WHERE id = ?";
        jdbcTemplate.update(sql, person.getName(), id);
        return new Person(id, person.getName());
    }
}
