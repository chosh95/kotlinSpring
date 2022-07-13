FROM openjdk:8-jdk-alpine
ARG JAR_FILE=/build/libs/kotlin-api-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} kotlin_api.jar
ENTRYPOINT ["java","-jar","/kotlin_api.jar"]