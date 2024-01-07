# Use an official OpenJDK runtime as a base image with Java 17
FROM openjdk:17-alpine

# Set the working directory in the container
WORKDIR /eCommerceWebsite

# Copy the JAR file into the container at /eCommerceWebsite
COPY target/eCommerceWebsite-0.0.1-SNAPSHOT.jar eCommerceWebsite.jar

# Specify the port number the container should expose
EXPOSE 8080

# Specify any runtime arguments that should be passed to the JAR file
CMD ["java", "-jar", "eCommerceWebsite.jar"]
