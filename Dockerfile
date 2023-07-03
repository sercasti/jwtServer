FROM amazoncorretto:17-alpine-jdk

COPY build/dist/jwtServer-0.0.1-SNAPSHOT.jar jwtServer.jar

ENTRYPOINT ["java","-jar","/jwtServer.jar"]