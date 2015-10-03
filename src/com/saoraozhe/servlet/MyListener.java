package com.saoraozhe.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

//实现application,session,request的监听器接口
public class MyListener implements ServletContextListener,HttpSessionListener,ServletRequestListener, 
//参数变化监听接口
ServletContextAttributeListener,HttpSessionAttributeListener,ServletRequestAttributeListener{

	//ServletContextListener 的方法
	public void contextInitialized(ServletContextEvent event) {
		System.out.println("contextInitialized");
		//获取application
		ServletContext application = event.getServletContext();
		//获取在web.xml中配置的初始化参数
		String initParam = application.getInitParameter("initParam");
		System.out.println(initParam);
	}
	
	//ServletContextListener 的方法
	public void contextDestroyed(ServletContextEvent event) {
		System.out.println("contextDestroyed");
	}

	//HttpSessionListener 的方法
	public void sessionCreated(HttpSessionEvent event) {
		HttpSession session = event.getSession();
		System.out.println("sessionCreated");
	}
	//HttpSessionListener 的方法
	public void sessionDestroyed(HttpSessionEvent event) {
		
	}

	//ServletRequestListener 的方法
	public void requestInitialized(ServletRequestEvent event) {
		System.out.println("requestInitialized");
		ServletRequest request = event.getServletRequest();
	}

	//ServletRequestListener 的方法
	public void requestDestroyed(ServletRequestEvent event) {
		
	}

	//ServletContextAttributeListener 的方法
	public void attributeAdded(ServletContextAttributeEvent event) {
		
	}
	//ServletContextAttributeListener 的方法
	public void attributeRemoved(ServletContextAttributeEvent event) {
		
	}
	//ServletContextAttributeListener 的方法
	public void attributeReplaced(ServletContextAttributeEvent event) {
		
	}

	//HttpSessionAttributeListener 的方法
	public void attributeAdded(HttpSessionBindingEvent seevent) {
		
	}
	//HttpSessionAttributeListener 的方法
	public void attributeRemoved(HttpSessionBindingEvent event) {
		
	}
	//HttpSessionAttributeListener 的方法
	public void attributeReplaced(HttpSessionBindingEvent event) {
		
	}

	//ServletRequestAttributeListener 的方法
	public void attributeAdded(ServletRequestAttributeEvent arg0) {
		
	}
	//ServletRequestAttributeListener 的方法
	public void attributeRemoved(ServletRequestAttributeEvent arg0) {
		
	}
	//ServletRequestAttributeListener 的方法
	public void attributeReplaced(ServletRequestAttributeEvent arg0) {
		
	}

}
