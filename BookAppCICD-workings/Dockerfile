# Use an official OpenJDK runtime as a parent image
FROM openjdk:11-jre-slim

# Set the working directory
WORKDIR /app

# Copy the JAR file into the container
COPY target/BookAppCICD-workings.jar /app/

# Expose the port that the application will run on
EXPOSE 8082

# Run the application
CMD ["java", "-jar", "BookAppCICD-workings.jar"]