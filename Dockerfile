#FROM openjdk:17-jdk-slim
#ARG JAR_FILE=target/cursos-0.0.1-SNAPSHOT.jar
#COPY ${JAR_FILE} app_cursos.jar
#EXPOSE 8080
#ENTRYPOINT ["java", "-jar", "app_cursos.jar"]


##--------------------------------------
## Build Stage
##
#FROM maven:3.8.3-openjdk-17 AS build
#WORKDIR /app
#COPY . /app/
#RUN mvn clean package
#
##deployin stage
#FROM openjdk:17-alpine
#WORKDIR /app
#COPY --from=build /app/target/cursos-0.0.1-SNAPSHOT.jar app.jar
#EXPOSE 8095
#ENTRYPOINT ["java", "-jar", "/app.jar"]
#-----------------------------------
#FROM amazoncorretto:20-alpine-jdk
#
#COPY target/cursos-0.0.1-SNAPSHOT.jar app.jar
#COPY --from=build /app/target/*.jar /app/app.jar
#ENTRYPOINT ["java", "-jar", "/app.jar"]