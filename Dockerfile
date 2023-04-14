FROM openjdk:17-oracle
FROM maven:3.8.5-openjdk-17
EXPOSE 8080
COPY . /usr/src/app
WORKDIR /usr/src/app
RUN mvn package
ADD /target/restapi-0.0.1-SNAPSHOT.jar restapi.jar
ENTRYPOINT ["java", "$JAVA_OPTS -XX:+UseContainerSupport", "-Xmx300m -Xss512k -XX:CICompilerCount=2", "-Dserver.port=$PORT", "-Dspring.profiles.active=prod", "-jar", "restapi.jar"]