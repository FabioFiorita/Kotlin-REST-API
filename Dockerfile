FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:17-oracle
COPY --from=build /app/target/restapi-0.0.1-SNAPSHOT.jar restapi.jar
EXPOSE 8080
ENTRYPOINT ["java", "-XX:+UnlockExperimentalVMOptions", "-XX:+UseContainerSupport", "-Djava.security.egd=file:/dev/./urandom", "-jar", "restapi.jar"]
