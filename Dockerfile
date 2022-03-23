FROM openjdk:8-jre-slim

ENV JAVA_PARAMETERS=-Dserver.port=8080

COPY ./target/hmv-service-*.jar /hmv-service.jar

EXPOSE 8080

CMD ["sh", "-c", "java $JAVA_PARAMETERS -jar /hmv-service.jar"]
