FROM openjdk:18
WORKDIR /app
COPY ./target/tap-employeeservice.jar /app
EXPOSE 5372
CMD ["java", "-jar", "tap-employeeservice.jar"]
 
 
 
