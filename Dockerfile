FROM openjdk:17
ADD target/DeliveryMatch-0.0.1-SNAPSHOT.jar deleverymatch.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","deleverymatch.jar"]