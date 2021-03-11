package com.ggm.spring.persistence;

public class SearchParameters {
	private int id = -1;
	private String email = null;	
	
	public SearchParameters() {}

	public SearchParameters(int id, String email) {
		this.id = id;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
