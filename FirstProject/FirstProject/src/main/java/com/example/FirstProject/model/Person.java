package com.example.FirstProject.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	
	int age;
	String lastName;
	String firstName;

	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate birthDate;

	public Person() {
	}

	public Person(int age, String lastName, String firstName, LocalDate birthDate) {
		super();
		this.age = age;
		this.lastName = lastName;
		this.firstName = firstName;
		this.birthDate = birthDate;
	}
		
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public LocalDate getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Person{" +
				"id=" + id +
				", age=" + age +
				", lastName='" + lastName + '\'' +
				", firstName='" + firstName + '\'' +
				", birthDate=" + birthDate +
				'}';
	}
}