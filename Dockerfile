FROM amazoncorretto:17.0.10-al2023-headless
ADD target/guama-transactions-service.jar guama-transactions-service.jar

ENTRYPOINT java -jar guama-transactions-service.jar
