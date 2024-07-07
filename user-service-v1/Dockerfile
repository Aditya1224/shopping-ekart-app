FROM openjdk:21
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} user-service-v1.jar
ENTRYPOINT ["java","-jar","/user-service-v1.jar"]