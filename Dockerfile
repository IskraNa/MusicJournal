FROM azul/zulu-openjdk:17

WORKDIR /app

COPY target/music_journal-0.0.1-SNAPSHOT.jar /app/music_journal-0.0.1-SNAPSHOT.jar

EXPOSE 9090

ENTRYPOINT ["java", "-jar", "music_journal-0.0.1-SNAPSHOT.jar"]