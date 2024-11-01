FROM openjdk:21-jdk-oraclelinux8
ARG JAR_FILE=target/*.jar
COPY ./target/springboot-docker.jar myapp.jar
ENTRYPOINT [ "java", "-jar", "/myapp.jar" ]