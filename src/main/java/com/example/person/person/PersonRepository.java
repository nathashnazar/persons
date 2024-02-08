package com.example.person.person;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Integer> {
    List<Person> findByNameContainingIgnoreCase(String text);
    List<Person> findByEmailId(String text);
    List<Person> findByMobile(String text);
    List<Person> findByMobileContainsIgnoreCase(String text);
    List<Person> findByMobileLike(String text);
    List<Person> findByMobileStartingWith(String text);


}
