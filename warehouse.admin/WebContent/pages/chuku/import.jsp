<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 
<div id="dlgimp" class="easyui-dialog"
	style="width: 750px; height: 480px; padding: 10px 20px" closed="true"
	closable="false" buttons="#dlgimp_buttons" modal="true">
	<form id="dlgimp_fm" class="fm" method="post"
		enctype="multipart/form-data"> 
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
		$('#dlgimp_fm').submit();
	};
	function doclose() {
		$('#dlgimp_fm').form('clear');
		$('#dlgimp').dialog('close');
		//$('#dg').datagrid('clearSelections');
		$('#dg').datagrid('reload');
	}; 
</script>

