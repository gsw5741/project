<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="/common/common-taglib.jsp" %>
<title>主页</title>
    <cmt:includeJs scriptAttr="bootstrapTree,iCheck,bootstrap-iconpicker,bootstrapValidators,select2,common"/>


</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">
  <!-- 公共头部 -->
  <jsp:include page="/common/system/common-head.jsp"/>
 <!-- 菜单列表 -->
  <jsp:include page="/common/system/common-left.jsp"/>

  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>
        我的个人网站
        <small>角色管理
         <span class="pull-right-container">
        <a href="javascript:void(0)"onclick="addRole('');"><i class="fa fa-plus-circle"></i></a>
      <a href="javascript:void(0)"onclick="saveRoleMenu();"><i class="fa fa-save"></i></a> 
        
        </span>
        </small>
      </h1>
      <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-home"></i> 主页</a></li>
        <li><a href="#">系统设置</a></li>
        <li class="active">角色管理</li>
      </ol>
    </section>
      
    <!-- Main content -->
   <section class="content">
      <div class="row">
     
          <div class="col-xs-4">
            <ul class="list-group">
              <c:forEach items="${roleList}" var="item">
                 <li class="list-group-item" onclick="choiceMenu('${item.roleId}')">
                 ${item.roleName}
                   
                <a href="javascript:void(0);" title="删除" onclick="delRole('${item.roleId}')"><i class="fa fa-trash-o"></i></a>
                 <a href="javascript:void(0);" title="修改" onclick="addRole('${item.roleId}')" ><i class="fa fa-edit"></i></a> 
                 
                 </li>
              </c:forEach>
            </ul>
          </div>
          <div class="col-sm-4">
          <div id="roleInfo"></div>
          </div>
          <div class="col-sm-4">
          <div id="menuTree"></div>
        </div>
        
          <input  id="roleId" type="hidden">
      </div>
     </section>
      </div>
     
    <!--   公共底部 -->
  <jsp:include page="/common/system/common-footer.jsp"/>
 
  </div>
</body>
<script src="${_myNetwork}/static/js/adminlte.js"></script>


 <script type="text/javascript">
 var $checkableTree;
 $(function(){
	 choiceMenu('1');//默认显示管理员角色菜单
 });
 function choiceMenu(roleId){
	 $("#roleId").val(roleId);
	 $.post(_myNetwork + '/sysRole/roleMenuData',{roleId:roleId},function(data){
		 if(data.ok){
			 var menuData = data.obj;
			 $('#menuTree').show();
			 $checkableTree = $('#menuTree').treeview({
			      data: menuData,
			      showCheckbox: true,
			      onNodeChecked: nodeChecked,
			      onNodeUnchecked:nodeUnChecked
			});
		 }
	 },'json');
	 
	 $("#roleInfo").load(_myNetwork + '/sysRole/roleInfo',{roleId:roleId});
 }
 function nodeUnChecked(event,data){
	 var nodes = data.nodes;//获取子节点
	 var checked = data.state.checked;
	  //如果 存在子节点，该节点取消选中后，子节点全部不选中
	  if(nodes!=null){
		  $(nodes).each(function(index,value){
			  $('#menuTree').treeview('uncheckNode',value.nodeId,{silent: true}); 
		  });
	  }
 }
 function nodeChecked(event,data){
	 var nodes = data.nodes;//获取子节点
	 var checked = data.state.checked;
	  //如果 存在子节点，该节点选中后，子节点全部选中
	  if(nodes!=null){
		  if(checked){
			  $(nodes).each(function(index,value){
				  $('#menuTree').treeview('checkNode',value.nodeId,{silent: true}); 
			  });
		  }
		  
	  }else{
		 //不存在子节点，判断该节点同级节点，选中状态
		  var siblings = $('#menuTree').treeview('getSiblings',data.nodeId);
		  var parentNode = $('#menuTree').treeview('getParent',data.nodeId);//该节点的父节点
		  var isAllChecked = true;//子节点是否全选中
		  for(var i in siblings){
			  var isCheck = siblings[i].state.checked;
			  //同级节点存在未选中的，对应的父节点取消选中
			  if(!isCheck){
				  $('#menuTree').treeview('uncheckNode',parentNode.nodeId);
				  isAllChecked = false;
				  break;
			  }
		  }
		  //子节点全部选中，父节点也选中
		  if(isAllChecked){
			  $('#menuTree').treeview('checkNode',parentNode.nodeId);
		  }
	  }
 }

 function saveRoleMenu(){
	 var roleId = $("#roleId").val();
	 var menuIds = [];
	 if($checkableTree){
		var nodes = $checkableTree.treeview("getChecked");
		$(nodes).each(function(){
		    menuIds.push(this.id);
		});
		if(menuIds.length>0){
			$.ajax({
				url:_myNetwork + '/sysRole/addRoleMenu',
				type:'post',
				data:{menuIds:menuIds,roleId:roleId},
				dataType:'json',
				traditional:true,
				success:function(data){
					if(data.ok){
						layer.alert("执行成功");
						window.location.reload();
					}else{
						layer.alert(data.errorMsg);
					}
				},
				error:function(data){
					layer.alert("发生错误");
				}
			});
		}else{
			layer.alert("请选择菜单");
		}
	 }
 }
 function addRole(roleId){
	 $("#roleInfo").load(_myNetwork + '/sysRole/roleAdd',{roleId:roleId},function(data){
		 if(data.errorCode==localStorage.getItem("SESSION_OUT")){
			  layer.alert(data.errorMsg);
			  window.top.location.href = _myNetwork + "/loginOut";
			  return;
		  }
		  initForm();
	 });
	 $("#menuTree").hide();
 }
 function initForm(){
	  //表单验证
	   var roleId = $("input[name='roleId']").val();
	   $("#myForm").bootstrapValidator({
	         container: 'tooltip',
	    	 fields:{
	    		roleName:{
	    			validators: {
	    				notEmpty:{message: "菜单名称不能为空"},
	    				stringLength:{
	    					max: 10,
	    					message:'角色名称长度不要超过10'
	    				},
	    				remote: {
	    					type:'POST',
	    					url:_myNetwork + '/sysRole/checkRoleName',
	    					data:{roleId:roleId},
	    					message:"该角色名已存在",
	    					delay:2000
	    				}
	    				
	    			}
	    		},
	    		description:{
	    			validators:{
	    				stringLength:{
	    					max: 100,
	    					message:'描述不要超过100个字符'
	    				}
	    			}
	    		}
	    	
	    	}
	    });
 }
 function save(){
	 var bootstrap =$("#myForm").data("bootstrapValidator");
	  bootstrap.validate();//表单验证
	  if(bootstrap.isValid()){
		 $.post($("#myForm").attr("action"),$("#myForm").serializeArray(),function(data){
			 if(data.ok){
				    layer.alert('执行成功');
 					window.location.reload();
 				
			 }else{
				 alert(data.errorMsg);
			 }
			 
		 },'json');
	 }
}
function delRole(roleId){
	layer.confirm('确定删除吗？',{btn:['确定','取消']},
		function(index,layero){
		   $.post(_myNetwork + '/sysRole/delRole',{roleId:roleId},function(data){
			   if(data.ok){
				   layer.msg('删除成功',{icon:6,time:1000},function(){
					   window.location.reload();
				   });
				  
			   }else{
				   layer.alert(data.errorMsg);
			   }
			   
		   },'json')
	    },
	    function(index,layero){
	    	layer.close(index);
	    }
     );
}

 </script>
</html>