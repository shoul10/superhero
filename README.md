The goal of this assigment is to have a REST application to manage a Super hero company. The application needs to be developped with [Java](https://www.java.com) and [Spring Boot](http://spring.io/projects/spring-boot).

### Features:
- Operations:
    - Create a super hero
    - Read a super hero info also, show his active missions and completed missions
    - Update a super Hero info and add/remove available missions. (Unable to remove a completed mission)
    - Delete a super Hero
    - Create a new mission
    - Read missions information
    - Update a mission
    - Soft delete a mission
    - All operations must be accessible via a restful API with [Swagger](https://swagger.io/)
    - The application must be buildable with [maven](https://maven.apache.org/)
    - The tests can be run from [maven](https://maven.apache.org/)
    - Methods should be unit tested as much as possible (TDD appreciated)
    - Project should be hosted in [github](https://github.com/)
    - Create a git branch for each operation before pull requesting them in the master
    - Use spring Repository to Create/read/update/delete the data (in a [H2](http://www.h2database.com) db for example)
    - It's appreciated but not mandatory, if we can see through the git history how you incrementally build the app (e.g TDD, refactoring)

- Optional:
    * Should Have:
        - Code base should respect SOLID principles
    * Nice to Have:
        - Securize the Deletion operation with [Spring Security](https://spring.io/projects/spring-security)
        - [Cucumber](https://cucumber.io/) tests
        - frontend with [Angular](https://angular.io/)/[React](https://reactjs.org/)
        - Apply one design Pattern
        - Deploy you application with [Docker](https://www.docker.com/)
        - Have your test and/or deployment automated in [jenkins](https://jenkins.io/) (or similar service)

### Data model:
- Super Hero
    - String Firstname
    - String Lastname
    - String Superheroname
    - List   Missions
- Mission
    - String  MissionName
    - Boolean IsCompleted
    - Boolean Isdeleted
    - List    Heroes
