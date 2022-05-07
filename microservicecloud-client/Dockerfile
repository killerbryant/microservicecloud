# 基礎鏡像使用java
FROM java:8
EXPOSE 8085
ARG JAR_FILE
ADD target/${JAR_FILE} microservicecloud-client.jar
ENTRYPOINT ["java", "-jar","microservicecloud-client.jar","--server.port=8085"]