
FROM openjdk:17-jdk-slim
COPY /target/ai-books-0.0.1-SNAPSHOT.jar ai-books.jar
# ENV PORT=8080
EXPOSE 8080
ENTRYPOINT ["java","-jar","ai-books.jar"]
