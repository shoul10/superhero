package com.spring.swagger.superhero.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="superheroes")
public class Superhero {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	private String firstName;

	@NotBlank
	private String lastName;

	@NotBlank
	private String superheroName;

	
	@ManyToMany(fetch = FetchType.LAZY,
		cascade = {
				CascadeType.PERSIST,
				CascadeType.MERGE
		})
	@JoinTable(name = "superheroes_missions",
		joinColumns = { @JoinColumn(name = "superhero_id") },
		inverseJoinColumns = { @JoinColumn(name = "mission_id") })
	@JsonIgnore
	private Set<Mission> missions = new HashSet<>();

	public Superhero() {
	}

	public Superhero(@NotBlank String firstName, @NotBlank String lastName, @NotBlank String superheroName) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.superheroName = superheroName;
	}
	
	public Superhero(@NotBlank Long id, @NotBlank String firstName, @NotBlank String lastName, @NotBlank String superheroName) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.superheroName = superheroName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
	
	public void addMission(Mission mission) {
	    this.missions.add(mission);
    }
	
	public void removeMission(Mission mission) {
	    this.missions.remove(mission);
    }

}
