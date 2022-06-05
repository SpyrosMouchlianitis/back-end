FROM gradle:7.4.2-jdk17 AS build
COPY . /app
WORKDIR /app
RUN gradle build

FROM openjdk:17
COPY --from=build app/build/libs/devops-backend.jar devops-backend.jar
ENTRYPOINT ["java","-jar","-Dspring.profiles.active=docker","/devops-backend.jar"]