# Install gradlew
FROM openjdk:11 AS build
WORKDIR /usr/src/app

COPY gradlew .
RUN chmod +x gradlew
COPY gradle ./gradle

RUN ./gradlew -v

# Build
COPY src ./src

#RUN ./gradlew bootJar

# Run
FROM openjdk:11

COPY /build/libs/challenger-0.0.1-SNAPSHOT-plain.jar /app.jar

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]
