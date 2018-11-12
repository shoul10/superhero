package com.spring.swagger.superhero.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.swagger.superhero.model.Mission;
import com.spring.swagger.superhero.payload.MissionResponse;
import com.spring.swagger.superhero.service.MissionService;

@RestController
@RequestMapping("/api/missions")
public class MissionController {
	
	private MissionService missionService;

	@Autowired
	public MissionController(final MissionService missionService) {
		this.missionService = missionService;
	}

	@GetMapping
	public List<Mission> getMissions() {
		return missionService.findAllMissions();
	}

	@GetMapping("/{missionId}")
	public MissionResponse getMissionById(@PathVariable Long missionId) {
		Mission mission = missionService.findMissionById(missionId);
		return new MissionResponse(mission.getMissionName(), mission.isCompleted(), mission.isDeleted(),
				mission.getSuperheroes());
	}


}
