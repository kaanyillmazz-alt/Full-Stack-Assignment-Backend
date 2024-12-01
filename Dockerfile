FROM openjdk:17-jdk-slim

WORKDIR /app

COPY pom.xml .
COPY src ./src

RUN mvn clean install

CMD ["java", "-jar", "target/fullstack-assignment.jar"]
