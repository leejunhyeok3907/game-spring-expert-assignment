FROM ubuntu:latest
LABEL authors="Leejunhyeok"

ENTRYPOINT ["top", "-b"]

FROM amazoncorretto:21 AS build
WORKDIR /app
RUN dnf install -y findutils
COPY gradlew .
COPY gradle gradle
COPY build.gradle settings.gradle ./
COPY src src
RUN chmod +x gradlew && ./gradlew bootJar -x test --no-daemon

FROM amazoncorretto:21
WORKDIR /app
COPY --from=build /app/build/libs/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]