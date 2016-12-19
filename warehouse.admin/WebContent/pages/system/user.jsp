<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>user page</title>
    <c:import url="/pages/common/head.jsp"/>
    <script type="text/javascript">
		$(function(){
			$.extend($.dictManager.options, {url:"${pageContext.request.contextPath}/action/public/dict"});
		});
    </script>
  </head>
  
  <body>
	<div style="margin:10px 0;"></div>
	<table id="dg" class="easyui-datagrid" title="用户管理" 
			data-options="rownumbers:true,singleSelect:true,url:'${pageContext.request.contextPath}/action/system/user/query',toolbar:'#toolbar',fit:true,fitColumns:true,showFooter:true">
		<thead>
			<tr>
				<th data-options="field:'name',width:80,formatter:complexCol">名称</th>
				<th data-options="field:'sex',width:60,align:'center',formatter:complexCol">性别</th>
				<th data-options="field:'title',width:100,formatter:complexCol">称谓</th>
				<th data-options="field:'description',width:200,formatter:complexCol">描述</th>
				<!-- <th data-options="field:'email',width:100,formatter:complexCol">电子邮件</th> -->
				<th data-options="field:'status',width:60,align:'center',formatter:complexCol,codeClass:'01'">状态</th>
				<th data-options="field:'account.account',width:60,formatter:complexCol">登录名</th>
			</tr>
		</thead>
	</table>
	<div id="toolbar">  
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newUser()">添加</a>  
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editUser()">修改</a>  
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="delUser()">删除</a>  
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-tip" plain="true" onclick="account()">登录设置</a>  
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-tip" plain="true" onclick="setRole()">权限设置</a>  
    </div>  
    
    <div style="display: none;">
	<c:import url="userform.jsp"/>
	<c:import url="accountform.jsp"/>
	<c:import url="roleform.jsp"/>
	</div>
	
  </body>
</html>
