<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<div id="dlg" class="easyui-dialog" style="width:200px;height:100px;" closed="true" data-options="modal:true,iconCls:'icon-tip'"> 
   	<div></div>
	<div align="center"><h3>请选择一行数据</h3></div>
	<div align="center"><input type="button" value="确  定" onclick="javascript:$('#dlg').dialog('close')"/></div>
</div>
<div id="dlg1" class="easyui-dialog" style="width:200px;height:100px;" closed="true" data-options="modal:true,iconCls:'icon-tip'"> 
	<div align="center"><h3>文件类型错误，请选择图片</h3></div>
	<div align="center"><input type="button" value="确  定" onclick="javascript:$('#dlg1').dialog('close')"/></div>
</div> 

<div id="dlg2" class="easyui-dialog" style="width:200px;height:100px;" closed="true" data-options="modal:true,iconCls:'icon-tip'"> 
	<div align="center"><h3>请选择轮播图</h3></div>
	<div align="center"><input type="button" value="确  定" onclick="javascript:$('#dlg2').dialog('close')"/></div>
</div> 