<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="/common/common-taglib.jsp" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>主页</title>
<cmt:includeJs scriptAttr="bootstrapValidators,bootstrap-iconpicker,select2,common"/>
</head>
<body>
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
        <small>我的通讯录 <a href="javascript:void(0)"onclick="addBook();"><i class="fa fa-plus-circle"></i></a></small>
      </h1>
      <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-home"></i> 主页</a></li>
        <li><a href="#">我的通讯录</a></li>
        <li class="active">增加页面</li>
      </ol>
    </section>
      
    <!-- Main content -->
   <section class="content">
     <div class="box box-info">
	  <form class="form-horizontal form-info" id="myForm" action="${_myNetwork}/telePhoneBook/addBookMethod.htm">
		<div class="box-body">
			<div class="form-group">
				<label class="col-sm-2 control-label">姓名</label>

				<div class="col-sm-8">
					<input type="text" class="form-control" name="name" value="${dataInfo.name }"  placeholder="姓名">
					
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">电话号码</label>
				<div class="col-sm-8">	
					<input type="text" class="form-control " name="telephone" value="${dataInfo.telephone}"  placeholder="电话号码" >
				</div>
			</div>
			
			<div class="form-group">
				<label class="col-sm-2 control-label">地址</label>

				<div class="col-sm-8">
					<input type="text" class="form-control" name="address" value="${dataInfo.address}" placeholder="地址">
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">所属群组</label>
				<div class="col-sm-8">
				  <select class="form-control text" name="groupId">
                    <option value=""></option>
                    <option value="1">option 2</option>
                    <option value="2">option 3</option>
                    
                  </select>
                </div>
			</div>
			
			
			<div class="form-group">
			
			 <div class="col-sm-offset-2 col-sm-7 button-list">
                  <button type="button" class="btn btn-primary" title="保存" onclick="save();"><i class="fa fa-save"></i></button>
                  <button type="reset" class="btn btn-default" title="重置"><i class="fa fa-refresh"></i></button>
                  <button type="button" class="btn btn-primary" title="返回" onclick="javascript:history.go(-1);"><i class="fa fa-reply"></i></button>
             </div>
             </div>
		</div>
		<input name="id" type="hidden" value="${dataInfo.id}">
	</form>
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
	 $("#myForm").bootstrapValidator({
         container: 'tooltip',
    	 fields:{
    		telephone:{
    			validators: {
    				notEmpty:{message: "电话号码不能为空"},
    				phone:{
    				   country:"CN",
    				   message:"请输入正确的电话号码"
    				}
    			}
    		}
    	}
    });
});
function save(){
	var bootstrap=$("#myForm").data("bootstrapValidator");
	if(bootstrap.isValid()){
		$.post($("#myForm").attr("action"),$("#myForm").serializeArray(),function(data){
			if(data.ok){
				layer.msg('执行成功', {icon: 6,time: 2000},function(){
					window.location.href = _myNetwork + '/telePhoneBook/bookList.htm';
				});
			}else{
				layer.alert(data.errorMsg);
			}
		},'json');
	}
}
 </script>
</html>