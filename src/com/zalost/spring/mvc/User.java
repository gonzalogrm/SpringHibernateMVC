package com.zalost.spring.mvc;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class User {
	//Parameters
	private int id;
	private String name;
	private String nickname;
	private String email;
	private int age;
	private String role;
	private String language;
		
	//Constructor
	public User() {}
	
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
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
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
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
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
