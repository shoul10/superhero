package com.spring.swagger.superhero.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring.swagger.superhero.model.Mission;
import com.spring.swagger.superhero.payload.MissionRequest;

@RunWith(SpringJUnit4ClassRunner.class)
public class MissionServiceTest {
	
	@Mock
	private MissionService missionService;
	
	@Before
	public void setup(){
		// With this call to initMocks we tell Mockito to process the annotations
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
    public void createMissionTest() {
        // given
		MissionRequest missionRequest = new MissionRequest("MissionName 1",false, false);
		Mission mission = new Mission(1L, "MissionName 1",false, false);
		
        // when
        when(missionService.createMission(missionRequest)).thenReturn(mission);

        // assert
        Mission result = missionService.createMission(missionRequest);
    	assertThat(result.getId()).isEqualTo(1);
        assertThat(result.getMissionName()).isEqualTo("MissionName 1");
        assertThat(result.isCompleted()).isEqualTo(false);
        assertThat(result.isDeleted()).isEqualTo(false);
    }

}
