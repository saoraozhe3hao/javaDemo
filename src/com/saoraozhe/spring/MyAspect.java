package com.saoraozhe.spring;

import org.aspectj.lang.ProceedingJoinPoint;


public class MyAspect {
	
	public MyAspect() {
	}
	
	public void before(){
		System.out.println("aspect before");
	}
	
	public void after(){
		System.out.println("aspect after");
	}
	
	public void afterReturning(){
		System.out.println("aspect afterReturning");
	}
	
	public void afterThrowing(){
		System.out.println("aspect afterThrowing");
	}
	
	public Object around(ProceedingJoinPoint pjp) {
		//顺序：before -> around 1 -> business -> around2 -> after 
		Object obj = null;
		try {
			System.out.println("aspect around 1.");
			obj = pjp.proceed();
			System.out.println("aspect around 2.");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return obj;
	}
}
