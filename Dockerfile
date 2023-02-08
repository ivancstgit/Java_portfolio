FROM amazoncorretto:17-alpine-jdk
MAINTAINER CST
COPY target/Back_Program-0.0.1-SNAPSHOT.jar cst-app.jar
ENTRYPOINT ["java","-jar","/cst-app.jar"]