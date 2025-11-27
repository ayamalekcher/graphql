# Base image
FROM eclipse-temurin:17-jdk

# Set working directory
WORKDIR /app

# Copy project files
COPY . .

# Build project
RUN ./mvnw clean package -DskipTests

# Copy jar
COPY target/*.jar app.jar

# Expose port
EXPOSE 4000

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
