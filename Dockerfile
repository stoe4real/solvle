# Use Java 17 (stable, widely supported on Railway)
FROM eclipse-temurin:17-jdk-alpine

# Install latest Maven 3.9.6
RUN apk add --no-cache curl tar bash \
    && MAVEN_VERSION=3.9.6 \
    && MAVEN_URL="https://archive.apache.org/dist/maven/maven-3/${MAVEN_VERSION}/binaries/apache-maven-${MAVEN_VERSION}-bin.tar.gz" \
    && curl -fsSL -o /tmp/maven.tar.gz ${MAVEN_URL} \
    && mkdir -p /opt/maven \
    && tar -xzf /tmp/maven.tar.gz -C /opt/maven --strip-components=1 \
    && rm /tmp/maven.tar.gz \
    && ln -s /opt/maven/bin/mvn /usr/bin/mvn

# Set working directory
WORKDIR /app

# Copy project files
COPY . ./

# Build with Maven (skip tests, force Java 17)
RUN mvn -B -DskipTests -Dmaven.compiler.source=17 -Dmaven.compiler.target=17 clean package

# Run the JAR
CMD ["sh", "-c", "java -jar target/*.jar"]
