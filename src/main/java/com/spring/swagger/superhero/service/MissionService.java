package com.spring.swagger.superhero.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.swagger.superhero.exception.ResourceNotFoundException;
import com.spring.swagger.superhero.model.Mission;
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

}
