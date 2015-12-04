package com.saoraozhe.struts;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class MyInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		// Struts框架 调用拦截器 -> 拦截器调用下一个拦截器 ->拦截器调用Action -> 
		//Action返回结果给拦截器 -> 拦截器返回结果给上一个拦截器 -> 拦截器返回结果给Struts框架
		System.out.println("Interceptor start");
		//获取上下文和session
		ActionContext context = ActionContext.getContext();
		Map<String,Object> session = context.getSession();
		//调用下一个拦截器，或者action，并获取其返回的结果
		String result = invocation.invoke();
		System.out.println("Interceptor end");
		//把结果返回给上一个拦截器，或者StrutsPrepareAndExecuteFilter
		return result;
	}
}
