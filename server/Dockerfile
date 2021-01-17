FROM adoptopenjdk/openjdk11:jdk-11.0.9_11-alpine as dev

WORKDIR /app

RUN apk add --no-cache alpine-sdk

CMD [ "./gradlew","bootRun","--args=\"-agentlib:jdwp=transport=dt_socket,server=y,suspend=y,address=*:5050\"" ]

EXPOSE 8000