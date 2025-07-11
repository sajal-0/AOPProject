package com.aop.aopProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aop.aopProject.entity.Employee;

@Repository
public interface AOPRepository extends JpaRepository<Employee, Integer>{

}
