FROM openjdk:8
ARG JAR_FILE
COPY ${JAR_FILE} myjoy-eureka-master-service.jar
EXPOSE 8801
ENTRYPOINT ["java","-jar","/myjoy-eureka-master-service.jar"]
