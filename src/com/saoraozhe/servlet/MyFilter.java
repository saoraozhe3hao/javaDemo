package com.saoraozhe.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class MyFilter implements Filter{



	public void init(FilterConfig arg0) throws ServletException {
		//传入web.xml里面配置的初始化参数
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		System.out.println("doFilter start");		
		//一给请求的过滤器链，由这个请求所匹配的过滤器组成，顺序与web.xml中的配置顺序相同
		//过滤器链放行
		chain.doFilter(request, response);
		System.out.println("doFilter end");
	}

	public void destroy() {
		
	}
}
