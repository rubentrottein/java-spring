package com.example.firstProjectSB.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.firstProjectSB.model.Personne;

@Repository
public interface PersonneRepository extends CrudRepository<Personne, Long>{

}
