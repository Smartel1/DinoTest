### Test app for DINO
Simple CRUD service with only entity User.

## Used technologies
Java 11, Spring Boot 2.2.0, Gradle 5.6, Postgres 10, Docker

## Installation
Run docker-compose:
```shell script
docker-compose run --publish 8080:8080 app
```

## Available endpoints:
- GET /user - list all users
- GET /user/{id} - show user with id. Returns 404 error if user not found
- POST /user - create user. Required fields to send: name, surname, address, birthdate
- PUT /user/{id} - update user. Returns 404 error if user not found
- DELETE /user/{id} - delete user. Returns 404 error if user not found


