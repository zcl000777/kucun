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
	<script language="javascript">
	
		function doSearch(){

			var param = $.formData($("#fm"));

			var date = $.getDate($("#eventDate"));
			if(date){
				param.date = date;
				//$("#eventDate").val(date);
			}

		    $('#dg').datagrid('reload',param);    
		}
		
        function initform2(fmid,onSuccess){
            $('#'+fmid).form({  
                onSubmit: function(param){
                	var validate = $(this).form('validate');
                	if(validate)
                		$.blockUI($(".easyui-dialog"));
                	return validate;
                },  
                success: function(data){ 
                	$.unblockUI($(".easyui-dialog"));
                    var result = eval('('+data+')');  
                    if (result.status != 0){  
                        $.messager.show({  
                            title: '错误',  
                            msg: result.message
                        });  
                    } else {  
                    	if(onSuccess)
                    		onSuccess();
                    }  
                }  
            });  
        }
		
	</script>
  </head>
  
  <body>
	<div style="margin:10px 0;"></div>
	<table id="dg" class="easyui-datagrid" title="日志管理" 
			data-options="rownumbers:true,
			singleSelect:true,
			url:'${pageContext.request.contextPath}/action/system/logs/list',
			toolbar:'#toolbar',
			fit:true,
			showFooter:true,
			pagination:true,
			pageSize:20">
		<thead>
			<tr>
				<th data-options="field:'eventType',width:80,formatter:complexCol">事件类型</th>
				<th data-options="field:'eventDesc',width:200,formatter:complexCol">事件描述</th>
				<th data-options="field:'eventTime',width:80,formatter:dateCol">发生时间</th>
				<th data-options="field:'eventParam',width:200,formatter:complexCol">事件参数</th>
				<th data-options="field:'resultDesc',width:200,formatter:complexCol">结果描述</th>
				<th data-options="field:'userId',width:60,align:'center',formatter:complexCol">用户id</th>
				<th data-options="field:'userIp',width:60,align:'center',formatter:complexCol">用户ip</th>
				<th data-options="field:'loginName',width:60,align:'center',formatter:complexCol">登录名</th>
			</tr>
		</thead>
	</table>
	<div id="toolbar">
        <form id="fm" method="post">  
    	<span> 日期:</span>  
    	<input id="eventDate" name="eventDate" class="easyui-datebox"></input>  
    	<span> 事件类型:</span>  
		<input name="eventType" class="easyui-combobox"
		    data-options="valueField:'code',textField:'name',enableNull:true,nullText:'(所有类型)',codeClass:'22',
		    url:'${pageContext.request.contextPath}/action/public/dict'">
    	<span> 登录名:</span>  
		<input name="loginName" type="text"/>
    	<span> IP地址:</span>  
		<input name="userIp" type="text"/>
        <a href="#" class="easyui-linkbutton" iconCls="icon-tip"plain="true" onclick="javascript:doSearch()">查询</a>   
        <a href="#" class="easyui-linkbutton" iconCls="icon-search" plain="true" onclick="showDetails()">查看详情</a>
		</form>
    </div>  
    
    <div style="display: none;">
	<c:import url="logdetails.jsp"/>
	</div>
	
  </body>
</html>
