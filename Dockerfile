FROM openjdk:8-jdk-alpine
EXPOSE 8080
ADD /target/k8s-sec-0.0.1-SNAPSHOT.jar k8s-sec-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "k8s-sec-0.0.1-SNAPSHOT.jar"]