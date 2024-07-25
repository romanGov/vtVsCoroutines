FROM openjdk:21
RUN mkdir /app
COPY /build/libs/demo-0.0.1-SNAPSHOT.jar app/virtual_threads-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","app/virtual_threads-0.0.1-SNAPSHOT.jar"]