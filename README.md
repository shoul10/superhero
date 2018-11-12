The goal of this assigment is to have a REST application to manage
a Super hero company. The application needs to be developped with Java and Spring Boot.

Features:
    Operations:
        - Create a super hero 
        - Read a super hero info also, show his active missions and completed missions
        - Update a super Hero info and add/remove available missions. (Unable to remove a completed mission)
        - Delete a super Hero 
        - Create a new mission
        - Read missions information
        - Update a mission
        - Soft delete a mission
                                                                
    - All operations must be accessible via a restful API with Swagger
    - The application must be buildable with maven
    - The tests can be run from maven
    - Methods should be unit tested as much as possible (TDD appreciated)
    - Project should be hosted in github
    - Create a git branch for each operation before pull requesting them in the master
    - Use spring Repository to Create/read/update/delete the data (in a H2 db for example)

    ** It's appreciated but not mandatory, if we can see through the git history how you incrementally build the app (e.g TDD, refactoring)

Optional:
    Should Have:
        - Code base should respect SOLID principles
    Nice to Have:
        - Securize the Deletion operation with Spring security
        - Cucumber tests
        - frontend with Angular/React
        - Apply one design Pattern
        - Deploy you application with Docker
        - Have your test and/or deployment automated in jenkins (or similar service)

Data model:
    Super Hero
        String Firstname
        String Lastname
        String Superheroname
        List   Missions
    Mission
        String  MissionName
        Boolean IsCompleted
		Boolean Isdeleted
        List    Heroes
