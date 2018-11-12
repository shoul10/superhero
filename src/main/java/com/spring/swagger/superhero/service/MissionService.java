package com.spring.swagger.superhero.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.swagger.superhero.exception.ResourceNotFoundException;
import com.spring.swagger.superhero.model.Mission;
import com.spring.swagger.superhero.payload.MissionRequest;
import com.spring.swagger.superhero.repository.MissionRepository;

@Service
public class MissionService {
	
	private MissionRepository missionRepository;	

	@Autowired
	public MissionService(final MissionRepository missionRepository) {
		this.missionRepository = missionRepository;
	}
	
	public List<Mission> findAllMissions() {
		return missionRepository.findAll();
	}

	public Mission findMissionById(Long missionId) {
		return missionRepository.findById(missionId)
				.orElseThrow(() -> new ResourceNotFoundException("Mission", "ID", missionId));
	}
	
	public Mission createMission(MissionRequest missionRequest) {
		Mission mission = new Mission();
		mission.setMissionName(missionRequest.getMissionName());
		mission.setCompleted(missionRequest.isCompleted());
		mission.setDeleted(missionRequest.isDeleted());
		return missionRepository.save(mission);
	}
	
	public Mission updateMission(Long missionId, MissionRequest missionRequest) {
		return missionRepository.findById(missionId).map(mission -> {
			mission.setMissionName(missionRequest.getMissionName());
			mission.setCompleted(missionRequest.isCompleted());
			mission.setDeleted(missionRequest.isDeleted());
			return missionRepository.save(mission);
		}).orElseThrow(() -> new ResourceNotFoundException("Mission", "id", missionId));
	}
	
	public Mission softDeleteMission(Long missionId) {
		return missionRepository.findById(missionId).map(mission -> {			
			mission.setDeleted(true);
			return missionRepository.save(mission);
		}).orElseThrow(() -> new ResourceNotFoundException("Mission", "id", missionId));
	}

}
