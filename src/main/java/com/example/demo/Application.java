package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.model.Person;
import com.example.repository.PersonRepository;

@SpringBootApplication
public class Application implements CommandLineRunner {
  
  @Autowired
  PersonRepository personRepository;

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

  @Override
  public void run(String... arg0) throws Exception {
    
      // Save three Person documents on PostgreSQL
      personRepository.save(new Person("Sheldon", "Cooper"));
      personRepository.save(new Person("Missy", "Cooper"));
      personRepository.save(new Person("Leonard", "Hofstadter"));
      
      // Get all the people
      System.out.println(">>> All the people in the database:");
      personRepository.findAll().forEach(System.out::println);
      
      // Get all the people with a specific last name
      System.out.println(">>> All people with last name = 'Cooper'");
      personRepository.findByLastName("Cooper").forEach(System.out::println);
      
      // Update an individual person
      Person person = personRepository.findByFirstName("Sheldon");
      person.setFirstName("Shelly");
      personRepository.save(person);
      
      // Delete all 
     // personRepository.deleteAll();
    
  }
}