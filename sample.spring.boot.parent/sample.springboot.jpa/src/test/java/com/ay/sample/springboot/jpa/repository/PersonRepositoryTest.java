package com.ay.sample.springboot.jpa.repository;

import com.ay.sample.springboot.jpa.entity.Person;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.Optional;

@TestPropertySource(locations = {"classpath:application-test.properties"})
@RunWith(SpringRunner.class)
@DataJpaTest
@Transactional
@ContextConfiguration(classes = {PersonRepositoryTest.JpaConfiure.class})
public class PersonRepositoryTest {

    @Autowired
    private  PersonRepository personRepository;

    @Test
    public void saveTest() {
        //give
        Person person = new Person();
        person.setFirstName("Andy");
        person.setLastName("Li");
        this.personRepository.save(person);
        //when
        Optional<Person> result = this.personRepository.findById(person.getId());
        //then
        Assertions.assertThat(result.get().getId()).isEqualTo(person.getId());


    }

    @EnableJpaAuditing
    @Configuration
    @EnableAutoConfiguration
    @ComponentScan(basePackages = {"com.ay.sample"})
    @EntityScan(basePackages = "com.ay.sample")
    public  static class JpaConfiure{

    }
}