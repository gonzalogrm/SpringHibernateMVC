package com.zalost.spring.mvc;


public class User {
	//Parameters
	private int id;
	private String name;
	private String nickname;
		
	//Constructor	
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
