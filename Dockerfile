FROM openjdk:8
COPY target/reha.jar reha.jar
EXPOSE 8080
CMD ["java", "-jar", "reha.jar"]
