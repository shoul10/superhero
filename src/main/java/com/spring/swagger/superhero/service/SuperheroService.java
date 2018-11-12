package com.spring.swagger.superhero.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.swagger.superhero.exception.ResourceNotFoundException;
import com.spring.swagger.superhero.model.Mission;
import com.spring.swagger.superhero.model.Superhero;
import com.spring.swagger.superhero.payload.ApiResponse;
import com.spring.swagger.superhero.payload.SuperheroMissionRequest;
import com.spring.swagger.superhero.payload.SuperheroRequest;
import com.spring.swagger.superhero.repository.SuperheroRepository;


@Service
public class SuperheroService {
	
	private SuperheroRepository superheroRepository;
	private MissionService missionService;

	@Autowired
	public SuperheroService(final SuperheroRepository superheroRepository, final MissionService missionService) {
		this.superheroRepository = superheroRepository;
		this.missionService = missionService;
	}

	
	
	public List<Superhero> findAllSuperheroes() {
		return superheroRepository.findAll();
	}

	public Superhero findSuperheroById(Long superheroId) {
		return superheroRepository.findById(superheroId)
				.orElseThrow(() -> new ResourceNotFoundException("Superhero", "ID", superheroId));
	}
	
	public Superhero createSuperhero(SuperheroRequest superheroRequest) {
		Superhero superhero = new Superhero();
		superhero.setFirstName(superheroRequest.getFirstName());
		superhero.setLastName(superheroRequest.getLastName());
		superhero.setSuperheroName(superheroRequest.getSuperheroName());
		return superheroRepository.save(superhero);
	}
	
	public Superhero updateSuperhero(Long superheroId, SuperheroRequest superheroRequest) {
		return superheroRepository.findById(superheroId).map(superhero -> {
			superhero.setFirstName(superheroRequest.getFirstName());
			superhero.setLastName(superheroRequest.getLastName());
			superhero.setSuperheroName(superheroRequest.getSuperheroName());			
			return superheroRepository.save(superhero);
		}).orElseThrow(() -> new ResourceNotFoundException("Mission", "id", superheroId));
	}
	
	public ApiResponse addMissionToSuperhero(SuperheroMissionRequest superheroMissionRequest) {
		// Find mission
		Mission mission = missionService.findMissionById(superheroMissionRequest.getMissionId());
		// Find superhero
		Superhero superhero = this.findSuperheroById(superheroMissionRequest.getSuperheroId());

		superhero.addMission(mission);
		superheroRepository.save(superhero);
		return new ApiResponse(true, "Mission added to Superhero");
	}
	
	public ApiResponse removeMissionFromSuperhero(Long superheroId, Long missionId) {
		// Find mission
		Mission mission = missionService.findMissionById(missionId);
		// Find superhero
		Superhero superhero = this.findSuperheroById(superheroId);

		if(mission.isCompleted()) {
			return new ApiResponse(false, "Unable to remove a completed mission");
		}
		superhero.removeMission(mission);
		superheroRepository.save(superhero);
		return new ApiResponse(true, "Mission removed from Superhero");
	}
	
	public ApiResponse deleteSuperhero(Long superheroId) {
		return superheroRepository.findById(superheroId).map(superhero -> {			
			superheroRepository.delete(superhero);
			return new ApiResponse(true, "Superhero deleted");
		}).orElseThrow(() -> new ResourceNotFoundException("Superhero", "id", superheroId));
		
	}

}
