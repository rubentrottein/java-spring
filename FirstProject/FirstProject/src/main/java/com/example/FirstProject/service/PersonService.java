package com.example.FirstProject.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.FirstProject.model.Person;
import com.example.FirstProject.repositories.PersonRepository;

@Service
public class PersonService {

	@Autowired
	PersonRepository personRepository;

	public ArrayList<Person> getPersonList() {
		return (ArrayList<Person>) personRepository.findAll();
	}

	public StringBuilder addToList(Person personne) {
		personRepository.save(personne);
		return getPersonListToString();
	}

	public StringBuilder getPersonListToString() {
		ArrayList<Person> personList = getPersonList();
		StringBuilder resume = new StringBuilder();
		for(Person person : personList) {
			resume.append("<li>").append(person.toString()).append("</li>");
		}
		return resume;
	}

	public Optional<Person> findPerson(Long id) {
		return personRepository.findById(id);
	}

	public void deletePerson(Long id) {
		personRepository.deleteById(id);
	}

	public Person updatePerson(Long id, Person newData) {
		Optional<Person> personToUpdate = personRepository.findById(id);
		if(personToUpdate.isPresent()){
			Person p = personToUpdate.get();
			p.setFirstName(newData.getFirstName());
			p.setLastName(newData.getLastName());
			p.setBirthDate(newData.getBirthDate());
			p.setAge(newData.getAge());
			return p;
		} else {
			return null;
		}
	}
	/**/
	public Person addPerson(Person person) {
		Person personToAdd = new Person();
		personToAdd.setFirstName(person.getFirstName());
		personToAdd.setLastName(person.getLastName());
		personToAdd.setBirthDate(person.getBirthDate());
		personToAdd.setAge(person.getAge());
		return personToAdd;

	}
	/**/
	public String display() {
		// on peut démarrer avec un tampon vide
		// StringBuilder builder = new StringBuilder();

		// ou avec un contenu initial
		StringBuilder builder = new StringBuilder(
				"Trois anneaux pour les rois Elfes sous le ciel, ");

		builder.append("Sept pour les Seigneurs Nains dans leurs demeures de pierre, ");
		builder.append("Neuf pour les Hommes Mortels destinés au trépas, ");
		builder.append("Un pour le Seigneur Ténébreux sur son sombre trône, ");
		builder.append("Dans le Pays de Mordor où s'étendent les Ombres. ");
		builder.append("Un anneau pour les gouverner tous. Un anneau pour les trouver, ");
		builder.append("Un anneau pour les amener tous et dans les ténèbres les lier, ");
		builder.append("Au Pays de Mordor où s'étendent les Ombres.");

		// obtention de la taille effective du tampon
		int nbCaracteres = builder.length();

		// obtention d'une instance de String
		String poeme = builder.toString();
		return poeme;
	}
}