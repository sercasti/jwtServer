FROM amazoncorretto:17

COPY build/libs/jwtServer-0.0.1-SNAPSHOT.jar jwtServer.jar

ENTRYPOINT ["java","-jar","/jwtServer.jar"]