package com.spring.swagger.superhero.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.swagger.superhero.model.Superhero;
import com.spring.swagger.superhero.payload.SuperheroRequest;
import com.spring.swagger.superhero.payload.SuperheroResponse;
import com.spring.swagger.superhero.service.SuperheroService;

@RestController
@RequestMapping("/api/superheroes")
public class SuperheroController {
	
	private SuperheroService superheroService;

	@Autowired
	public SuperheroController(final SuperheroService superheroService) {
		this.superheroService = superheroService;
	}
	
	@GetMapping
	public List<Superhero> getSuperheroes() {
		return superheroService.findAllSuperheroes();
	}

	@GetMapping("/{superheroId}")
	public SuperheroResponse getSuperheroById(@PathVariable Long superheroId) {
		Superhero superhero = superheroService.findSuperheroById(superheroId);
		return new SuperheroResponse(superhero.getFirstName(), superhero.getLastName(), superhero.getSuperheroName(),
				superhero.getMissions());
	}
	
	@PostMapping
	public Superhero createSuperhero(@RequestBody SuperheroRequest superheroRequest) {
		return superheroService.createSuperhero(superheroRequest);
	}

}
