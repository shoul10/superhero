package com.spring.swagger.superhero.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.swagger.superhero.model.Superhero;
import com.spring.swagger.superhero.payload.SuperheroRequest;
import com.spring.swagger.superhero.repository.SuperheroRepository;

@Service
public class SuperheroService {
	
	@Autowired
	private SuperheroRepository superheroRepository;
	
	public Superhero createSuperhero(SuperheroRequest superheroRequest) {
		Superhero superhero = new Superhero();
		superhero.setFirstName(superheroRequest.getFirstName());
		superhero.setLastName(superheroRequest.getLastName());
		superhero.setSuperheroName(superheroRequest.getSuperheroName());
		return superheroRepository.save(superhero);
	}

}
