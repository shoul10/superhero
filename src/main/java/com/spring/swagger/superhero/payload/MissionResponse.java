package com.spring.swagger.superhero.payload;

import java.util.HashSet;
import java.util.Set;

import com.spring.swagger.superhero.model.Superhero;

public class MissionResponse {
	
	private String missionName;

    private boolean isCompleted;

    private boolean isDeleted;

    private Set<Superhero> superheroes = new HashSet<>();

    
    
    public MissionResponse() {
		super();
	}

	public MissionResponse(String missionName, boolean isCompleted, boolean isDeleted, Set<Superhero> superheroes) {
		super();
		this.missionName = missionName;
        this.isCompleted = isCompleted;
        this.isDeleted = isDeleted;
        this.superheroes = superheroes;
    }

    public String getMissionName() {
        return missionName;
    }

    public void setMissionName(String missionName) {
        this.missionName = missionName;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public Set<Superhero> getSuperheroes() {
        return superheroes;
    }

    public void setSuperheroes(Set<Superhero> superheroes) {
        this.superheroes = superheroes;
    }

}
