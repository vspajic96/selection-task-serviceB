FROM openjdk:8-alpine
ADD build/libs/*.jar service-b.jar
EXPOSE 8081
RUN sh -c 'touch /service-b.jar'
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom","-Dspring.profiles.active=container", "-jar", "/service-b.jar"]
