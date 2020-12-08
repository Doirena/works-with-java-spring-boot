package com.dovile.crudusingr2dbcwebflux.config;

import com.dovile.crudusingr2dbcwebflux.entity.Person;
import com.dovile.crudusingr2dbcwebflux.repository.PersonRepository;
import io.r2dbc.spi.ConnectionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.r2dbc.connection.init.ConnectionFactoryInitializer;
import org.springframework.r2dbc.connection.init.ResourceDatabasePopulator;

import java.time.Duration;
import java.util.Arrays;
import java.util.Random;

/**
 * @author Dovile Barkauskaite <barkauskaite.dovile@gmail.com>
 */
@Configuration
public class R2DBCConfiguration {

    private static final Logger log = LoggerFactory.getLogger(R2DBCConfiguration.class);

    @Bean
    ConnectionFactoryInitializer initializer(ConnectionFactory connectionFactory) {

        ConnectionFactoryInitializer initializer = new ConnectionFactoryInitializer();
        initializer.setConnectionFactory(connectionFactory);
        initializer.setDatabasePopulator(new ResourceDatabasePopulator(new ClassPathResource("schema.sql")));
        return initializer;
    }

    //Add data into memory db
    @Bean
    public CommandLineRunner init(PersonRepository personRepository) {
        System.out.println(" DATA which I add");
        return args -> {
            personRepository.saveAll(Arrays.asList(new Person("Jack", "Bauer", new Random().nextInt(100)),
                    new Person("Chloe", "O'Brian", new Random().nextInt(100)),
                    new Person("Kim", "Bauer", new Random().nextInt(100)),
                    new Person("David", "Palmer", new Random().nextInt(100)),
                    new Person("Michelle", "Dessler", new Random().nextInt(100))))
                    .blockLast(Duration.ofSeconds(10));

            log.info("Person found with findAll():");
            log.info("-------------------------------");
            personRepository.findAll().doOnNext(person -> {
                log.info(person.toString());
            }).blockLast(Duration.ofSeconds(10));
        };
    }
}
