# Step 1: Base image with JDK 17 and Maven
FROM maven:3.9.2-eclipse-temurin-17 AS build

# Step 2: Set working directory
WORKDIR /app

# Step 3: Copy project files
COPY pom.xml .
COPY src ./src

# Step 4: Build the project (skip tests)
RUN mvn clean package -DskipTests

# Step 5: Second stage: smaller runtime image
FROM eclipse-temurin:17-jdk

WORKDIR /app

# Copy jar from the build stage
COPY --from=build /app/target/*.jar app.jar

# Expose the port
EXPOSE 4000

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
