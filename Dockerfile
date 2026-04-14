# Use official OpenJDK 25 base image
FROM openjdk:25-ea-jdk-slim

# Set working directory
WORKDIR /app

# Copy Maven-built JAR file
COPY target/drinksaver-backend-0.0.1-SNAPSHOT.jar app.jar

# Expose port 8080
EXPOSE 8080

# Run the JAR file
ENTRYPOINT ["java", "-jar", "app.jar"]

