package com.saoraozhe.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

//bean 的初始化前置后置处理器
public class MyBeanPostProcessor implements BeanPostProcessor {

	//bean的生命周期，构造 -> 属性注入 -> 初始化前置处理 ->  init-method -> 初始化后置处理 -> 使用 -> destroy-method
	public Object postProcessBeforeInitialization(Object bean, String beanName)
			throws BeansException {
		System.out.println("postProcessBeforeInitialization");
		return bean;
	}
	
	public Object postProcessAfterInitialization(Object bean, String beanName)
			throws BeansException {
		System.out.println("postProcessAfterInitialization");
		return bean;
	}



}
