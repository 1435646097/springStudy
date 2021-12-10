FROM java:8
workdir /root
copy interview.jar .
expose 8080
ENTRYPOINT ["java", "-jar", "interview.jar"]