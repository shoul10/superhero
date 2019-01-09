package com.spring.swagger.superhero.cucumber;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import java.util.Arrays;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.spring.swagger.superhero.model.Mission;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MissionStepDefs {
	
	private ResponseEntity<List<Mission>> responseEntities;	
	private ResponseEntity<Mission> responseEntity;
	
	
	//Scenario: client makes call to GET /api/missions
	@When("^the client calls /api/missions$")
	public void the_client_calls_api_missions() throws Throwable {
		List<Mission> missions = Arrays.asList(new Mission(1L, "Mission 1", false, false),
				new Mission(2L, "Mission 2", true, false));
		responseEntities = new ResponseEntity<List<Mission>>(missions, HttpStatus.OK);	
	}

	@Then("^the client receives a list of missions size of (\\d+)$")
	public void the_client_receives_a_list_of_missions_size_of(int size) throws Throwable {
		 assertThat(responseEntities.getBody().size(), is(size));
	}

	
	//Scenario: client makes call to GET /api/missions/1
	@When("^the client calls /api/missions/(\\d+)$")
	public void the_client_calls_api_missions(int id) throws Throwable {
		Mission missions = new Mission(1L, "Mission 1", false, false);
		responseEntity = new ResponseEntity<Mission>(missions, HttpStatus.OK);
	}

	@Then("^the client receives a mission missionName \"([^\"]*)\"$")
	public void the_client_receives_a_mission_missionName(String missionName) throws Throwable {
		assertThat(responseEntity.getBody().getMissionName(), is(missionName));
	}

	@Then("^the client receives a mission isCompleted \"([^\"]*)\"$")
	public void the_client_receives_a_mission_isCompleted(String isCompleted) throws Throwable {
		assertThat(responseEntity.getBody().isCompleted(), is(Boolean.parseBoolean(isCompleted)));
	}

	@Then("^the client receives a mission isDeleted \"([^\"]*)\"$")
	public void the_client_receives_a_mission_isDeleted(String isDeleted) throws Throwable {
		assertThat(responseEntity.getBody().isDeleted(), is(Boolean.parseBoolean(isDeleted)));
	}
	
	

}
