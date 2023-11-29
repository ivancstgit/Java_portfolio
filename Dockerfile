FROM openjdk:11-jdk
MAINTAINER CST
COPY target/api-0.0.1-SNAPSHOT.jar cst-app.jar
ENTRYPOINT ["java","-jar","/cst-app.jar"]