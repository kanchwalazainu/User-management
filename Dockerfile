FROM openjdk:8-jdk-alpine
LABEL maintainer="kanchwalazainu@gmail.com"

EXPOSE 8080
ADD /target/user-management.jar user-management.jar

ENTRYPOINT ["java","-jar","/user-management.jar"]
