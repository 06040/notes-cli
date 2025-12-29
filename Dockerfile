FROM amazoncorretto:17-alpine

WORKDIR /app

COPY src/ ./src/
RUN mkdir -p data
RUN javac -d out src/com/example/*.java
ENTRYPOINT ["java", "-cp", "out", "com.example.App"]