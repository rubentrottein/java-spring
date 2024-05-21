package com.example.firstProjectSB.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Personne {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	long id;


	String nom;
	String prenom;

	@JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate birthday;



	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public LocalDate getBirthday() {
		return birthday;
	}

	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}


	public Personne() {
	}

	public Personne(String nom) {
		this.nom = nom;
	}

	@Override
	public String toString() {
		return "Personne [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", birthday=" + birthday + "]";
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}


}
