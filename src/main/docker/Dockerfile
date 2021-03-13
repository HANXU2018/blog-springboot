FROM java:8
VOLUME /tmp
ADD springboot-demo-0.0.1-SNAPSHOT.jar /test.jar
EXPOSE 8989
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/test.jar"]