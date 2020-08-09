FROM openjdk:8
ARG JAR_FILE
COPY ${JAR_FILE} myjoy-eureka1-service.jar
EXPOSE 8800
ENTRYPOINT ["java","-jar","/myjoy-eureka1-service.jar"]
