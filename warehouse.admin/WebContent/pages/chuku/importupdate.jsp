<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 
<div id="dlgimp" class="easyui-dialog"
	style="width: 750px; height: 480px; padding: 10px 20px" closed="true"
	closable="false" buttons="#dlgimp_buttons" modal="true">
	<form id="dlgimp_fm" class="fm" method="post" action="${pageContext.request.contextPath}/action/mobileupdate/impmobilecard"
		enctype="multipart/form-data"> 
		<input type="hidden" name="schoolid"/> 
	<div class="fitem">  
	<input type="file" name="exlfile" accept=".xls"><br/>请选择要导入的模板文件(excel模板)<br/>
	</div>
	</form>
</div>
 
 <div id="dlgimp_buttons">
	<a href="javascript:void(0)" class="easyui-linkbutton"
		iconCls="icon-ok" onclick="dosubmit()">确定</a> <a 
		href="javascript:void(0)" class="easyui-linkbutton"
		iconCls="icon-cancel" onclick="doclose()">关闭</a>
</div>
<script type="text/javascript">
	function dosubmit() {
		//var sel = $('#status option:selected').attr("value");
		//if(sel==null||sel=="")
		//	{
		//	  $.messager.alert('信息', '请选择导入号码状态！', 'info');
		//	  return;
		//	}
		$('#dlgimp_fm').submit();
	};
	function doclose() {
		$('#dlgimp_fm').form('clear');
		$('#dlgimp').dialog('close');
		$('#dg').datagrid('clearSelections');
		$('#dg').datagrid('reload');
	}; 
</script>