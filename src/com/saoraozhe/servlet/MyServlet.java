package com.saoraozhe.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MyServlet extends HttpServlet{
	
	public void init() throws ServletException{
		
	}
	
	public void doGet(HttpServletRequest request,HttpServletResponse response)
	throws ServletException,IOException {
		//相当于JSP的内置对象session
		HttpSession session = request.getSession();
		//相当于JSP的内置对象application
		ServletContext application = this.getServletContext();
		PrintWriter out = response.getWriter();
		out.println("hello,world.");
		//转发给JSP显示
		request.setCharacterEncoding("utf-8");
		request.getRequestDispatcher("index.jsp").forward(request,response);
	}
	public void doPost(HttpServletRequest request,HttpServletResponse response)
    throws ServletException,IOException{
		
	}
    public void destroy(){
    	super.destroy();
    }
}
