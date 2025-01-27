# Use a Maven image with JDK pre-installed
FROM maven:3.8.4-openjdk-17-slim
# Set the working directory in the container
WORKDIR /src
# Copy the pom.xml and source code into the container
#COPY pom.xml .
#COPY src ./src
# # Build the Spring Boot application
# RUN mvn clean package -DskipTests
# Copy the JAR file into the container
COPY target/tap-employeeservice.jar .
#COPY .env .env
 
# Expose the application port
EXPOSE 5372
# Run the Spring Boot application
ENTRYPOINT ["java", "-jar", "tap-employeeservice.jar"]