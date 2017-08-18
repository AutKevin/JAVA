<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />  
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css"/>
	<script src="${pageContext.request.contextPath}/js/jquery.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/cloud.js" type="text/javascript"></script>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
  <p>"${user.username}"已登录</p>
  <a href="${pageContext.request.contextPath}/servlet/cancleloginservlet">注销</a>
  <img alt="tomcat" src="${pageContext.request.contextPath}/img/tomcat.ico">
        <%--使用c:url标签构建url，构建好的url存储在servletDemo1变量中--%>
        <c:url value="/servlet/indexservlet" scope="page" var="servletDemo1">
            <%--构建的url的附带的中文参数 ，参数名是：username，值是：秋夜雨巷--%>
            <c:param name="username" value="秋夜雨巷"></c:param>
        </c:url>
        <%--使用get的方式访问 --%>
        <a href="${servletDemo1}">超链接(get方式请求)</a>

	<form action="${pageContext.request.contextPath}/servlet/indexservlet" method="post">
		用户名:<input name='username'  type="text" vlaue='七夜' /> 
		<input type="submit" value="提交"/>
	</form>
	<hr>
	<form action="${pageContext.request.contextPath}/servlet/indexservlet" method="post">
           留言:
           <textarea rows="8" cols="70" name="username">
           <script type="text/javascript">
           while(true){
               alert("死循环了，我会不停地弹出了");
           }
           </script>
           <a href="http://www.cnblogs.com">访问博客园</a>
           </textarea>
           <input type="submit" value="发表">
       </form>
</body>
</html>
