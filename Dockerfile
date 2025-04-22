# Stage 1: Build the application
FROM gradle:8.7-jdk21-alpine AS builder

# Set the working directory
WORKDIR /app

# Update packages and install security updates
RUN apk update && apk upgrade && \
    rm -rf /var/cache/apk/*

# Copy the gradle configuration files
COPY build.gradle.kts settings.gradle.kts gradle.properties ./
COPY gradle ./gradle

# Copy the source code
COPY src ./src

# Build the application
RUN gradle build --no-daemon -x test

# Stage 2: Run the application
FROM eclipse-temurin:21-jre-alpine

# Update packages and install security updates
RUN apk update && apk upgrade && \
    rm -rf /var/cache/apk/*

WORKDIR /app

# Create a non-root user
RUN addgroup -S appgroup && adduser -S appuser -G appgroup
USER appuser

# Copy the built JAR file from the builder stage
COPY --from=builder /app/build/libs/*.jar app.jar

# Expose the application port
EXPOSE 8080

# Configure security options
ENV JAVA_TOOL_OPTIONS="-Djava.security.egd=file:/dev/./urandom -Dfile.encoding=UTF-8 -XX:+UseContainerSupport -XX:MaxRAMPercentage=75.0"

# Set the entrypoint command to run the application
ENTRYPOINT ["java", "-jar", "app.jar"]