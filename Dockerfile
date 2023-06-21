FROM adoptopenjdk/openjdk11:alpine-jre

# Set the working directory in the container
WORKDIR /app

# Copy the JAR file into the container
COPY target/music_journal-0.0.1-SNAPSHOT.jar .jar /app/music_journal-0.0.1-SNAPSHOT.jar/

# Expose the port that the application will listen on
EXPOSE 9091

# Set the command to run the application
ENTRYPOINT ["java", "-jar", "music_journal-0.0.1-SNAPSHOT.jar"]