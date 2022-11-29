FROM openjdk:11
EXPOSE 8080
ADD target/Crud-0.0.1-SNAPSHOT.jar Crud-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/Crud-0.0.1-SNAPSHOT.jar"]