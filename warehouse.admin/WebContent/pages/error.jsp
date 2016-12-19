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
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/jquery-1.10.0.min.js"></script>  
    <script src="${pageContext.request.contextPath}/static/scripts/view-details.js" type="text/javascript"></script> 
<title>Insert title here</title>
</head>
<body style="padding:0px; overflow:hidden;margin: 50px;">
	<div class="error">
		<span>${errorMessage}</span>
	</div>
	<c:if test="${errorDetails != null }">	
	<div class="view-details">
		<a tabindex="0">显示详细信息</a>
		<pre>${errorDetails}</pre>
	</div>
	</c:if>
	<div>	
		<a href="javascript:history.back(-1);" >返回</a>
	</div>
</body>
</html>