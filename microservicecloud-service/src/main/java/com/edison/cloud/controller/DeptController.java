package com.edison.cloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.edison.cloud.entity.Dept;
import com.edison.cloud.service.DeptService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

@Api(tags = "部門管理")
@RestController
public class DeptController {

	@Autowired
	private DeptService service;
	
	@Autowired
	private DiscoveryClient client;
	
	@ApiOperation("新增部門資料")
	@RequestMapping(value = "/dept/add", method = RequestMethod.POST)
	public boolean add(@RequestBody Dept dept) {
		return service.add(dept);
	}
	
	@ApiOperation("取得單一部門資料")
	@RequestMapping(value = "/dept/get/{id}", method = RequestMethod.GET)
	public Dept get(@PathVariable("id") Long id) {
		return service.get(id);
	}
	
	@ApiOperation("取得所有部門資料")
	@RequestMapping(value = "/dept/list", method = RequestMethod.GET)
	public List<Dept> list() {
		return service.list();
	}
	
	@ApiIgnore
	@RequestMapping(value = "/dept/discovery", method = RequestMethod.GET)
	public Object discovery() { //服務發現 對於註冊進eureka裡面的微服務，可以通過服務發現來獲得該服務的信息
		List<String> list = client.getServices();
		System.out.println("**********" + list);
		
		List<ServiceInstance> srvList = client.getInstances("MICROSERVICECLOUD-SERVICE");
		for (ServiceInstance element : srvList) {
			System.out.println(element.getServiceId() + "\t" + element.getHost() + "\t" + element.getPort() + "\t" + element.getUri());
		}
		
		return this.client;
	}
}
