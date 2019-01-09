Feature: the superhero can be retrieved
  Scenario: client makes call to GET /api/superheroes
    When the client calls /api/superheroes
    Then the client receives status code of 200
    And the client receives a list of superheroes size of 2
	
  Scenario: client makes call to GET /api/superheroes/1
    When the client calls /api/superheroes/1
    And the client receives a superhero firstname "Firstname 1"
	And the client receives a superhero lastname "Lastname 1"
	And the client receives a superhero superheroName "SuperheroName 1"
	
  Scenario: client makes call to GET /api/missions
    When the client calls /api/missions
    Then the client receives a list of missions size of 2
	
  Scenario: client makes call to GET /api/missions/1
    When the client calls /api/missions/1
    Then the client receives a mission missionName "Mission 1"
	And the client receives a mission isCompleted "<Ext Id>"
	And the client receives a mission isDeleted "<Ext Id>"