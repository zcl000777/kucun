<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

	<div id="userdlg" class="easyui-dialog" style="width:400px;height:340px;padding:10px 20px"  
            closed="true" buttons="#userdlg-buttons" modal="true">  
        <div class="ftitle">用户信息</div>  
        <form id="fm" class="fm" method="post">  
			<input name="id" type="hidden" value="0">
			<input name="phone" type="hidden" id="phone">  
            <div class="fitem">  
                <label>名称:</label>  
                <input name="name" class="easyui-validatebox" required="true">  
            </div>  
            <div class="fitem">  
                <label>性别:</label>  
                <select class="easyui-combobox" name="sex" style="width:100px;">  
    				<option value="男">男</option>  
    				<option value="女">女</option>  
				</select>  
            </div>  
            <div class="fitem">  
                <label>状态:</label>  
				<input name="status" class="easyui-combobox"
				    data-options="valueField:'code',textField:'name',enableNull:false,codeClass:'01',
				    url:'${pageContext.request.contextPath}/action/public/dict'">
            </div>  
            <div class="fitem">  
                <label>称谓:</label>  
                <input name="title">  
            </div>  
            <div class="fitem">  
                <label>描述:</label>  
                <input name="description">  
            </div>  
            <!--<div class="fitem">  
                <label>电话:</label>  
                <input name="phone">  
            </div> --> 
			
        </form>  
    </div>  
	<div id="userdlg-buttons">  
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveUser()">保存</a>  
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#userdlg').dialog('close')">取消</a>  
    </div>  
	
	<script type="text/javascript">
        var url;
        function newUser(){  
            $('#userdlg').dialog('open').dialog('setTitle','创建用户');
            initform('fm',function(){
                $('#userdlg').dialog('close');      // close the dialog  
                $('#dg').datagrid('reload');    // reload the user data  
            });  
 
            $('#fm').form('clear');  
            $('#fm')[0].id.value = "0";
            url = '${pageContext.request.contextPath}/action/system/user/create';
        }  
        function editUser(){  
            var row = $('#dg').datagrid('getSelected');  
            if (row){  
                $('#userdlg').dialog('open').dialog('setTitle','修改用户');
                initform('fm',function(){
                    $('#userdlg').dialog('close');      // close the dialog  
                    $('#dg').datagrid('reload');    // reload the user data  
                });  
                $('#fm').form('load',row);  
                url = '${pageContext.request.contextPath}/action/system/user/update';
            }  
        }  
        function saveUser(){  
            $('#fm').attr("action",url);
            
            $('#fm').submit(); 
        }  
        function delUser(){  
            var row = $('#dg').datagrid('getSelected');  
            if (row){  
                $.messager.confirm('确认','确定要删除这个用户么?',function(r){  
                    if (r){  
                    url = '${pageContext.request.contextPath}/action/system/user/delete';
                        $.post(url,{userId:row.id},function(result){  
                            if (result.status == 0){  
                                $('#dg').datagrid('reload');    // reload the user data  
                            } else {  
                                $.messager.show({   // show error message  
                                    title: '错误',  
                                    msg: result.message  
                                });  
                            }  
                        },'json');  
                    }  
                });  
            }  
        }  
        
	</script>
