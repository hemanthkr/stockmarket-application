# Start with a base image containing Java runtime
# FROM openjdk:8-jdk-alpine
FROM openjdk:latest

# Add Maintainer Info
MAINTAINER Hemanth K R <hemanthkr30@gmail.com>

# Add a volume pointing to /tmp
VOLUME /tmp

# Make port 8080 available to the world outside this container
EXPOSE 4010

# The application's jar file
ARG JAR_FILE=target/zuul-api-gateway-0.0.1-SNAPSHOT.jar

# Add the application's jar to the container
ADD ${JAR_FILE} zuul-api-gateway.jar

# Run the jar file 
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/zuul-api-gateway.jar"]

