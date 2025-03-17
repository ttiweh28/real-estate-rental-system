# Use OpenJDK 23 as the base image
FROM openjdk:23-ea-slim
# Set the working directory in the container
WORKDIR /app
# Copy the Spring Boot JAR file from the target directory
COPY target/*.jar app.jar

ENV SERVER_PORT=8889


ENV DB_NAME=rsrs
ENV DB_PASSWORD=root
ENV DB_USERNAME=root
ENV ACTIVE_PROFILE=root

ENTRYPOINT ["sh", "-c", "java -jar app.jar --spring.profiles.active=$ACTIVE_PROFILE"]