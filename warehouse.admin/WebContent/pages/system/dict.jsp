<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>dict page</title>
    <c:import url="/pages/common/head.jsp"/>
	<script language="javascript">
		var classCode = null;
		function loaddict(){
			var row = $('#dg1').datagrid('getSelected');
			if(row){
				classCode = row.code;
				$('#dg2').datagrid("load",{classCode:row.code});
			}
				
		}
	</script>
  </head>
  
  <body>
	<div style="margin:10px 0;"></div>
	<div class="easyui-layout" data-options="fit:true">
		<div data-options="region:'west',split:true" title="字典分类" style="width:200px;">
			<table id="dg1" class="easyui-datagrid"  
					data-options="rownumbers:true,singleSelect:true,url:'${pageContext.request.contextPath}/action/system/dict/queryclass',toolbar:'#toolbar1',fit:true,fitColumns:true,showFooter:false,onSelect:loaddict">
				<thead>
					<tr>
						<th data-options="field:'code',width:60,formatter:complexCol">编码</th>
						<th data-options="field:'name',width:120,formatter:complexCol">名称</th>
					</tr>
				</thead>
			</table>
			<div id="toolbar1">  
		        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newClass()">添加</a>  
		        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editClass()">修改</a>  
		        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="delClass()">删除</a>  
		    </div>  
		</div>
		<div data-options="region:'center'" titile="字典项">
			<table id="dg2" class="easyui-datagrid"  
					data-options="rownumbers:true,singleSelect:true,url:'${pageContext.request.contextPath}/action/system/dict/queryitem',queryParams:{classCode:'00'},toolbar:'#toolbar2',fit:true,fitColumns:true,showFooter:true">
				<thead>
					<tr>
						<th data-options="field:'code',width:40,formatter:complexCol">代码</th>
						<th data-options="field:'name',width:80,formatter:complexCol">名称</th>
						<th data-options="field:'pinyin',width:80,formatter:complexCol">拼音索引</th>
						<th data-options="field:'param1',width:80,formatter:complexCol">参数1</th>
						<th data-options="field:'param2',width:80,formatter:complexCol">参数2</th>
						<th data-options="field:'ordernum',width:80,formatter:complexCol">排序</th>
					</tr>
				</thead>
			</table>
			<div id="toolbar2">  
		        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newItem()">添加</a>  
		        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editItem()">修改</a>  
		        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="delItem()">删除</a>  
		    </div>  
		</div>
	</div>
    
    <div style="display: none;">
    	<c:import url="dictclass.jsp"/>
    	<c:import url="dictitem.jsp"/>
	</div>
	
  </body>
</html>
