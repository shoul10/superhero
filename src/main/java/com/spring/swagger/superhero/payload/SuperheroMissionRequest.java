package com.spring.swagger.superhero.payload;

public class SuperheroMissionRequest {
	
	private Long superheroId;
    private Long missionId;    
    
    
    
	public SuperheroMissionRequest() {
		super();
	}


	public SuperheroMissionRequest(Long superheroId, Long missionId) {
		super();
		this.superheroId = superheroId;
		this.missionId = missionId;
	}
	
	
	public Long getSuperheroId() {
		return superheroId;
	}
	public void setSuperheroId(Long superheroId) {
		this.superheroId = superheroId;
	}
	public Long getMissionId() {
		return missionId;
	}
	public void setMissionId(Long missionId) {
		this.missionId = missionId;
	}   

}
