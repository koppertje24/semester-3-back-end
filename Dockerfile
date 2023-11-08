# Build Stage
FROM maven:3.8.4-openjdk-17 AS build
WORKDIR /app
COPY ./pom.xml ./src ./
RUN mvn clean test

# Final Stage
FROM maven:3.8.4-openjdk-17 AS final
WORKDIR /app
COPY --from=build /app/ ./
RUN mvn clean package

# Create the production-ready image
FROM adoptopenjdk/openjdk17:alpine-slim
WORKDIR /app
COPY --from=final /app/target/dnd-scharacter-backend.jar .  # Replace "your-app" with your actual app name
CMD ["java", "-jar", "your-app.jar"]
