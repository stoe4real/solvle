# Use the Eclipse Temurin (OpenJDK) Alpine official image
# https://hub.docker.com/_/eclipse-temurin
FROM eclipse-temurin:21-jdk-alpine

# Install Maven
RUN apk add --no-cache maven

# Create and set the working directory
WORKDIR /app

# Copy all project files into the container
COPY . ./

# Build the app with Maven, skipping tests
RUN mvn -B -DskipTests clean package

# Run the built JAR file (dynamically finds the .jar in target/)
CMD ["sh", "-c", "java -jar target/*.jar"]
