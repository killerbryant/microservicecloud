package com.edison.cloud.service;

import java.util.List;

import com.edison.cloud.entity.Dept;

public interface DeptService {
	public boolean add(Dept dept);
	public Dept get(Long id);
	public List<Dept> list();
}
