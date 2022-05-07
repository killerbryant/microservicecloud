# 基礎鏡像使用java
FROM java:8
EXPOSE 8001
ARG JAR_FILE
ADD target/${JAR_FILE} microservicecloud-service.jar
ENTRYPOINT ["java", "-jar","microservicecloud-service.jar","--server.port=8001"]