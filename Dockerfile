FROM openjdk:17-jdk-alpine
COPY target/package-manager-1.0-SNAPSHOT.jar package-manager-1.0-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/package-manager-1.0-SNAPSHOT.jar"]