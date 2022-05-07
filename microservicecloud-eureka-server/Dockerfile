# 基礎鏡像使用java
FROM java:8
EXPOSE 7001
ARG JAR_FILE
ADD target/${JAR_FILE} microservicecloud-eureka-server.jar
ENTRYPOINT ["java", "-jar","microservicecloud-eureka-server.jar","--server.port=7001"]