package com.example.firstProjectSB.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.firstProjectSB.model.Personne;
import com.example.firstProjectSB.repository.PersonneRepository;

@Service
public class PersonneService {


	@Autowired
	PersonneRepository personneRepository;

	public boolean addPersonne(Personne personne) {
		personneRepository.save(personne);
		return true;
	}

	public ArrayList<Personne> getAllPersonnes(){
		return (ArrayList<Personne>) personneRepository.findAll();
	}

	public Optional<Personne> getPersonneById(long id) {
		return personneRepository.findById(id);
	}

	public void deletePersonneById(long id) {
		personneRepository.deleteById(id);
	}

	public void update(Personne personneToSave, long id) {
		Optional<Personne> personneToUpdated = personneRepository.findById(id);
		if(personneToUpdated.isPresent()) {
			Personne p = personneToUpdated.get();
			p.setBirthday(personneToSave.getBirthday());
			p.setNom(personneToSave.getNom());
			p.setPrenom(personneToSave.getPrenom());

			personneRepository.save(p);
		}

	}
}
