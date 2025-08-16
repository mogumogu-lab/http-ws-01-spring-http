# ---- Build stage ----
FROM eclipse-temurin:21-jdk AS build
WORKDIR /workspace

# Copy Gradle wrapper & project files
COPY gradlew gradlew
COPY gradle gradle
COPY build.gradle.kts settings.gradle.kts ./
COPY src src

# Build fat jar
RUN chmod +x gradlew && ./gradlew clean bootJar --no-daemon

# ---- Run stage ----
FROM eclipse-temurin:21-jre
WORKDIR /app
COPY --from=build /workspace/build/libs/app.jar /app/app.jar

# Expose HTTP
EXPOSE 8080

# Run
ENTRYPOINT ["java","-jar","/app/app.jar"]