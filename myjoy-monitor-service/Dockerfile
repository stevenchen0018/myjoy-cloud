FROM openjdk:8
ARG JAR_FILE
COPY ${JAR_FILE} myjoy-monitor-service.jar
EXPOSE 8831
ENTRYPOINT ["java","-jar","/myjoy-monitor-service.jar"]
