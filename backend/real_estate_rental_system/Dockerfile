# Use OpenJDK 23 as the base image
FROM openjdk:23-ea-slim
# Set the working directory in the container
WORKDIR /app
# Copy the Spring Boot JAR file from the target directory
COPY target/*.jar app.jar

ENV SERVER_PORT=8080

ENTRYPOINT ["sh", "-c", "java -jar app.jar --server.port=${SERVER_PORT}"]