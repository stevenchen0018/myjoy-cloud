FROM openjdk:8
ARG JAR_FILE
COPY ${JAR_FILE} myjoy-eureka3-service.jar
EXPOSE 8802
ENTRYPOINT ["java","-jar","/myjoy-eureka3-service.jar"]
