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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
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
//the doc:https://docs.spring.io/spring-data/jpa/docs/2.1.0.M2/reference/html/#query-by-example
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

    @Test
    public void pagationFindAllTest() {
        //give
        Person p1 = new Person();
        p1.setLastName("Li");
        p1.setFirstName("A1");
        this.personRepository.save(p1);
        Person p2 = new Person();
        p2.setFirstName("Li");
        p2.setFirstName("A2");
        this.personRepository.save(p2);
        Person p3 = new Person();
        p3.setFirstName("Li");
        p3.setLastName("A3");
        this.personRepository.save(p3);
        Person p4 = new Person();
        p4.setLastName("A4");
        p4.setFirstName("Li");
        this.personRepository.save(p4);
        //when
        Page<Person> persons = this.personRepository.findAll(new PageRequest(1, 2));
        //then
        Assertions.assertThat(persons.getSize()).isEqualTo(2);

    }

    @EnableJpaAuditing
    @Configuration
    @EnableAutoConfiguration
    @ComponentScan(basePackages = {"com.ay.sample"})
    @EntityScan(basePackages = "com.ay.sample")
    @EnableJpaRepositories
    public  static class JpaConfiure{

    }
}