# Spring project is prepared to run on https://render.com/ webservice
#
# Build stage
FROM gradle:jdk21-jammy AS build
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle build

LABEL org.name="malex"
# Package stage
FROM eclipse-temurin:21-jdk-jammy

COPY --from=build /home/gradle/src/build/libs/app-rss-0.0.1.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]