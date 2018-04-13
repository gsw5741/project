<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="/common/common-taglib.jsp" %>
<title>主页</title>
    <cmt:includeJs scriptAttr="bootstrapValidators,bootstrapTable,select2,common"/>

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
        <small>数据字典
         <span class="pull-right-container">
            <a href="javascript:void(0)"onclick="addDictType('');"><i class="fa fa-plus-circle"></i></a>
        </span>
        </small>
      </h1>
      <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-home"></i> 主页</a></li>
        <li><a href="#">系统设置</a></li>
        <li class="active">数据字典</li>
      </ol>
    </section>
      
    <!-- Main content -->
   <section class="content">
      <div class="row">
         <div class="col-xs-4">
         <div class="box-body">
            <ul class="list-group">
              <c:if test="${dictListType=='[]'}">
                   <li class="list-group-item">暂无数据</li>
            
            </c:if>
            <c:if test="${dictListType!='[]'}">
              <c:forEach items="${dictListType}" var="item">
                 <li class="list-group-item" onclick="choiceDict('${item.code}','${item.typeId}')">
                  ${item.name}
                 
                 <a href="javascript:void(0);" title="删除" onclick="delDictType('${item.typeId}')"><i class="fa fa-trash-o"></i></a>
                 <a href="javascript:void(0);" title="修改" onclick="addDictType('${item.typeId}')" ><i class="fa fa-edit"></i></a> 
                 
                 </li>
                  
              </c:forEach>
              </c:if>
            </ul>
            </div>
          </div>
          
          <div class="col-sm-8" id="dictInfo">
         <!--  <div id="dictInfo"></div> -->
          </div>
          <input  id="dictCode" type="hidden">
      </div>
     </section>
      </div>
     
    <!--   公共底部 -->
  <jsp:include page="/common/system/common-footer.jsp"/>
 
  </div>
</body>
<script src="${_myNetwork}/static/js/adminlte.js"></script>

 <script type="text/javascript">
 $(function(){
	 choiceDict();//默认显示全部字典
	 
 });
 function choiceDict(code,typeId){
	 $("#dictInfo").html("");
	 $("#dictInfo").load(_myNetwork + '/sysDict/dictList',{code:code,dictTypeId:typeId},function(data){
		 if(data.errorCode==localStorage.getItem("SESSION_OUT")){
			  layer.alert(data.errorMsg);
			  window.top.location.href = _myNetwork + "/loginOut";
			  return;
		  }
		 $('#searchTable').bootstrapTable({
			    url:_myNetwork + '/sysDict/dictData',
			    method:'post',
			    columns:[
                  {field:"index",title:"序号",formatter:index},
			      {field:"code",title:"字典代码",},
			      {field:"codeLabel",title:"字典标签"},
			      {field:"codeValue",title:"字典值"},
			      {field:"operate",title:"操作",formatter:operate}
			     ],
			    showColumns: true,
			    sidePagination:'server',
			    addData:addDict,
			    queryParams:function(params){
			    	params.code = $("#code").val();
			    	params.dictTypeId = $("#dictTypeId").val();
			    	return params;
			    }
		});
	 });
 }
function index(value,row,index){
	return index + 1;
}
function operate(value,row,index){
	var attr = [];
	attr[attr.length] = '<a href="javascript:void(0);" onclick="addDict(\'' + row.dictId + '\')"><i class="fa fa-edit" title="修改"></i></a>';
    if(row.delFlag == '2'){
    	attr[attr.length] = '<a href="javascript:void(0);" onclick="updateDict(\'' + row.dictId + '\',\'Y\')"> <i class="fa fa-folder-open-o" title="启用"></i></a>';
    }
    if(row.delFlag == '1'){
    	attr[attr.length] = '<a href="javascript:void(0);" onclick="updateDict(\'' + row.dictId + '\',\'N\')"> <i class="fa fa-folder-o" title="禁用"></i></a>';
    }
	
    return attr.join("&nbsp;&nbsp;")
}
function updateDict(dictId,flag){ 
	var msg;
	if(flag == 'Y'){
		msg = '确定启用吗';
	}else{
		msg = '确定禁用吗？';
	}
	layer.confirm(msg,{btn:['确定','取消']},
			function(index,layero){
			   $.post(_myNetwork + '/sysDict/addDictMethod',{dictId:dictId,flag:flag},function(data){
				   if(data.ok){
					   layer.msg('执行成功',{icon:6,time:1000},function(){
						  
						   $('#searchTable').bootstrapTable("refresh");
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
function addDict(dictId){
	var dictTypeId = $("#dictTypeId").val();
	var code = $("#code").val();
	if(dictId == '' || dictId == null){
		if(dictTypeId == ''){
			   layer.alert("请选择左侧字典类型");
			   return;
			}
	}
	
	$("#dictInfo").html("");
	$("#dictInfo").load(_myNetwork + '/sysDict/addDict',{dictId:dictId,typeId:dictTypeId,code:code},function(data){
		 if(data.errorCode==localStorage.getItem("SESSION_OUT")){
			  layer.alert(data.errorMsg);
			  window.top.location.href = _myNetwork + "/loginOut";
			  return;
		  }
		 initDictForm();
	 });
}
function saveDict(){
	 var bootstrap =$("#myDictForm").data("bootstrapValidator");
	  bootstrap.validate();//表单验证
	  if(bootstrap.isValid()){
		 $.post($("#myDictForm").attr("action"),$("#myDictForm").serializeArray(),function(data){
			 if(data.ok){
			    layer.alert('执行成功');
				window.location.reload();
			 }else{
				 layer.alert(data.errorMsg);
			 }
			 
		 },'json');
	 }
}
function initDictForm(){
	  //表单验证
	   $("#myDictForm").bootstrapValidator({
	         container: 'tooltip',
	    	 fields:{
	    		codeLabel:{
	    			validators: {
	    				notEmpty:{message: "字典标签不能为空"}
	    			}
	    		},
	    		codeValue:{
	    			validators:{
	    				notEmpty: {message: "字典代码不能为空"}
	    				
	    			}
	    		}
	    	}
	    });
}
 function addDictType(typeId){
	 $("#dictInfo").html("");
	 $("#dictInfo").load(_myNetwork + '/sysDict/addDictType',{typeId:typeId},function(data){
		 if(data.errorCode==localStorage.getItem("SESSION_OUT")){
			  layer.alert(data.errorMsg);
			  window.top.location.href = _myNetwork + "/loginOut";
			  return;
		  }
		 initDictTypeForm();
	 });

 }
 function initDictTypeForm(){
	  //表单验证
	   var typeId = $("input[name='typeId']").val();
	   $("#myDictTypeForm").bootstrapValidator({
	         container: 'tooltip',
	    	 fields:{
	    		name:{
	    			validators: {
	    				notEmpty:{message: "字典名称不能为空"},
	    				stringLength:{
	    					max: 10,
	    					message:'字典名称长度不要超过10'
	    				}
	    			}
	    		},
	    		code:{
	    			validators:{
	    				notEmpty: {message: "字典代码不能为空"},
	    				stringLength:{
	    					max: 10,
	    					message:'字典名称长度不要超过10'
	    				},
	    				remote: {
	    					type:'POST',
	    					url:_myNetwork + '/sysDict/checkDictCode',
	    					data:{typeId:typeId},
	    					message:"该字典代码已存在",
	    					delay:2000
	    				}
	    			}
	    		},
	    		description:{
	    			validators:{
	    				stringLength:{
	    					max: 50,
	    					message:'描述不要超过50个字符'
	    				}
	    			}
	    		}
	    	
	    	}
	    });
 }
 function saveDictType(){
	 var bootstrap =$("#myDictTypeForm").data("bootstrapValidator");
	  bootstrap.validate();//表单验证
	  if(bootstrap.isValid()){
		 $.post($("#myDictTypeForm").attr("action"),$("#myDictTypeForm").serializeArray(),function(data){
			 if(data.ok){
			    layer.alert('执行成功');
				window.location.reload();
			 }else{
				 layer.alert(data.errorMsg);
			 }
			 
		 },'json');
	 }
}
function delDictType(typeId){
	layer.confirm('确定删除吗？',{btn:['确定','取消']},
		function(index,layero){
		   $.post(_myNetwork + '/sysDict/delDict',{typeId:typeId},function(data){
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