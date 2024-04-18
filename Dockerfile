
FROM maven:3.8.4-openjdk-17 AS build

WORKDIR /app/server

COPY server/pom.xml .

RUN mvn dependency:go-offline

COPY server/src ./src

RUN mvn package

FROM openjdk:17-jdk-slim

WORKDIR /app/server

COPY --from=build /app/server/target/ai-books.jar-0.0.1-SNAPSHOT.jar .

EXPOSE 8080

CMD ["java", "-jar", "ai-books-0.0.1-SNAPSHOT.jar"]

