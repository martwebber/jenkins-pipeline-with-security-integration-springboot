FROM maven:3-jdk-17-alpine

WORKDIR /usr/src/app

COPY . /usr/src/app
RUN mvn package

ENV PORT 5000
EXPOSE $PORT
CMD [ "sh", "-c", "mvn -Dserver.port=${PORT} spring-boot:run" ]
#
#FROM openjdk:17
#EXPOSE 8090
#ADD target/jenkins-pipeline-with-security-integration.jar jenkins-pipeline-with-security-integration.jar
#ENTRYPOINT ["jav/a", "-jar","/jenkins-pipeline-with-security-integration.jar"]