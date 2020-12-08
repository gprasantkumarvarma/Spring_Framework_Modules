FROM openjdk:11-jre-slim
WORKDIR usr/src
ENV MONGO_DATABASE NoteServiceDB
ENV MONGO_PORT 27017
ENV MONGO_HOST localhost
ADD ./target/NoteService-0.0.1-SNAPSHOT.jar /usr/src/NoteService-0.0.1-SNAPSHOT.jar
EXPOSE 8082
ENTRYPOINT ["java","-jar","NoteService-0.0.1-SNAPSHOT.jar"]