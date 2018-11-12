package com.spring.swagger.superhero.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.swagger.superhero.model.Superhero;
import com.spring.swagger.superhero.payload.SuperheroRequest;
import com.spring.swagger.superhero.service.SuperheroService;

@RestController
@RequestMapping("/api/superheroes")
public class SuperheroController {
	
	private SuperheroService superheroService;

	@Autowired
	public SuperheroController(final SuperheroService superheroService) {
		this.superheroService = superheroService;
	}
	
	@PostMapping
	public Superhero createSuperhero(@RequestBody SuperheroRequest superheroRequest) {
		return superheroService.createSuperhero(superheroRequest);
	}

}
