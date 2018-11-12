package com.spring.swagger.superhero.payload;

import java.util.HashSet;
import java.util.Set;

import com.spring.swagger.superhero.model.Mission;

public class SuperheroResponse {
	
	private String firstName;
    private String lastName;
    private String superheroName;

    private Set<Mission> missions = new HashSet<>();

    public SuperheroResponse(String firstName, String lastName, String superheroName, Set<Mission> missions) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.superheroName = superheroName;
        this.missions = missions;
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

    public Set<Mission> getMissions() {
        return missions;
    }

    public void setMissions(Set<Mission> missions) {
        this.missions = missions;
    }

}
