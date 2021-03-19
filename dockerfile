from openjdk:12-alpine
COPY ./target/sor-0.0.1-SNAPSHOT.jar /app/sor-0.0.1-SNAPSHOT.jar
WORKDIR /app
ENTRYPOINT ["java", "-jar", "sor-0.0.1-SNAPSHOT.jar"]
