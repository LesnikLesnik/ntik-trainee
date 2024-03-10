FROM openjdk:17-jdk-slim AS build

COPY .mvn .mvn
COPY mvnw .
COPY pom.xml .
COPY src src

RUN --mount=type=cache,target=/root/.m2,rw ./mvnw -B package -DskipTests

FROM openjdk:17-jdk-slim
COPY --from=build target/nauka-trainee-0.0.1-SNAPSHOT.jar .
EXPOSE 8080

ENTRYPOINT ["java", "-jar", "nauka-trainee-0.0.1-SNAPSHOT.jar"]
