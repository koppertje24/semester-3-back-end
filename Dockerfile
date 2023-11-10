# Use the Maven image with Eclipse Temurin JDK 17 as the base image
FROM maven:3.6.3-openjdk-17-slim

# Set the working directory in the container
WORKDIR /usr/src/app

# Copy the Maven POM file
COPY pom.xml .

# Download the Maven dependencies (not the whole project, to leverage Docker cache)
RUN mvn dependency:go-offline

# Copy the application source code
COPY src ./src

# Build the application
RUN mvn package

# Specify the default command to run when the container starts
CMD ["java", "-jar", "target/back-end-persoonlijk-0.0.1-SNAPSHOT.jar"]
