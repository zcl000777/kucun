<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>user page</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/themes/default/easyui.css">  
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/themes/icon.css">  
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/demo/demo.css">  
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/jquery-1.10.0.min.js"></script>  
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/locale/easyui-lang-zh_CN.js"></script>
  </head>
  
  <body>
	<div style="width:400px;height:280px;padding:10px 20px"  
            >  
        <div class="ftitle">用户信息</div>
        <form:form id="fm" modelAttribute="data" method="POST" action="${pageContext.request.contextPath}/action/system/user/create">   
            <div class="fitem">  
                <label>名称:</label>
                <form:input path="name" cssClass="easyui-validatebox"/>
            </div>  
            <div class="fitem">  
                <label>性别:</label>  
                <input name="data.name">  
            </div>  
            <div class="fitem">  
                <label>称谓:</label>  
                <input name="data.title">  
            </div>  
            <div class="fitem">  
                <label>描述:</label>  
                <input name="data.description">  
            </div>  
            <div class="fitem">  
                <label>电话:</label>  
                <input name="data.phone">  
            </div>  
            <div class="fitem">  
                <label>电子邮件:</label>  
                <input name="data.email" class="easyui-validatebox" validType="email">  
            </div>  
			
        </form:form>  
    </div>  
	<div id="userdlg-buttons">  
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveUser()">Save</a>  
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#userdlg').dialog('close')">Cancel</a>  
    </div>  
	
	<script type="text/javascript">
        var url;
        var form;
        function newUser(){  
            $('#userdlg').dialog('open').dialog('setTitle','创建用户');  
            $('#fm').form('clear');  
            url = '${pageContext.request.contextPath}/action/system/user/create';
        }  
		function editUser(){  
            var row = $('#dg').datagrid('getSelected');  
            if (row){  
                $('#dlg').dialog('open').dialog('setTitle','修改用户');  
                $('#fm').form('load',row);  
                url = '${pageContext.request.contextPath}/action/system/user/update?data.id='+row.id;  
            }  
        }  
        function saveUser(){  
            $('#fm').form({  
                url: url,  
                onSubmit: function(){  
                    return $(this).form('validate');  
                },  
                success: function(data){ 
                    var result = eval('('+data+')');  
                    if (result.status != 0){  
                        $.messager.show({  
                            title: '错误',  
                            msg: result.message
                        });  
                    } else {  
                        $('#userdlg').dialog('close');      // close the dialog  
                        $('#dg').datagrid('reload');    // reload the user data  
                    }  
                }  
            });  
            
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
    <style type="text/css">  
        #fm{  
            margin:0;  
            padding:10px 30px;  
        }  
        .ftitle{  
            font-size:14px;  
            font-weight:bold;  
            padding:5px 0;  
            margin-bottom:10px;  
            border-bottom:1px solid #ccc;  
        }  
        .fitem{  
            margin-bottom:5px;  
        }  
        .fitem label{  
            display:inline-block;  
            width:80px;  
        }  
    </style>  
  </body>
</html>
