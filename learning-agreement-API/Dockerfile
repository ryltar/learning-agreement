FROM openjdk:8-jdk-alpine
VOLUME /tmp
ENV JAR_FILE=target/*-spring-boot.jar
COPY ${JAR_FILE} app.jar
EXPOSE 4300
EXPOSE 8080
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
