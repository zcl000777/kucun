<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

	<div id="itemdlg" class="easyui-dialog" style="width:320px;height:340px;padding:10px 20px"  
            closed="true" buttons="#itemdlg-buttons" modal="true">  
        <div class="ftitle">字典项</div>  
        <form id="itemfm" class="fm" method="post">  
			<input name="id" type="hidden" value="0">  
			<input name="classCode" type="hidden">  
            <div class="fitem">  
                <label>代码:</label>  
                <input id="dmitemid" name="code" class="easyui-validatebox" required="true" readonly="readonly">  
            </div>  
            <div class="fitem">  
                <label>名称:</label>  
                <input name="name" class="easyui-validatebox" required="true">
            </div>  
            <div class="fitem">  
                <label>拼音索引:</label>  
                <input name="pinyin" class="easyui-validatebox" >
            </div>  
            <div class="fitem">  
                <label>参数1:</label>  
                <input name="param1" class="easyui-validatebox" >
            </div>  
            <div class="fitem">  
                <label>参数2:</label>  
                <input name="param2" class="easyui-validatebox">
            </div>  
            <div class="fitem">  
                <label>排序:</label>  
                <input name="ordernum" value='0' class="easyui-numberspinner" data-options="min:0,max:100,editable:true" />
            </div>  
        </form>  
    </div>  
	<div id="itemdlg-buttons">  
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveItem()">保存</a>  
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#itemdlg').dialog('close')">取消</a>  
    </div>  
	
	<script type="text/javascript">
        function newItem(){ 
        	if(classCode == null) return;
            $('#itemfm').form('reset');  
            $('#itemfm')[0].classCode.value = classCode;
            $('#itemfm')[0].id.value = "0";
         
            $('#itemdlg').dialog('open').dialog('setTitle','创建字典数据');
			$('#dmitemid').removeAttr('readonly');
            initform('itemfm',function(){
            	$('#itemdlg').dialog('close');      // close the dialog  
                $('#dg2').datagrid('reload');    // reload the user data  
            });  

            url = '${pageContext.request.contextPath}/action/system/dict/additem';
            $('#itemfm').attr("action",url);
        }  
        function editItem(){  
            $('#itemfm')[0].classCode.value = null;
            
            var row = $('#dg2').datagrid('getSelected'); 
			$('#dmitemid').attr('readonly','readonly');
            if (row){  
                $('#itemdlg').dialog('open').dialog('setTitle','修改字典数据');
	            initform('itemfm',function(){
	            	$('#itemdlg').dialog('close');      // close the dialog  
	                $('#dg2').datagrid('reload');    // reload the user data  
	            });  
                $('#itemfm').form('load',row);  
            }  
            url = '${pageContext.request.contextPath}/action/system/dict/edititem';
            $('#itemfm').attr("action",url);
        }  
        function saveItem(){  
            $('#itemfm').submit(); 
        }  
        function delItem(){  
            var row = $('#dg2').datagrid('getSelected');  
            if (row){  
                $.messager.confirm('确认','确定要删除这个字典数据么?',function(r){  
                    if (r){  
                    url = '${pageContext.request.contextPath}/action/system/dict/delitem';
                        $.post(url,{id:row.id},function(result){  
                            if (result.status == 0){  
                                $('#dg2').datagrid('reload');    // reload the user data  
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
