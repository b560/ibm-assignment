FROM openjdk:8
EXPOSE 8086
ADD target/ibm-assignment.jar ibm-assignment.jar
ENTRYPOINT ["java", "-jar", "/ibm-assignment.jar"]