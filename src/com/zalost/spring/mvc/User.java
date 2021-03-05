package com.zalost.spring.mvc;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class User {
	//Parameters
	private int id;
	private String name;
	private String nickname;
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
}
