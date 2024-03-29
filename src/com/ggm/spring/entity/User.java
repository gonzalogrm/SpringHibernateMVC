package com.ggm.spring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="user")
public class User implements IHasIntID{
	//Parameters
	@Id
	@Column(name="id") 
	private int id;
	
	@Column(name="name") 
	private String name;
	
	@Column(name="email") 
	private String email;
	
	@Column(name="age") 
	private int age;
	
	@Column(name="language") 
	private String language;
		
	//Constructor
	public User() {}
	
	public User(String name, String email, int age, String language) {
		this.name = name;
		this.email = email;
		this.age = age;
		this.language = language;
	}
	
	/*
	@Override
	public String toString() {
		return "User [id=" + id + ", nombre=" + nombre + ", nickname=" + nickname + "]";
	}
	*/
	

	//Getters Setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	//Validaciones
	@NotNull
	@Size(min=2, message = "Size not valid. More than one character")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}

	@Min(value = 18, message = "No se permiten menores de 18")
	@Max(value = 50, message = "No se permiten mayores de 50")
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	//No hace falta especificar el mensaje
	@Size(min=2, message = "Size not valid. More than one character")
	@Email(message = "Not a valid email")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}	
}
