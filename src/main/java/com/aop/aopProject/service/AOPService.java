package com.aop.aopProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aop.aopProject.entity.Employee;
import com.aop.aopProject.repository.AOPRepository;

@Service
public class AOPService {

	@Autowired
	private AOPRepository repo;

	public List<Employee> fetchAllEmployees() {
		return repo.findAll();
	}

	public Employee addEmployee(Employee emp) throws Exception {
		if(emp.getName().length() > 5) {
			throw new Exception("soory recude size lvd");
		}
		return repo.save(emp);
	}

}
