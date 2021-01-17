FROM node:15.5.0-alpine3.10

WORKDIR /app

COPY package.json .
COPY yarn.lock .

RUN apk add --no-cache alpine-sdk
RUN yarn install

COPY . .

EXPOSE 3000

CMD ["yarn", "start"]

