package com.edison.cloud;

import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient //本服務啟動後會自動註冊進eureka服務中
@EnableDiscoveryClient //服務發現 對於註冊進eureka裡面的微服務，可以通過服務發現來獲得該服務的信息
public class DeptProvider {
	public static void main(String[] args) {
		SpringApplication.run(DeptProvider.class, args);
	}
	
	@PostConstruct
    void started() {
      TimeZone.setDefault(TimeZone.getTimeZone("GMT+8"));
	}
}
