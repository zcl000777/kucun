<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" import="gaf2.core.security.SecurityContext"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<c:import url="/pages/common/head.jsp" />
<script type="text/javascript">
	$(function() {
		$.extend($.dictManager.options, {
			url : "${pageContext.request.contextPath}/action/public/dict"
		});
	});
</script>
</head>
<body>
<div style="margin: 10px 0;"></div>
	<div class="easyui-layout" data-options="fit:true"
		style="margin: 10px 0;">
		<div data-options="region:'center',title:'库存表'" style="width: 300px;">
			<table id="dg" class="easyui-datagrid"
				data-options="fitColumns:true,rownumbers:true, 
			singleSelect:true,
			url:'${pageContext.request.contextPath}/action/kucun/list',
			fit:true, 		
			toolbar: '#toolbar',
			showFooter:true,
			onSelect:dgsclick,
			pagination:true, 
			pageSize:20">
				<thead>
					<tr>
						<th data-options="field:'itemcode',width:100">商品编号</th>
						<th data-options="field:'tradename',width:100">商品名称</th>
						<th data-options="field:'battery',width:130">电池货</th>
						<th data-options="field:'connect',width:100">连接</th>
						<th data-options="field:'colour',width:100">颜色</th>
						<th data-options="field:'size',width:130">尺寸</th>
						<th data-options="field:'number',width:100">数量</th>
					</tr>
				</thead>
			</table>
			<div id="toolbar">
				<form id="fm" method="post">
				
					<div class="searchBar">
					   <span>号码:</span> <input name="phone" class="easyui-numberbox">
					   <a href="#" class="easyui-linkbutton" iconCls="icon-search"
							plain="true" onclick="javascript:doSearch()">查询</a> 
					   <span>号码状态:</span> <select name="status" onchange="doSearch()">
					   <option>全部</option>
					   <option value="未绑定">未绑定</option>
					   <option value="已绑定">已绑定</option>
					   </select>
					
						<a href="#" class="easyui-linkbutton" iconCls="icon-search"
							plain="true" onclick="javascript:doSearch()">刷新</a>
						
						<a href="#" class="easyui-linkbutton" iconCls="icon-add"
							plain="true" onclick="javascript:doAdd()">添加</a>
						
						<a href="#" class="easyui-linkbutton" iconCls="icon-edit"
							plain="true" onclick="javascript:doUpd()">修改</a>
						
						<a href="#" class="easyui-linkbutton" iconCls="icon-remove"
							plain="true" onclick="javascript:doDel()">删除</a>
						
						<a href="#" class="easyui-linkbutton" iconCls="icon-remove"
							plain="true" onclick="javascript:doCk()">出库</a>
							
						<a href="#" class="easyui-linkbutton" iconCls="icon-remove"
							plain="true" onclick="javascript:doHhrk()">换货入库</a>
							
					<!-- <a href="#" class="easyui-linkbutton" iconCls="icon-save"
							plain="true" onclick="javascript:exportExcel()">导出数据</a>-->
						
						<!-- 						<a href="#"	class="easyui-linkbutton" iconCls="icon-add"  plain="true" onclick="javascript:doAdd()">添加</a>  -->
						<!-- 						<a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="javascript:doUpd()">修改</a>  -->
						<!-- 						<a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="javascript:doDel()">删除</a> -->
					</div>
					<div class="menuBar"></div>
				</form>
			</div>
		</div>
	<div>
		<c:import url="form.jsp"></c:import>
	</div>
</body>
</html>
<script type="text/javascript">
	function doAdd() {
		addform("dlg_fm", "/action/kucun/add");
		$('#dlg').dialog('open').dialog('setTitle', '添加');
	}
	function doUpd() {
		var row = hasSelectdRow();
		if (row == null)
			return;
		commonform("dlg_fm", "/action/kucun/update");
		$('#dlg_fm').form('load', row);
		//changecheck(row.packagelist);
		$('#dlg').dialog('open').dialog('setTitle', '修改');
	}
	
	function doCk() {
		delform("/action/kucun/ck");
	}
	function doHhrk() {
		delform("/action/kucun/hhrk");
	}
	function doDel() {
		delform("/action/kucun/delete");
	}
	function doSearch() {
		var param = $.formData($("#fm"));
		$('#dg').datagrid('reload', param);
	}
	function dgclick(rowIndex, rowData) {
		var queryParams = $('#dg').datagrid('options').queryParams;
		var copyParas = queryParams;
		queryParams.schoolid = rowData.id; //设置值
		$('#dg').datagrid('options').queryParams = queryParams;
		$("#dg").datagrid('reload');
		$('#dg').datagrid('options').queryParams = copyParas;
	}
	
	function dgsclick(rowIndex, rowData) {
	//	$('#schoolid').combobox('setValue',rowData.school.id);
		$('#attribution').val($('#schoolid').combobox('getText'));
	}
	
	function doImp(){
		//var row = $('#dg1').datagrid('getSelected');
		//if (!row) {
		//	$.messager.alert('信息', '请选择学校！', 'info');
		//	return;
		//}
		//$("#dlgimp_fm").find("input[name='schoolid']").val(row.id);
		addform("dlgimp_fm", "/action/kucun/impkucun");
		$('#dlgimp').dialog('open').dialog('setTitle', '导入数据');
	}
	

	//导出excel的下载页
	function download_file(url){
	    if(typeof(download_file.iframe)== "undefined"){
	  	   var iframe = document.createElement("iframe");
	  	   download_file.iframe = iframe;
	  	   document.body.appendChild(download_file.iframe); 
	    }
	    //alert(download_file.iframe);
	    download_file.iframe.src = url;
	    download_file.iframe.style.display = "none";
	}

	function exportExcel(){
    	var url;
    	url='${pageContext.request.contextPath}/action/mobilekucun/expmobilekucun';
    	download_file(url);
	}
	
	function doSearch() {
		var param = $.formData($("#fm"));
	    $('#dg').datagrid('reload',param);    
	}
</script>
