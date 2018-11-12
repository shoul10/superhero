package com.spring.swagger.superhero.controller;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.Is.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.swagger.superhero.SuperheroApplication;
import com.spring.swagger.superhero.model.Superhero;
import com.spring.swagger.superhero.payload.SuperheroRequest;
import com.spring.swagger.superhero.service.SuperheroService;

@RunWith(SpringRunner.class)
@WebMvcTest(SuperheroApplication.class)
public class SuperheroControllerTest {
	
	
	private MockMvc mockMvc;

	@Mock
	private SuperheroService superheroService;

	@InjectMocks
	private SuperheroController superheroController;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(superheroController).build();
	}

	/*
	 * converts a Java object into JSON representation
	 */
	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	@Test
	public void getSuperheroesTest() throws Exception {
		// given
		List<Superhero> superheroes = Arrays.asList(new Superhero(1L, "Firstname 1", "Lastname 1", "SuperheroName 1"),
				new Superhero(2L, "Firstname 2", "Lastname 2", "SuperheroName 2"));

		// when
		when(superheroService.findAllSuperheroes()).thenReturn(superheroes);
		mockMvc.perform(get("/api/superheroes")).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
				.andExpect(jsonPath("$", hasSize(2))).andExpect(jsonPath("$[0].id", is(1)))
				.andExpect(jsonPath("$[0].firstName", is("Firstname 1")))
				.andExpect(jsonPath("$[0].lastName", is("Lastname 1")))
				.andExpect(jsonPath("$[0].superheroName", is("SuperheroName 1"))).andExpect(jsonPath("$[1].id", is(2)))
				.andExpect(jsonPath("$[1].firstName", is("Firstname 2")))
				.andExpect(jsonPath("$[1].lastName", is("Lastname 2")))
				.andExpect(jsonPath("$[1].superheroName", is("SuperheroName 2")));
		verify(superheroService, times(1)).findAllSuperheroes();
		verifyNoMoreInteractions(superheroService);
	}

	@Test
	public void getSuperheroByIdTest() throws Exception {
		Superhero superhero = new Superhero("Firstname 1", "Lastname 1", "SuperheroName 1");
		when(superheroService.findSuperheroById(1L)).thenReturn(superhero);
		mockMvc.perform(get("/api/superheroes/{superheroId}", 1)).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
				.andExpect(jsonPath("$.firstName", is("Firstname 1")))
				.andExpect(jsonPath("$.lastName", is("Lastname 1")))
				.andExpect(jsonPath("$.superheroName", is("SuperheroName 1")));
		verify(superheroService, times(1)).findSuperheroById(1L);
		verifyNoMoreInteractions(superheroService);
	}

	
	@Test
	public void createSuperheroTest() throws Exception {
		SuperheroRequest superheroRequest = new SuperheroRequest("Firstname 1", "Lastname 1", "SuperheroName 1");
		Superhero superhero = new Superhero(1L, "Firstname 1", "Lastname 1", "SuperheroName 1");
		when(superheroService.createSuperhero(superheroRequest)).thenReturn(superhero);
		mockMvc.perform(
				post("/api/superheroes").contentType(MediaType.APPLICATION_JSON).content(asJsonString(superhero)))
				.andExpect(status().isOk());
	}

}