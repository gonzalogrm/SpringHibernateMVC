package com.ggm.spring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="admin")
public class Admin implements IHasIntID {
	//Parameters
	@Id
	@Column(name="idadmin") 
	private int id;
	
	@Column(name="name") 
	private String name;
	
	//Constructor
	public Admin() {}
	
	public Admin(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	
	//Getters Setters
	@Override
	public int getId() {
		return id;
	}	

	@Override
	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
