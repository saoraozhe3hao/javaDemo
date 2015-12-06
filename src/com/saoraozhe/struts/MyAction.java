package com.saoraozhe.struts;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.util.ServletContextAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.saoraozhe.javaBean.Student;

public class MyAction extends ActionSupport implements ModelDriven<Student>,ServletRequestAware,ServletResponseAware,ServletContextAware {

	//定义成员用于自动接收struts.xml里面设置的action参数，需要有getter( )和setter( )
	private String param;
	//定义成员用于自动接收http请求参数username，需要有getter( )和setter( )
	private String username;
	//定义对象成员，用于接收参数 student.xxx。以此类推，String[] names可以接收参数 names[xxx]
	private Student student;
	//定义对象成员，用于接收参数 xxx，自动塞到studentModel，需实现ModelDriven<T>接口getModel( )
   private Student studentModel = new Student();
   //以上注释里的动作，由默认的内置拦截器栈完成，即struts-default.xml里的defaultStack
  
   private HttpServletRequest request;
   private HttpServletResponse response;
   private HttpSession session;
   private ServletContext context;
   
	
	@Override
	public String execute() throws Exception {
		//测试URL ：http://localhost:8080/javaDemo/struts/myAction.action?username=44&student.age=3&age=7
		System.out.println(username);
		System.out.println(param);
		System.out.println(student.getAge());
		System.out.println(studentModel.getAge());
		return SUCCESS;
	}
	
	public String add(){
		//该action没经过 defaultStack，因此username不会自动从参数获取
		System.out.println(username);
		System.out.println("add");
		return SUCCESS;
	}
	
	 //实现接口ServletRequestAware，ServletResponseAware，ServletContextAware的方法，会被自动调用，并传入请求，响应和上下文
	public void setServletContext(ServletContext context) {
		this.context = context;
	}

	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
		this.session = request.getSession();
	}
	
	public Student getModel() {
		return studentModel;
	}
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getParam() {
		return param;
	}

	public void setParam(String param) {
		this.param = param;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
	
}
