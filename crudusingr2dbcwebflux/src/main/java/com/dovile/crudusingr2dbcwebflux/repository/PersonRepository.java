package com.dovile.crudusingr2dbcwebflux.repository;

import com.dovile.crudusingr2dbcwebflux.entity.Person;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Dovile Barkauskaite <barkauskaite.dovile@gmail.com>
 */
@Repository
public interface PersonRepository extends ReactiveCrudRepository<Person, Integer> {
}
