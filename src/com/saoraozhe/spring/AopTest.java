package com.saoraozhe.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AopTest {
	
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/saoraozhe/spring/bean/aop.xml");
		MyBusiness business = (MyBusiness) ctx.getBean("myBusiness");		
		//执行业务类的方法（切入点）前后，Spring框架自动调用切面类的方法。即AOP的目标。写一个切面功能，如日志，通过配置，执行业务功能的前后，调用切面功能。
		business.pointcut();
	}

}
