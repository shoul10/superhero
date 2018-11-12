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
import com.spring.swagger.superhero.model.Mission;
import com.spring.swagger.superhero.payload.MissionRequest;
import com.spring.swagger.superhero.service.MissionService;

@RunWith(SpringRunner.class)
@WebMvcTest(SuperheroApplication.class)
public class MissionControllerTest {
	
	private MockMvc mockMvc;

	@Mock
	private MissionService missionService;

	@InjectMocks
	private MissionController missionController;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(missionController).build();
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
	public void createMissionTest() throws Exception {
		MissionRequest missionRequest = new MissionRequest("MissionName 1", true, false);
		Mission mission = new Mission(1L, "MissionName 1", true, false);
		when(missionService.createMission(missionRequest)).thenReturn(mission);
		mockMvc.perform(
				post("/api/missions").contentType(MediaType.APPLICATION_JSON).content(asJsonString(mission)))
				.andExpect(status().isOk());
	}

}
