<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

	<div id="classdlg" class="easyui-dialog" style="width:320px;height:240px;padding:10px 20px"  
            closed="true" buttons="#classdlg-buttons" modal="true">  
        <div class="ftitle">字典分类信息</div>  
        <form id="classfm" class="fm" method="post">  
			<input name="id" type="hidden" value="0" />  
            <div class="fitem">  
                <label>编码:</label>  
                <input id="dmclasscode" name="code" class="easyui-validatebox" readonly="readonly" required="true">  
            </div>  
            <div class="fitem">  
                <label>名称:</label>  
                <input name="name" class="easyui-validatebox" required="true">
            </div>  
        </form>  
    </div>  
	<div id="classdlg-buttons">  
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveClass()">保存</a>  
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#classdlg').dialog('close')">取消</a>  
    </div>  
	
	<script type="text/javascript">
        var url;
        
        function newClass(){  
            $('#classdlg').dialog('open').dialog('setTitle','创建字典分类');
			$('#dmclasscode').removeAttr('readonly');
            initform('classfm',function(){
            	$('#classdlg').dialog('close');      // close the dialog  
                $('#dg1').datagrid('reload');    // reload the user data  
            });  
            $('#classfm').form('clear');  
            
            $('#classfm')[0].id.value = "0";

            url = '${pageContext.request.contextPath}/action/system/dict/addclass';
            $('#classfm').attr("action",url);
        }  
        function editClass(){  
            var row = $('#dg1').datagrid('getSelected'); 
			$('#dmclasscode').attr('readonly','readonly');
            if (row){  
                $('#classdlg').dialog('open').dialog('setTitle','修改字典分类');
	            initform('classfm',function(){
	            	$('#classdlg').dialog('close');      // close the dialog  
	                $('#dg1').datagrid('reload');    // reload the user data  
	            });  
                $('#classfm').form('load',row);  
            }  
            url = '${pageContext.request.contextPath}/action/system/dict/editclass';
            $('#classfm').attr("action",url);
        }  
        function saveClass(){  
            $('#classfm').submit(); 
        }  
        function delClass(){  
            var row = $('#dg1').datagrid('getSelected');  
            if (row){  
                $.messager.confirm('确认','确定要删除这个字典数据么?',function(r){  
                    if (r){  
                    url = '${pageContext.request.contextPath}/action/system/dict/delclass';
                        $.post(url,{id:row.id},function(result){  
                            if (result.status == 0){  
                                $('#dg1').datagrid('reload');    // reload the user data  
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
