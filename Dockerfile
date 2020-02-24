FROM openjdk:8
COPY target/reha-patients-service.jar reha-patients-service.jar
EXPOSE 8080
CMD ["java", "-jar", "reha-patients-service.jar"]
