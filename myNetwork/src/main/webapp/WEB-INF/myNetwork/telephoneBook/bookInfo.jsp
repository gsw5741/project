<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="/common/common-taglib.jsp" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>主页</title>
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
        <small>我的通讯录 </small>
      </h1>
      <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-home"></i> 主页</a></li>
        <li><a href="#">我的通讯录</a></li>
        <li class="active">详情页面</li>
      </ol>
    </section>
      
    <!-- Main content -->
   <section class="content">
     <div class="box box-info">
	  <form class="form-horizontal form-info" id="myForm" action="">
		<div class="box-body">
			<div class="form-group">
				<label class="col-sm-2 control-label">姓名</label>

				<div class="col-sm-8">${dataInfo.name }</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">电话号码</label>
				<div class="col-sm-8">	${dataInfo.telephone}</div>
			</div>
			
			<div class="form-group">
				<label class="col-sm-2 control-label">地址</label>

				<div class="col-sm-8">${dataInfo.address}</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">所属群组</label>
				<div class="col-sm-8">

                </div>
			</div>
			
			
			<div class="form-group">
			
			 <div class="col-sm-offset-2 col-sm-7 button-list">
                  <button type="button" class="btn btn-primary" title="返回" onclick="javascript:history.go(-1);"><i class="fa fa-reply"></i></button>
             </div>
             </div>
		</div>
		
	</form>
</div>
    </section>
      </div>
     
    <!--   公共底部 -->
  <jsp:include page="/common/system/common-footer.jsp"/>
 
  </div>
</body>
<script src="${_myNetwork}/static/js/adminlte.js"></script>
</html>