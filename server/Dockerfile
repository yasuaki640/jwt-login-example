FROM adoptopenjdk/openjdk11:jdk-11.0.9_11-alpine as dev

WORKDIR /app

RUN apk add --no-cache alpine-sdk

CMD [ "./gradlew","bootRun"]

EXPOSE 8080