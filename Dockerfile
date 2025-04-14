FROM amazoncorretto:21
WORKDIR /app
COPY target/hospital-service-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 9700
ENTRYPOINT [ "java", "-jar", "app.jar" ] 