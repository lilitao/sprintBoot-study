package com.ay.sample.springboot.jpa.repository;

import com.ay.sample.springboot.jpa.entity.Person;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends PagingAndSortingRepository<Person, Long> {

    List<Person> findByLastName(String lastName);
}
