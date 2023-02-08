FROM amazoncorretto:17-alpine-jdk
MAINTAINER ivancasatti
ARG JAR_FILE=Portfolio-BackEnd/target/Back_Program.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
