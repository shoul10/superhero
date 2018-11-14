FROM openjdk:8
EXPOSE 8080
ADD /target/superhero.jar superhero.jar
ENTRYPOINT ["java", "-jar", "superhero.jar"]