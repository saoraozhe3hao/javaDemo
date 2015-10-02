<%-- jsp指令 --%>
<%@ page  contentType="text/html; charset=utf-8" %>
<!DOCTYPE>
<html>
  <head>
    <title>My JSP 'index.jsp' starting page</title>
  </head>
  
  <body> 
    <%-- jsp指令，include把sub.jsp代码包含进来再整体编译 --%>
    <%@ include file="app/views/sub.jsp"%>
    <br>
    <%-- jsp动作标签，include把sub.jsp解释后的输出包含进来 --%>
    <jsp:include page="app/views/sub.jsp"/>
    <br>conThis is my JSP page. 中文<br>
    <%-- jsp声明 --%>
    <%! 
        String s = "打印";
        int sum(int x,int y){
           return x + y;
        }
     %>
    <%
    //JSP 脚本，即java代码
    //内置对象，out,request,response,seesion,application
    request.setCharacterEncoding("utf-8");
    //获取请求行参数
    out.println(request.getParameter("locale"));
    //获取请求体参数
    request.setAttribute("name","hong");
    out.println(request.getAttribute("name"));
    //获取会话参数
    session.setAttribute("age",35);
    out.println(session.getAttribute("age"));
    //获取应用参数，所有请求都是同一个application，除非tomcat关闭
    application.setAttribute("appName","应用名");
    out.println(application.getAttribute("appName"));
    //请求重定向,设置状态码302,响应头Location
    //response.sendRedirect("app/views/sub.jsp");
    //请求转发,地址栏不变    
    //request.getRequestDispatcher("app/views/sub.jsp").forward(request,response);
     %>     
     <%-- jsp表达式 --%>
     <%= sum(1,2) %>
     <%-- 与上面的请求转发等效 ,同时传递请求行参数
     <jsp:forword page="app/views/sub.jsp">         
         <jsp:param value="222" name="length"/>
     </jsp:forword>
     --%>
  </body>
</html>
