FROM openjdk:18-jdk-slim

# Set working directory
WORKDIR /app

# Copy Gradle wrapper and build files
COPY gradlew gradlew.bat ./
COPY gradle gradle
COPY build.gradle settings.gradle ./

# Copy libs directory (contains cabin-v26.0.0.jar)
COPY libs libs

# Copy source code
COPY src src

# Make gradlew executable
RUN chmod +x gradlew

# Build the application
RUN ./gradlew build

# Expose port 8080
EXPOSE 8080

# Run the application
CMD ["./gradlew", "run"]