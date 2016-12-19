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
			<label>客户编号:</label> <input name="cid" class="easyui-validatebox">
		</div>
		<div class="fitem">
			<label>客户名称:</label> <input name="customer" class="easyui-validatebox">
		</div>
		<div class="fitem">
			<label>订单号码:</label> <input name="ordernumber" class="easyui-validatebox">
		</div>
		<div class="fitem">
			<label>商品编号:</label> <input name="commoditycode" class="easyui-validatebox">
		</div>
		<div class="fitem"> 
			<label>商品名称:</label> <input name="tradename" class="easyui-validatebox">
		</div>
		<div class="fitem">
			<label>电池货:</label> <input name="battery" class="easyui-validatebox">
		</div>
		<div class="fitem">
			<label>发送个数:</label> <input name="send" class="easyui-validatebox">
		</div>
		<div class="fitem">
			<label>sku码:</label> <input name="sku" class="easyui-validatebox">
		</div>
		<div class="fitem">
			<label>fba标签:</label> <input name="fba" class="easyui-validatebox">
		</div>
		<div class="fitem">
			<label>发送情况:</label> <input name="situation" class="easyui-validatebox">
		</div>
		<div class="fitem">
			<label>发送日期:</label> <input name="date" class="easyui-validatebox">
		</div>
		<div class="fitem">
			<label>发货地址:</label> <input name="shippingaddress" class="easyui-validatebox">
		</div>
		<div class="fitem"> 
			<label>亚马逊订单:</label> <input name="am" class="easyui-validatebox">
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

