<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

	<div id="dlg" class="easyui-dialog" style="width:400px;height:340px;padding:10px 20px"  
            closed="true" buttons="#dlg-buttons" modal="true">  
        <div class="ftitle">日志信息</div>  
        <form id="fm2" class="fm" method="post">  
            <div class="fitem">  
                <label>日志ID:</label>  
                <input name="id" >  
            </div>  
            <div class="fitem">  
                <label>处理结果:</label>  
                <input name="resultDesc" type="text">  
            </div>  
            <div class="fitem">  
                <label>结果详情:</label>  
                <textarea id="resultDetail" rows="10"></textarea>  
            </div>  
			
        </form>  
    </div>  
	<div id="dlg-buttons">  
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')">关闭</a>  
    </div>  
	
	<script type="text/javascript">
        function showDetails(){  
            var row = $('#dg').datagrid('getSelected');  
            if (row){  
            	$.blockUI($(".easyui-dialog"));
            	$.get("${pageContext.request.contextPath}/action/system/logs/details?id="+row.id,function(data,status){
            	    //alert("Data: " + data + "\nStatus: " + status);
                	$.unblockUI($(".easyui-dialog"));
                    var result = eval('('+data+')');  
                    if (result.status != 0){  
                        $.messager.show({  
                            title: '错误',  
                            msg: result.message
                        });  
                    } else {  
                    	//alert(result.result);
                	    $("#resultDetail").val(result.result);
                    }  
            	  });
            	
                //initform('fm',function(){});  
                $('#fm2').form('load',row);
                
                $('#dlg').dialog('open').dialog('setTitle','日志详情');
            }  
        }  
        
	</script>
