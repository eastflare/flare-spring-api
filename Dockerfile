FROM openjdk:17-jdk-slim

ARG JAR_FILE=build/libs/rap-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar

EXPOSE 8080
ENTRYPOINT ["java","-Djasypt.encryptor.password=ThisisWebFrameworkSecurityKey","-jar","/app.jar"]
