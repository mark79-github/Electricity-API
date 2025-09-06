FROM eclipse-temurin:21-jdk-alpine

WORKDIR /app

RUN apk update && apk upgrade && \
    addgroup -g 1001 -S appuser && \
    adduser -u 1001 -S appuser -G appuser

COPY build/libs/electricity-api-0.0.1-SNAPSHOT.war app.war

RUN chown appuser:appuser app.war

USER appuser

EXPOSE 8080

ENV JAVA_OPTS="-XX:+UseContainerSupport -XX:MaxRAMPercentage=75.0"

ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar app.war"]