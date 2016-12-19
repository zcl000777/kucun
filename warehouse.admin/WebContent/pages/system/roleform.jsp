<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

	<div id="roledlg" class="easyui-dialog" style="width:400px;height:280px;padding:10px 20px"  
            closed="true" buttons="#roledlg-buttons" modal="true">  
        <div class="ftitle">权限信息</div>  
        <ul id="tt" class="easyui-tree" data-options="url:'${pageContext.request.contextPath}/action/system/user/listroles',animate:true,checkbox:true"></ul>   
    </div>  
	<div id="roledlg-buttons">  
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveRole()">保存</a>  
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#roledlg').dialog('close')">取消</a>  
    </div>  
	
	<script type="text/javascript">
        function setRole(){  
            var row = $('#dg').datagrid('getSelected');  
            if (row){  
            	var _data = {};
            	_data.userId = row.id;
            	var _2b=$.ajax({url:'${pageContext.request.contextPath}/action/system/user/roles',dataType:"json",data:_data,async:false,cache:false,type:"get"}).responseText;
            	var roles = eval('('+_2b+')');
            	setChecked(roles);
                $('#roledlg').dialog('open').dialog('setTitle','设置权限信息');
            }  
        }  
        function saveRole(){  
        	var _data = {};
        	var row = $('#dg').datagrid('getSelected');  
        	if (row){
        		_data.userId = row.id;
        		_data.roles = getChecked();
	        	$.post('${pageContext.request.contextPath}/action/system/user/roles', _data, function(data) {
	  				var result = eval('('+data+')');  
                    if (result.status != 0){  
                        $.messager.show({  
                            title: '错误',  
                            msg: result.message
                        });  
                    } else {  
                        $('#roledlg').dialog('close');      // close the dialog  
                    } 
				});	
	        } 
        }  
        function setChecked(roles){  
        	var ret = new Array();
            var nodes = $('#tt').tree('getRoots');  
            for(var i=0; i<nodes.length; i++){
            	setNodeChecked(roles,nodes[i]);  
            }
        }  
        function setNodeChecked(roles,node){
        	if(in_array(node.id,roles))
        		$('#tt').tree('check',node.target);
        	else
        		$('#tt').tree('uncheck',node.target);
        	var children = $('#tt').tree('getChildren',node.target);
        	if(children){
	        	for(var i=0;i<children.length;i++){
	        		setNodeChecked(roles,children[i]);
	        	}
        	}
        }
        function in_array(searchString,array) {
          if(array == null || array.length==0) return false;
          for (i=0;i<array.length;i++) {
		    if ( searchString == array[i] ) return true;
		  }
		  return false;
		}
//         function getChecked(){  
//         	var ret = new Array();
//             var nodes = $('#tt').tree('getChecked');  
//             var n = 0;
//             for(var i=0; i<nodes.length; i++){
//             	if(nodes[i].id) ret[n++] = nodes[i].id;  
//             }  
//             return ret;
//         }  
        function getChecked(){  
        	var ret = new Array();
            var nodes = $('#tt').tree('getChecked');  
            var nodes1 = $('#tt').tree('getChecked','indeterminate');  
            
            var n = 0;
            for(var i=0; i<nodes.length; i++){
            	if(nodes[i].id) ret[n++] = nodes[i].id;  
            	
            }  
            for(var i=0; i<nodes1.length; i++){
            	if(nodes1[i].id) ret[n++] = nodes1[i].id;  
            }
            return ret;
        }  
        
	</script>
