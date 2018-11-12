package com.spring.swagger.superhero.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring.swagger.superhero.model.Superhero;
import com.spring.swagger.superhero.payload.SuperheroRequest;

@RunWith(SpringJUnit4ClassRunner.class)
public class SuperheroServiceTest {
	
	@Mock
	private SuperheroService superheroService;
	
	@Before
	public void setup(){
		// With this call to initMocks we tell Mockito to process the annotations
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
    public void createSuperheroTest() {
        // given
		SuperheroRequest superheroRequest = new SuperheroRequest("Firstname 1","Lastname 1", "Superheroname 1");
		Superhero superhero = new Superhero(1L, "Firstname 1","Lastname 1", "Superheroname 1");
		
        // when
        when(superheroService.createSuperhero(superheroRequest)).thenReturn(superhero);

        // assert
        Superhero result = superheroService.createSuperhero(superheroRequest);
        assertThat(result.getId()).isEqualTo(1);
        assertThat(result.getFirstName()).isEqualTo("Firstname 1");
        assertThat(result.getLastName()).isEqualTo("Lastname 1");
        assertThat(result.getSuperheroName()).isEqualTo("Superheroname 1");
    }

}
