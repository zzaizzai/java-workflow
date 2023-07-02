package com.example.demo.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.model.MyInformation;

@Aspect
@Component
public class MethodLoggingAspect {

	@Autowired
	MyInformation myInformation;

	@Around("execution(* com.example.demo.controller.*Controller.mypage(..))")
	public Object checkLogin(ProceedingJoinPoint jp) throws Throwable {
		if (myInformation.isLoggedIn() == false) {
			System.err.println("Please do login!");
			return "redirect:/account/login";
		}
		return jp.proceed();

	}

	@Around("execution(* com.example.demo.controller.*Controller.*(..))")
	public Object log(ProceedingJoinPoint jp) throws Throwable {

		if (myInformation.isLoggedIn() == false) {
			System.out.print("Guest ) ");
		} else {
			System.out.print(myInformation.getName() + " ) ");
		}

		System.out.println("Start: " + jp.getSignature());
		try {

			if (myInformation.isLoggedIn() == false) {
				System.out.print("Guest ) ");
			} else {
				System.out.print(myInformation.getName() + " ) ");
			}

			Object result = jp.proceed();
			System.out.println("End: " + jp.getSignature() + " Return=" + result);
			return result;
		} catch (Exception e) {
			System.out.println("Error: " + jp.getSignature());
			e.printStackTrace();
			throw e;
		}
	}
}
