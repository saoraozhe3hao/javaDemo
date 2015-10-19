<%@ page  contentType="text/html; charset=utf-8" %>
<%--导入java类 --%>
<%@ page import="com.saoraozhe.javaBean.Student" %>
<div>子页面</div>
<%
  //使用java类
  Student student = new Student();
  //读取cookie
  Cookie[] cookies = request.getCookies();
  if(cookies != null){
      out.println(cookies[0].getValue());
  }
  Cookie cookie = new Cookie("lang","zh");
  cookie.setValue("en");
  //保存cookie项到浏览器
  response.addCookie(cookie);
 %>
 <%--JSP 动作标签,useBean 创建一个bean对象 --%>
 <jsp:useBean id="studentA" class="com.saoraozhe.javaBean.Student"/>
 <%--JSP 动作标签,setProperty给bean对象的成员赋值，值从提交的表单里取 --%>
 <jsp:setProperty name="studentA" property="age"/>
 <%-- 指定值 --%>
 <jsp:setProperty name="studentA" property="age" value="10"/>
 <%--从请求行里取参数值 --%>
 <jsp:setProperty name="studentA" property="age" param="locale"/>
 <%=studentA.getAge() %>
 <%--JSP 动作标签,getProperty 获取bean对象成员 --%>
  <jsp:getProperty name="studentA" property="age"/>
  
  
