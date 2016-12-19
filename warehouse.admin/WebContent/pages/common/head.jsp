<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath}" scope="application"></c:set>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/jquery-easyui/themes/bootstrap/easyui.css"/>  
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/jquery-easyui/themes/icon.css"/>  
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/jquery-easyui/demo/demo.css"/>  
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/form.css"/>  
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/icon.css"/>  
    <!-- <script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui/jquery.min.js"></script> -->
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-1.7.1.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui/locale/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jeasyuiex.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/util.js"></script>  
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/datagridex.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/dict.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/fun.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/ckeditor/ckeditor.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/ckeditor/config.js"></script>
	<script type="text/javascript">
    	// js全局变量 工程名称 /qytxl.admin
    	function getPath(path){
        	return "${pageContext.request.contextPath}" + path;
    	}
    	
    	$( document ).ajaxError(function( event, jqxhr, settings, thrownError ) {
    		var msg = '系统错误';
    		if(jqxhr.status == 403){
    			msg = '权限错误';
    		}
    		if(jqxhr.status == 400){
    			msg = '参数错误';
    		}
            $.messager.progress('close');
	            $.messager.show({   // show error message  
	                title: '错误',  
	                msg: msg  
	            });  
    		});
    </script>
	
	