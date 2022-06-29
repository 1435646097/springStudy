FROM java:8
WORKDIR /root
COPY interview.jar .
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "interview.jar"]