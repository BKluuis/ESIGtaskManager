FROM maven:3.9.7-eclipse-temurin-21 AS build
ARG ETM_POSTGRES_URL
ARG ETM_POSTGRES_USER
ARG ETM_POSTGRES_PASSWORD

ENV ETM_POSTGRES_URL=$ETM_POSTGRES_URL
ENV ETM_POSTGRES_USER=$ETM_POSTGRES_USER
ENV ETM_POSTGRES_PASSWORD=$ETM_POSTGRES_PASSWORD

COPY src /app/src
COPY pom.xml /app
RUN mvn -f /app/pom.xml clean package

FROM eclipse-temurin:21 AS package

COPY --from=build /app/target/esig.task-manager-1.0.0.jar /app/app.jar

WORKDIR /app

ENTRYPOINT ["java", "-jar", "app.jar"]