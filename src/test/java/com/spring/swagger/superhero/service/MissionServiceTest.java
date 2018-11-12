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
	public void findAllMissionsTest(){
		// given
		List<Mission> missionList = new ArrayList<Mission>();
		missionList.add(new Mission(1L, "MissionName 1",false, false));
		missionList.add(new Mission(2L, "MissionName 2",true, false));
		missionList.add(new Mission(3L, "MissionName 3",false, true));
		
		// when
		when(missionService.findAllMissions()).thenReturn(missionList);
		
		// assert
		List<Mission> result = missionService.findAllMissions();
		assertEquals(3, result.size());
		assertThat(result.get(0).getId()).isEqualTo(1);
        assertThat(result.get(0).getMissionName()).isEqualTo("MissionName 1");
        assertThat(result.get(0).isCompleted()).isEqualTo(false);
        assertThat(result.get(0).isDeleted()).isEqualTo(false);
        assertThat(result.get(1).getId()).isEqualTo(2);
        assertThat(result.get(1).getMissionName()).isEqualTo("MissionName 2");
        assertThat(result.get(1).isCompleted()).isEqualTo(true);
        assertThat(result.get(1).isDeleted()).isEqualTo(false);        
        assertThat(result.get(2).getId()).isEqualTo(3);
        assertThat(result.get(2).getMissionName()).isEqualTo("MissionName 3");
        assertThat(result.get(2).isCompleted()).isEqualTo(false);
        assertThat(result.get(2).isDeleted()).isEqualTo(true);       
        
	}
	
	@Test
	public void findMissionByIdTest(){
		// given
		Mission mission = new Mission(1L, "MissionName 1",false, false);
		
		// when
		when(missionService.findMissionById(1L)).thenReturn(mission);
		
		// assert
		Mission result = missionService.findMissionById(1L);
		assertThat(result.getId()).isEqualTo(1);
        assertThat(result.getMissionName()).isEqualTo("MissionName 1");
        assertThat(result.isCompleted()).isEqualTo(false);
        assertThat(result.isDeleted()).isEqualTo(false);
		
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
	
	@Test
    public void updateMissionTest() {
        // given
		MissionRequest missionRequest = new MissionRequest("MissionName 1",false, false);
		Mission mission = new Mission(1L, "MissionNameUpdated 1",true, true);
		
        // when
        when(missionService.updateMission(1L, missionRequest)).thenReturn(mission);

        // assert
        Mission result = missionService.updateMission(1L, missionRequest);
        assertThat(result.getId()).isEqualTo(1);
        assertThat(result.getMissionName()).isEqualTo("MissionNameUpdated 1");
        assertThat(result.isCompleted()).isEqualTo(true);
        assertThat(result.isDeleted()).isEqualTo(true);
    }
	
	@Test
    public void softDeleteMissionTest() {
        // given
		Mission mission = new Mission(1L, "MissionName 1",false, false);		
		Mission softDeletedMission = new Mission(1L, "MissionName 1",false, true);
		
        // when
        when(missionService.softDeleteMission(mission.getId())).thenReturn(softDeletedMission);

        // assert
        Mission result = missionService.softDeleteMission(mission.getId());
        assertThat(result.getId()).isEqualTo(1);
        assertThat(result.getMissionName()).isEqualTo("MissionName 1");
        assertThat(result.isCompleted()).isEqualTo(false);
        assertThat(result.isDeleted()).isEqualTo(true);
    }

}
