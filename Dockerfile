FROM openjdk:11

ADD ./target/musicx-application-0.0.1-SNAPSHOT.jar /usr/src/musicx-application-0.0.1-SNAPSHOT.jar


WORKDIR usr/src

ENTRYPOINT ["java","-jar", "musicx-application-0.0.1-SNAPSHOT.jar"]