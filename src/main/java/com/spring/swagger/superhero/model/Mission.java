package com.spring.swagger.superhero.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="missions")
public class Mission {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	private String missionName;

	private boolean isCompleted;

	private boolean isDeleted;

	
	@ManyToMany(fetch = FetchType.LAZY,
			cascade = {
					CascadeType.PERSIST,
					CascadeType.MERGE
			},
			mappedBy = "missions")
	@JsonIgnore
	private Set<Superhero> superheroes = new HashSet<>();

	public Mission() {
	}

	public Mission(@NotBlank String missionName, boolean isCompleted, boolean isDeleted) {
		this.missionName = missionName;
		this.isCompleted = isCompleted;
		this.isDeleted = isDeleted;
	}
	
	public Mission(@NotBlank Long id, @NotBlank String missionName, boolean isCompleted, boolean isDeleted) {
		this.id = id;
		this.missionName = missionName;
		this.isCompleted = isCompleted;
		this.isDeleted = isDeleted;
	}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public void addSuperhero(Superhero superhero) {
	    this.superheroes.add(superhero);
    }

}
