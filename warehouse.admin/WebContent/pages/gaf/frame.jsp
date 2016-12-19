<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>Welcome</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="description" content="This is main frame page">
	<c:import url="/pages/common/head.jsp"/>
    <script>
		function addTab(title, url){
			if ($('#tt').tabs('exists', title)){
				$('#tt').tabs('select', title);
			} else {
				var content = '<iframe scrolling="auto" frameborder="0"  src="'+url+'" style="width:100%;height:100%;"></iframe>';
				$('#tt').tabs('add',{
					title:title,
					content:content,
					closable:true
				});
			}
		}
		function treeClick(node)
		{
			//alert(node.text);  // alert node text property when clicked
			//alert(node.attributes.url);
			var title = node.text;
			var url = node.attributes.url;
			if(url.charAt(0) == '/')
				url = "${pageContext.request.contextPath}" + url;
			else
				url = "${pageContext.request.contextPath}/" + url;
				
			addTab(title, url);
			//alert(url);
		}
	</script>
      
  </head>
  
  <body>
	<div class="easyui-layout" data-options="fit:true">
		<div data-options="region:'north',href:'top.jsp'" style="height:100px"></div>
		<div data-options="region:'south',href:'buttom.jsp'" style="height:50px"></div>
		<div data-options="region:'west',split:true" title="功能导航" style="width:240px;">
			<ul class="easyui-tree" data-options="url:'${pageContext.request.contextPath}/action/navi/gaf/loaddata',onClick:treeClick">  
			</ul> 
			<!-- 
			<div class="easyui-accordion" data-options="fit:true,border:false">
				<div title="系统管理" style="padding:10px;">
					<ul class="easyui-tree" data-options="url:'${pageContext.request.contextPath}/action/navi/loaddata?parent=sysman',onClick:treeClick">  
					</ul> 
				</div>
				<div title="业务管理" style="padding:10px;">
					content2
				</div>
				<div title="日志审计" style="padding:10px">
					content3
				</div>
			</div>
			 -->
		</div>
		<div data-options="region:'center'">
			<div id="tt" class="easyui-tabs" data-options="fit:true,border:false,plain:true">
				<div title="Home" data-options="href:'home.jsp'" style="padding:10px"></div>
			</div>
		</div>
	</div>
  </body>
</html>
