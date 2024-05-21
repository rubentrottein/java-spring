package com.example.FirstProject.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.FirstProject.model.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {
}