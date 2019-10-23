FROM gradle:5.6.3-jdk11
WORKDIR /testapp
COPY . .
CMD ./gradlew clean bootRun