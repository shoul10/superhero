package com.spring.swagger.superhero.controller;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
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
import com.spring.swagger.superhero.payload.MissionRequest;
import com.spring.swagger.superhero.service.MissionService;
import com.spring.swagger.superhero.utils.Utils;

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

	
	@Test
	public void getMissionsTest() throws Exception {
		// given
		List<Mission> missions = Arrays.asList(new Mission(1L, "MissionName 1", false, false),
				new Mission(2L, "MissionName 2", true, false));

		// when
		when(missionService.findAllMissions()).thenReturn(missions);
		mockMvc.perform(get("/api/missions")).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
				.andExpect(jsonPath("$", hasSize(2))).andExpect(jsonPath("$[0].id", is(1)))
				.andExpect(jsonPath("$[0].missionName", is("MissionName 1")))
				.andExpect(jsonPath("$[0].completed", is(false)))
				.andExpect(jsonPath("$[0].deleted", is(false))).andExpect(jsonPath("$[1].id", is(2)))
				.andExpect(jsonPath("$[1].missionName", is("MissionName 2")))
				.andExpect(jsonPath("$[1].completed", is(true)))
				.andExpect(jsonPath("$[1].deleted", is(false)));
		verify(missionService, times(1)).findAllMissions();
		verifyNoMoreInteractions(missionService);
	}
	
	@Test
	public void getMissionByIdTest() throws Exception {
		Mission mission = new Mission("MissionName 1", true, false);
		when(missionService.findMissionById(1L)).thenReturn(mission);
		mockMvc.perform(get("/api/missions/{missionId}", 1)).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
				.andExpect(jsonPath("$.missionName", is("MissionName 1")))
				.andExpect(jsonPath("$.completed", is(true)))
				.andExpect(jsonPath("$.deleted", is(false)));
		verify(missionService, times(1)).findMissionById(1L);
		verifyNoMoreInteractions(missionService);
	}
	
	@Test
	public void createMissionTest() throws Exception {
		MissionRequest missionRequest = new MissionRequest("MissionName 1", true, false);
		Mission mission = new Mission(1L, "MissionName 1", true, false);
		when(missionService.createMission(missionRequest)).thenReturn(mission);
		mockMvc.perform(
				post("/api/missions").contentType(MediaType.APPLICATION_JSON).content(Utils.asJsonString(mission)))
				.andExpect(status().isOk());
	}
	
	@Test
	public void updateMissionTest() throws Exception {
		MissionRequest missionRequest = new MissionRequest("MissionName 1", true, false);
		Mission mission = new Mission(1L, "MissionName 1", true, false);
		when(missionService.updateMission(mission.getId(), missionRequest)).thenReturn(mission);
		mockMvc.perform(put("/api/missions/{missionId}", mission.getId()).contentType(MediaType.APPLICATION_JSON)
				.content(Utils.asJsonString(mission))).andExpect(status().isOk());
	}
	
	@Test
	public void softDeleteMissionTest() throws Exception {
		Mission mission = new Mission(1L, "MissionName 1", false, false);
		Mission softdeletedMission = new Mission(1L, "MissionName 1", false, true);
		when(missionService.softDeleteMission(mission.getId())).thenReturn(softdeletedMission);
		mockMvc.perform(delete("/api/missions/{missionId}", mission.getId())).andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
		.andExpect(jsonPath("$.missionName", is("MissionName 1")))
		.andExpect(jsonPath("$.completed", is(false)))
		.andExpect(jsonPath("$.deleted", is(true)));
		verify(missionService, times(1)).softDeleteMission(mission.getId());
		verifyNoMoreInteractions(missionService);
	}

}
