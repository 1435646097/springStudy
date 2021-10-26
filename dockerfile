FROM java:8
workdir /root
copy interview.jar /root/interview.jar
expose 8080
RUN ["java", "-jar", "interview.jar"]