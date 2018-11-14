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
import com.spring.swagger.superhero.SuperheroApplication;
import com.spring.swagger.superhero.model.Mission;
import com.spring.swagger.superhero.model.Superhero;
import com.spring.swagger.superhero.payload.ApiResponse;
import com.spring.swagger.superhero.payload.SuperheroMissionRequest;
import com.spring.swagger.superhero.payload.SuperheroRequest;
import com.spring.swagger.superhero.service.SuperheroService;
import com.spring.swagger.superhero.utils.Utils;

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
				post("/api/superheroes").contentType(MediaType.APPLICATION_JSON).content(Utils.asJsonString(superhero)))
				.andExpect(status().isOk());
	}
	
	@Test
	public void updateSuperheroTest() throws Exception {
		SuperheroRequest superheroRequest = new SuperheroRequest("Firstname 1", "Lastname 1", "SuperheroName 1");
		Superhero superhero = new Superhero(1L, "Firstname 1", "Lastname 1", "SuperheroName 1");
		when(superheroService.updateSuperhero(superhero.getId(), superheroRequest)).thenReturn(superhero);
		mockMvc.perform(put("/api/superheroes/{superheroId}", superhero.getId()).contentType(MediaType.APPLICATION_JSON)
				.content(Utils.asJsonString(superhero))).andExpect(status().isOk());
	}

	@Test
	public void addMissionToSuperheroTest() throws Exception {
		Superhero superhero = new Superhero(1L, "Firstname 1", "Lastname 1", "SuperheroName 1");
		Mission mission = new Mission(1L, "MissionName 1", false, false);
		SuperheroMissionRequest superheroMissionRequest = new SuperheroMissionRequest(superhero.getId(),
				mission.getId());
		ApiResponse apiResponse = new ApiResponse(true, "Mission added to Superhero");
		when(superheroService.addMissionToSuperhero(superheroMissionRequest)).thenReturn(apiResponse);
		mockMvc.perform(post("/api/superheroes/add-superhero-to-mission").contentType(MediaType.APPLICATION_JSON)
				.content(Utils.asJsonString(superheroMissionRequest))).andExpect(status().isOk());
	}

	@Test
	public void removeMissionFromSuperheroTest() throws Exception {
		Superhero superhero = new Superhero(1L, "Firstname 1", "Lastname 1", "SuperheroName 1");
		Mission mission = new Mission(1L, "MissionName 1", false, false);
		ApiResponse apiResponse = new ApiResponse(true, "Mission removed from Superhero");
		when(superheroService.removeMissionFromSuperhero(superhero.getId(), mission.getId())).thenReturn(apiResponse);
		mockMvc.perform(delete("/api/superheroes/{superheroId}/{missionId}", superhero.getId(), mission.getId()))
				.andExpect(status().isOk()).andExpect(jsonPath("$.success", is(true)))
				.andExpect(jsonPath("$.message", is("Mission removed from Superhero")));
		verify(superheroService, times(1)).removeMissionFromSuperhero(superhero.getId(), mission.getId());
		verifyNoMoreInteractions(superheroService);
	}
	
	@Test
	public void deleteSuperheroTest() throws Exception {
		Superhero superhero = new Superhero(1L, "Firstname 1", "Lastname 1", "SuperheroName 1");
		ApiResponse apiResponse = new ApiResponse(true, "Superhero deleted");
		when(superheroService.deleteSuperhero(superhero.getId())).thenReturn(apiResponse);
		mockMvc.perform(delete("/api/superheroes/{superheroId}", superhero.getId())).andExpect(status().isOk())
				.andExpect(jsonPath("$.success", is(true))).andExpect(jsonPath("$.message", is("Superhero deleted")));
		verify(superheroService, times(1)).deleteSuperhero(superhero.getId());
		verifyNoMoreInteractions(superheroService);
	}

	@Test
	public void badRequestGetSuperheroIdTest() throws Exception {
		mockMvc.perform(get("/api/superheroes/{superheroId}", "f")).andExpect(status().isBadRequest());
	}
}
