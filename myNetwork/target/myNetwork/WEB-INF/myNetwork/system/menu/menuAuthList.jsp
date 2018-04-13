<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="/common/common-taglib.jsp" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>主页</title>
<cmt:includeJs scriptAttr="bootstrapValidators,bootstrap-iconpicker,select2,common,isCheck,bootstrapTree"/>

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
        <small>权限资源
         <span class="pull-right-container">
        <a href="javascript:void(0)"onclick="addMenu();"><i class="fa fa-plus-circle"></i></a>
        </span>
        </small>
      </h1>
      <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-home"></i> 主页</a></li>
        <li><a href="#">系统设置</a></li>
        <li class="active">权限资源</li>
      </ol>
    </section>
      
    <!-- Main content -->
   <section class="content">
      <div class="row">
     
          <div class="col-xs-4">
          
           <div id="loadTree" class=""></div>
          </div>
          <div class="col-sm-8">
          <div id="menuInfo"></div>
        </div>
          
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
	  var menuData = {};
	  if('${menuData}'!=''){
		  menuData = ${menuData};
	  }
	 $checkableTree = $('#loadTree').treeview({
	      data: menuData,
	      onNodeSelected: nodeSelected,
	      nodeIcon: 'fa  fa-folder-o'
	    });
  });
  function nodeSelected(event,data){
	  if(data.href){
		  $("#menuInfo").load(_myNetwork + "/sysMenu/menuAdd/menuId/" + data.id,{},function(data){
			  if(data.errorCode==localStorage.getItem("SESSION_OUT")){
				  layer.alert(data.errorMsg);
				  window.top.location.href = _myNetwork + "/loginOut.htm";
				  return;
			  }
			  initForm();
			  $('input[type="checkbox"].minimal, input[type="radio"].minimal').iCheck({
    		      checkboxClass: 'icheckbox_minimal-blue',
    		      radioClass: 'iradio_minimal-blue'
    		    });
			  $("#menuCss").iconPicker();
			  choiceTree();
		  }); 
		 
	  }
  }
  function choiceTree(){
	  $.post(_myNetwork + '/sysMenu/choiceMenu.htm',{},function(data){
		  if(data.errorCode==localStorage.getItem("SESSION_OUT")){
			  layer.alert(data.errorMsg);
			  window.top.location.href = _myNetwork + "/loginOut.htm";
			  return;
		  }
		  $("#choiceMenu").treeview({
			  data:data.obj,
			  onNodeSelected:function(event,data){
				  $("#pMenuName").val(data.text);
				  $("#pMenuId").val(data.id);
			  }
		  });
		
	  },'json')
  }
  function initForm(){
	  //表单验证
	   var menuId = $("input[name='menuId']").val();
	   $("#myForm").bootstrapValidator({
	         container: 'tooltip',
	    	 fields:{
	    		menuName:{
	    			validators: {
	    				notEmpty:{message: "菜单名称不能为空"},
	    				stringLength:{
	    					max: 10,
	    					message:'菜单名称长度不要超过10'
	    				},
	    				remote: {
	    					type:'POST',
	    					url:_myNetwork + '/sysMenu/checkMenuName.htm',
	    					data:{menuId:menuId},
	    					message:"该菜单名已存在",
	    					delay:2000
	    				}
	    				
	    			}
	    		}
	    	
	    	}
	    });
  }

function addMenu(){
	$("#menuInfo").load(_myNetwork + "/sysMenu/menuAdd.htm",{},function(){
		  $('input[type="checkbox"].minimal, input[type="radio"].minimal').iCheck({
		      checkboxClass: 'icheckbox_minimal-blue',
		      radioClass: 'iradio_minimal-blue'
		    });
		  $("#menuCss").iconPicker();
		  initForm();
		  choiceTree();
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
				 layer.alert(data.errorMsg);
			 }
			 
		 },'json');
	 }
}
 </script>
</html>