FROM openjdk:17
MAINTAINER ivancasatti
COPY target/Back_Program.jar Back_Program.jar
ENTRYPOINT ["java","-jar","/Back_Program.jar"]