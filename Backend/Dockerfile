FROM openjdk:11
ARG JAR_FILE=target/n11-bootcamp-omerozturk.jar
COPY ${JAR_FILE} omerozturk-app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "omerozturk-app.jar"]