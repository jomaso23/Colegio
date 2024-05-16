#
# Build Stage
#
FROM maven:3.8.3-openjdk-20 AS build
WORKDIR /app
COPY . /app/
RUN mvn clean package

#
#
#
FROM openjdk:20-alpine
WORKDIR /app
COPY --from=build /app/target/*.jar /app/app.jar
EXPOSE 8095
ENTRYPOINT ["java", "-jar", "/app.jar"]
#FROM amazoncorretto:20-alpine-jdk
#
#COPY target/cursos-0.0.1-SNAPSHOT.jar app.jar
#
#ENTRYPOINT ["java", "-jar", "/app.jar"]