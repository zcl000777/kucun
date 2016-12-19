<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page isELIgnored="false" %> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/blueprint/screen.css" type="text/css" media="screen, projection">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/view-details.css" type="text/css" media="screen, projection">
    <script src="${pageContext.request.contextPath}/static/lib/jquery/jquery-1.8.2.js" type="text/javascript"></script> 
    <script src="${pageContext.request.contextPath}/static/scripts/view-details.js" type="text/javascript"></script> 
<title>Insert title here</title>
</head>
<body style="padding:0px; overflow:hidden;margin: 50px;">
	<div class="success">
		<span>${message}</span>
	</div>
	<c:if test="${warnMessage != null }">	
	<div class="alert">
		<span>警告：</span>
		<span>${warnMessage}</span>
	</div>
	</c:if>
	<c:if test="${details != null }">	
	<div class="view-details">
		<a tabindex="0"><i class="l-icon-bookopen"></i>	显示详细信息</a>
		<pre>${details}</pre>
	</div>
	</c:if>
	<div>	
		<a href="javascript:history.back(-1);" >返回</a>
	</div>
</body>
</html>