<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 
<div id="dlg" class="easyui-dialog"
	style="width: 750px; height: 480px; padding: 10px 20px" closed="true"
	closable="false" buttons="#dlg_buttons" modal="true">
	<form id="dlg_fm" class="fm" method="post"
		enctype="multipart/form-data"> 
		<input type="hidden" name="id"/> 
		<!-- <input type="hidden" name="schoolid"/> -->
		<!-- <input type="hidden" name="schoolid" id="schoolid"/> -->
		<input type="hidden" name="createtime"/>
		<input type="hidden" name="attribution" id="attribution">  
		<div class="fitem">
			<label>商品编号:</label> <input name="itemcode" class="easyui-validatebox">
		</div>
		<div class="fitem">
			<label>换货时间:</label> <input name="time" class="easyui-validatebox">
		</div>
		<div class="fitem">
			<label>换货数量:</label> <input name="barter" class="easyui-validatebox">
		</div>
		<div class="fitem">
			<label>实际数量:</label> <input name="reality" class="easyui-validatebox">
		</div>
		<div class="fitem">
			<label>检品人:</label> <input name="testarticle" class="easyui-validatebox">
		</div>
		<div class="fitem">
			<label>存放仓位:</label> <input name="position" class="easyui-validatebox">
		</div>
		
	</form>
</div>
 
<div id="dlg_buttons">
	<a href="javascript:void(0)" class="easyui-linkbutton"
		iconCls="icon-ok" onclick="dosubmits()">确定</a> <a 
		href="javascript:void(0)" class="easyui-linkbutton"
		iconCls="icon-cancel" onclick="docloses()">关闭</a>
</div>
<script type="text/javascript">
	function dosubmits() {
		$('#dlg_fm').submit();
	};
	function docloses() {
		$('#dlg_fm').form('clear');
		$('#dlg').dialog('close');
		$('#dg').datagrid('reload');
	};
	function changeatt(){
		//alert($('#schoolid').combobox('getText'));
		//$('#attribution').val($('#schoolid').combobox('getText'));
		
	}
</script>

