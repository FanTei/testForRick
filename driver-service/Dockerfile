FROM openjdk:17
#docker build --build-arg JAR_FILE=target/*.jar -t myorg/myapp .
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar", "app.jar"]
