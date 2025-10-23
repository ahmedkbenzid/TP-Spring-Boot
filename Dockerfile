FROM openjdk:23-jdk
VOLUME /tmp
COPY target/*.jar country-service.jar
ENTRYPOINT ["java", "-jar", "/country-service.jar"]