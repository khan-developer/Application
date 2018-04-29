package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {
  
  public Person findByFirstName(String firstName);
  public List<Person> findByLastName(String lastName);
  
}