FROM openjdk:jdk-alpine
VOLUME /tmp
ADD target/istio-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-Dspring.profiles.active=test","-jar","/app.jar"]