# Build Stage
FROM maven:3.9.5-eclipse-temurin-17 AS build
WORKDIR /app
COPY ./pom.xml ./src ./
RUN mvn clean test

# Final Stage
FROM maven:3.9.5-eclipse-temurin-17 AS final
WORKDIR /app
COPY --from=build /app/ ./
RUN mvn clean package

# Create the production-ready image
FROM maven:3.9.5-eclipse-temurin-17
WORKDIR /app
COPY --from=final /app/target/dnd-scharacter-backend.jar .
CMD ["java", "-jar", "dnd-scharacter-backend.jar"]
