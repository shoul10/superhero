package com.spring.swagger.superhero.payload;

public class SuperheroRequest {
	
	private String firstName;
    private String lastName;
    private String superheroName;
    
    
    
	public SuperheroRequest() {
		super();
	}
	public SuperheroRequest(String firstName, String lastName, String superheroName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.superheroName = superheroName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getSuperheroName() {
		return superheroName;
	}
	public void setSuperheroName(String superheroName) {
		this.superheroName = superheroName;
	}

}
