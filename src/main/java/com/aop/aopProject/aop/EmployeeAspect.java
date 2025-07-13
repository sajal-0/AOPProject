package com.aop.aopProject.aop;

import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.aop.aopProject.entity.Employee;

@Aspect
@Component
public class EmployeeAspect {
	
	
	@Before(value = "execution(* com.aop.aopProject.controller.AOPController.*(..))")
	public void beforeAdvice(JoinPoint joinPoint) {	
		System.out.println("request to" +joinPoint.getSignature() +" started at ----------->  "+ new Date());
	}
	
	@After(value = "execution(* com.aop.aopProject.controller.AOPController.*(..))")
	public void afterAdvice(JoinPoint joinPoint) {	
		System.out.println("request to" +joinPoint.getSignature() +" ended at ---------------->	 "+ new Date());
	}
	

	@Before(value = "execution(* com.aop.aopProject.service.AOPService.*(..))")
	public void beforeAdviceForSeervice(JoinPoint joinPoint) {	
		System.out.println("request to service layer " +joinPoint.getSignature() +" started at ----------->  "+ new Date());
	}
	
	@After(value = "execution(* com.aop.aopProject.service.AOPService.*(..))")
	public void afterAdviceForService(JoinPoint joinPoint) {	
		System.out.println("request to service layer " +joinPoint.getSignature() +" ended at ---------------->	 "+ new Date());
	}
	
	@AfterReturning(value = "execution(* com.aop.aopProject.service.AOPService.addEmployee(..))", returning = "emp")
	public void afterReturningAdviceForAddEmployeeService(JoinPoint joinPoint,Employee emp) {	
		System.out.println("Bussiness logic to save an employee " +emp.getEmpid() +" started at ----------->  "+ new Date());
	}
	
	@AfterThrowing(value = "execution(* com.aop.aopProject.service.AOPService.addEmployee(..))", throwing = "exception")
	public void afterThrowingAdviceForAddEmployeeService(JoinPoint joinPoint,Exception exception) {	
		System.out.println("Bussiness logic to save an employee threws an exception "+ exception.getMessage());
	}
	
	@Around(value = "execution(* com.aop.aopProject.service.AOPService.addEmployee(..))")
	public Employee aroundAdviceForAddEmployeeService(ProceedingJoinPoint pjoinPoint) {	
		System.out.println("Inside Around advide aspect : a bussiness logic to save employee started at : " + new Date());
		try {
			Employee emp = (Employee)pjoinPoint.proceed();
			return emp;
		} catch (Throwable e) {
			e.printStackTrace();
		} 
		
		System.out.println("Inside Around advide aspect : a bussiness logic to save employee Ended at : " + new Date());
		return null;
	}
	
	
	
	

}
