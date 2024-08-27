FROM maven:3.9.7-eclipse-temurin-21 AS build
ENV DATABASE_URL database
COPY src /app/src
COPY pom.xml /app
RUN mvn -f /app/pom.xml clean package -DskipTests

FROM eclipse-temurin:21 AS package
COPY --from=build /app/target/esig.task-manager-1.0.0.jar /app/app.jar

WORKDIR /app

EXPOSE 8080:8080

ENTRYPOINT ["java", "-jar", "app.jar"]