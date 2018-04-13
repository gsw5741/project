<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="/common/common-taglib.jsp" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>主页</title>
<link rel="stylesheet" href="${_myNetwork}/jsPlugin/bootstrapTable/css/bootstrap-table.css">
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
        <li><a href="#">Tables</a></li>
        <li class="active">Data tables</li>
      </ol>
    </section>
      
    <!-- Main content -->
   <section class="content">
      <div class="row">
		<div class="col-xs-12">
			<div class="box-body" id="monitor">
				
			</div>
		</div>
		</div>
     </section>
      </div>
     
    <!--   公共底部 -->
  <jsp:include page="/common/system/common-footer.jsp"/>
 
  </div>
</body>
<script src="${_myNetwork}/jsPlugin/slimScroll/jquery.slimscroll.js"></script>
<script src="${_myNetwork}/jsPlugin/fastclick/fastclick.js"></script>
<script src="${_myNetwork}/static/js/adminlte.js"></script>
<script src="${_myNetwork}/jsPlugin/bootstrapTable/js/bootstrap-table.js"></script>
 <script type="text/javascript">
 $(function(){
	$("#monitor").load(_myNetwork + '/admin/druid/index.html');
 });

 </script>
</html>