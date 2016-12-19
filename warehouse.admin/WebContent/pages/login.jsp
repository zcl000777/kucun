<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>login page</title>
	<c:import url="/pages/common/head.jsp"/>
  </head>
  
  <body>
	<div style="margin:10px 0;"></div>
	<div class="easyui-window" title="登录系统" style="width:400px"
		 data-options="iconCls:'icon-tip',collapsible:false,minimizable:false,maximizable:false,closable:false,resizable:false">
		<div style="padding:10px 0 10px 60px">
		<form id="fm">
	    	<table>
	    		<tr>
	    			<td>登录名:</td>
	    			<td><input class="easyui-validatebox" type="text" name="username" data-options="required:true"></input></td>
	    		</tr>
	    		<tr>
	    			<td>密码:</td>
	    			<td><input class="easyui-validatebox" type="password" name="password" data-options="required:true"></input></td>
	    		</tr>
	    		<%-- <tr>
	    			<td>验证码:</td>
	    			<td algin="right"><input name="randomcode" type="text" width="50%"><img id="rcode" title="点击更换" onclick="javascript:refresh();" src="${pageContext.request.contextPath}/action/verifyImage" align="right"></td>
	    		</tr> --%>
<!-- 				<div> -->
<%-- 				  	<img id="rcode" title="点击更换" onclick="javascript:refresh();" src="${root}/action/randomcode" align="right"> --%>
<!-- 				</div> -->
	    	</table>
		</form>
	    </div>
	    <div style="text-align:center;padding:5px">
	    	<a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()">提交</a>
	    	<a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()">重置</a>
	    </div>
	</div>
	<script>
	document.onkeydown=keyListener;    
	function keyListener(e){    
	    e = e ? e : event;   
	    if(e.keyCode == 13){    
	    	submitForm();    
	    }    
	} 
		function submitForm(){
			if(!$("#fm").form("validate"))
				return ;
			
			var url = "${pageContext.request.contextPath}/action/ajax_login";
			var data = $.formData($('#fm'));
			
			$.messager.progress({text:'正在登录...'});
			
            $.ajax({url:url,
        		data:data,
        	    type : 'POST',
        	    success: function(result){
                	$.messager.progress('close');
                    if (result.status == 0){  
                    	window.location.replace("frame.jsp");
                    } else {  
                    	var msg = result.message;
                    	if(!msg)
                    		msg = '处理错误！'; 
                        $.messager.show({   // show error message  
                            title: '错误',  
                            msg: result.message  
                        });  
                    }  
        		},
        		dataType: 'json',
				});  
		}
	    function refresh() {
	    	$("#rcode").attr("src","${pageContext.request.contextPath}/action/verifyImage?rd="+Math.random());
	    }
		function clearForm(){
			$('#fm').form('clear');
		}
	</script>
  </body>
</html>
