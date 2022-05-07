package com.edison.cloud.cfgbeans;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConfigBean {//@Configuration + ConfigBean 等於applicationContext.xml文件

	@Bean
	@LoadBalanced //Spring Cloud Ribbon是基於Netflix Ribbon實現的一套客戶端 負載均衡的工具
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	
}