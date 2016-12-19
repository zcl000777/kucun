<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

	<div id="acdlg" class="easyui-dialog" style="width:400px;height:280px;padding:10px 20px"  
            closed="true" buttons="#acdlg-buttons" modal="true">  
        <div class="ftitle">登录信息</div>  
        <form id="acfm" class="fm" method="post" action="${pageContext.request.contextPath}/action/system/user/account">  
            <div class="fitem">  
                <label>登录名:</label>  
                <input name="account" class="easyui-validatebox" required="true" validType="remotex['${pageContext.request.contextPath}/action/system/user/check','account','acfm','id']" invalidMessage="登录名已存在">  
	            <input name="id" type="hidden" value="0">  
            </div>  
            <div class="fitem">  
                <label>密码:</label>  
                <input id="pwd" name="password" type="password" class="easyui-validatebox" required="true">  
            </div>  
            <div class="fitem">  
                <label>确认:</label>  
                <input name="confirm" type="password" class="easyui-validatebox" required="true" validType="equals['#pwd']">  
            </div>  
			
        </form>  
    </div>  
	<div id="acdlg-buttons">  
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveAccount()">保存</a>  
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#acdlg').dialog('close')">取消</a>  
    </div>  
	
	<script type="text/javascript">
        function account(){  
            var row = $('#dg').datagrid('getSelected');  
            if (row){  
                $('#acdlg').dialog('open').dialog('setTitle','设置登录信息');
                initform('acfm',function(){
                    $('#acdlg').dialog('close');      // close the dialog  
                    $('#dg').datagrid('reload');    // reload the user data  
                });  
                $('#acfm').form('clear');
                if(row.account)  
                	$('#acfm').form('load',row.account); 
                $('#acfm')[0].id.value = row.id;
                
                	
            }  
        }  
        function saveAccount(){  
            $('#acfm').submit(); 
        }  
        
	</script>
