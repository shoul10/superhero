package com.spring.swagger.superhero.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

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
	public void findAllSuperheroesTest(){
		// given
		List<Superhero> superheroList = new ArrayList<Superhero>();
		superheroList.add(new Superhero(1L, "Firstname 1","Lastname 1", "Superheroname 1"));
		superheroList.add(new Superhero(2L, "Firstname 2","Lastname 2", "Superheroname 2"));
		superheroList.add(new Superhero(3L, "Firstname 3","Lastname 3", "Superheroname 3"));
		
		// when
		when(superheroService.findAllSuperheroes()).thenReturn(superheroList);
		
		// assert
		List<Superhero> result = superheroService.findAllSuperheroes();
		assertEquals(3, result.size());
		assertThat(result.get(0).getId()).isEqualTo(1);
		assertThat(result.get(0).getFirstName()).isEqualTo("Firstname 1");
        assertThat(result.get(0).getLastName()).isEqualTo("Lastname 1");
        assertThat(result.get(0).getSuperheroName()).isEqualTo("Superheroname 1");
        assertThat(result.get(1).getId()).isEqualTo(2);
        assertThat(result.get(1).getFirstName()).isEqualTo("Firstname 2");
        assertThat(result.get(1).getLastName()).isEqualTo("Lastname 2");
        assertThat(result.get(1).getSuperheroName()).isEqualTo("Superheroname 2");
        assertThat(result.get(2).getId()).isEqualTo(3);
        assertThat(result.get(2).getFirstName()).isEqualTo("Firstname 3");
        assertThat(result.get(2).getLastName()).isEqualTo("Lastname 3");
        assertThat(result.get(2).getSuperheroName()).isEqualTo("Superheroname 3");
	}
	
	@Test
	public void findSuperheroByIdTest(){
		// given
		Superhero superhero = new Superhero(1L, "Firstname 1","Lastname 1", "Superheroname 1");
		
		// when
		when(superheroService.findSuperheroById(1L)).thenReturn(superhero);
		
		// assert
		Superhero result = superheroService.findSuperheroById(1L);
		assertThat(result.getId()).isEqualTo(1);
		assertThat(result.getFirstName()).isEqualTo("Firstname 1");
        assertThat(result.getLastName()).isEqualTo("Lastname 1");
        assertThat(result.getSuperheroName()).isEqualTo("Superheroname 1");
		
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
