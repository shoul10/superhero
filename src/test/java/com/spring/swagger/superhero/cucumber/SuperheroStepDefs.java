package com.spring.swagger.superhero.cucumber;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.spring.swagger.superhero.model.Superhero;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SuperheroStepDefs {	
	
	private ResponseEntity<List<Superhero>> responseEntities;	
	private ResponseEntity<Superhero> responseEntity;	
	
	//Scenario: client makes call to GET /api/superheroes
	@When("^the client calls /api/superheroes$")
	public void the_client_issues_GET_getAllSuperheroes() throws Throwable{
		List<Superhero> superheroes = Arrays.asList(new Superhero(1L, "Firstname 1", "Lastname 1", "SuperheroName 1"),
				new Superhero(2L, "Firstname 2", "Lastname 2", "SuperheroName 2"));
		responseEntities = new ResponseEntity<List<Superhero>>(superheroes, HttpStatus.OK);		
	}
	
	@Then("^the client receives status code of (\\d+)$")
	public void the_client_receives_status_code_of(int statusCode) throws Throwable {
	    HttpStatus currentStatusCode = responseEntities.getStatusCode();
	    assertThat("status code is incorrect : " + responseEntities.getStatusCodeValue(), currentStatusCode.value(), is(statusCode));
	}	
	
	@And("^the client receives a list of superheroes size of (\\d+)$")
	public void the_client_receives_size_of_superheroes_list(int size) throws Throwable {
	    assertThat(responseEntities.getBody().size(), is(size));
	}
	
	//Scenario: client makes call to GET /api/superheroes/1
	@When("^the client calls /api/superheroes/(\\d+)$")
	public void the_client_calls_api_superheroes(int id) throws Throwable {
		Superhero superheroes = new Superhero(1L, "Firstname 1", "Lastname 1", "SuperheroName 1");
		responseEntity = new ResponseEntity<Superhero>(superheroes, HttpStatus.OK);
	}

	@Then("^the client receives a superhero firstname \"([^\"]*)\"$")
	public void the_client_receives_a_superhero_firstname(String firstname) throws Throwable {
		assertThat(responseEntity.getBody().getFirstName(), is(firstname));
	}

	@Then("^the client receives a superhero lastname \"([^\"]*)\"$")
	public void the_client_receives_a_superhero_lastname(String lastName) throws Throwable {
		assertThat(responseEntity.getBody().getLastName(), is(lastName));
	}

	@Then("^the client receives a superhero superheroName \"([^\"]*)\"$")
	public void the_client_receives_a_superhero_superheroName(String superheroName) throws Throwable {
		assertThat(responseEntity.getBody().getSuperheroName(), is(superheroName));
	}
	
	
	

}
