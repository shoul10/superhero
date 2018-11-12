package com.spring.swagger.superhero.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
	public void createSuperheroTest() throws Exception {
		SuperheroRequest superheroRequest = new SuperheroRequest("Firstname 1", "Lastname 1", "SuperheroName 1");
		Superhero superhero = new Superhero(1L, "Firstname 1", "Lastname 1", "SuperheroName 1");
		when(superheroService.createSuperhero(superheroRequest)).thenReturn(superhero);
		mockMvc.perform(
				post("/api/superheroes").contentType(MediaType.APPLICATION_JSON).content(asJsonString(superhero)))
				.andExpect(status().isOk());
	}

}
