package com.aop.aopProject.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aop.aopProject.entity.Employee;
import com.aop.aopProject.service.AOPService;

@RestController
@RequestMapping("/aop")
public class AOPController {
	
	@Autowired
	AOPService service;

	
	@GetMapping("/getall")
	public ResponseEntity<List<Employee>> fetchAllEmployees(){
		return new ResponseEntity<List<Employee>>(service.fetchAllEmployees(),HttpStatus.OK);
	}
	
	@PostMapping("/save")
	public ResponseEntity<?> addEmployee(@RequestBody Employee emp) throws Exception{
		return new ResponseEntity<Employee>(service.addEmployee(emp),HttpStatus.ACCEPTED);
	}
}
