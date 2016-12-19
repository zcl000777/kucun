<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

	<div id="passwd" class="easyui-dialog" style="width:400px;height:260px;padding:10px 20px"  
            closed="true" buttons="#passwd-buttons" modal="true">  
        <div class="ftitle">请输入密码</div>  
        <form id="passfm" class="fm" method="post">  
            <div class="fitem">  
                <label>原密码:</label>  
                <input name="oldpass" type="password" class="easyui-validatebox" required="true">  
            </div>  
            <div class="fitem">  
                <label>新密码:</label>  
                <input id="pwd" name="newpass" type="password" class="easyui-validatebox" required="true">  
            </div>  
            <div class="fitem">  
                <label>确认:</label>  
                <input name="confirm" type="password" class="easyui-validatebox" required="true" validType="equals['#pwd']">  
            </div>  
        </form>  
    </div>  
	<div id="passwd-buttons">  
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" onclick="changePass()">修改</a>  
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#passwd').dialog('close')">取消</a>  
    </div>  
	
	<script type="text/javascript">
        function passwd(){  
            $('#passwd').dialog('open').dialog('setTitle','修改密码');
            initform('passfm',function(){
                $('#passwd').dialog('close');      // close the dialog
                $.messager.alert("信息","修改密码成功！","info");
            });  
 
            $('#passfm').form('clear');  
            url = getPath('/action/passwd');
            $('#passfm').attr("action",url);
        }  
        function changePass(){  
            $('#passfm').submit(); 
        }  
        function logout(){  
            $.messager.confirm('确认','确定要退出系统么?',function(r){  
                if (r){  
                url = getPath('/action/logout');
                    $.post(url,null,function(result){  
                        if (result.status == 0){  
                        	window.location.replace("login.jsp");
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
        
	</script>
