FROM amazoncorretto:17-alpine-jdk
MAINTAINER ivancasatti
COPY /Back_Program.jar Back_Program.jar
ENTRYPOINT ["java","-jar","/Back_Program.jar"]