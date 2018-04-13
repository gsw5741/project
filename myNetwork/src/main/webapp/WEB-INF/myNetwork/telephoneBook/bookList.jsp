<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="/common/common-taglib.jsp" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>主页</title>
<cmt:includeJs scriptAttr="bootstrapTable,common"/>
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
        <small>我的通讯录</small>
      </h1>
      <ol class="breadcrumb">
        <li><a href="${_myNetwork}/index.htm"><i class="fa fa-home"></i> 主页</a></li>
        <li><a href="#">我的通讯录</a></li>
        <li class="active">通讯录列表</li>
      </ol>
    </section>

    <!-- Main content -->
   <section class="content">
      <div class="row">
		<div class="col-xs-12">
			<div class="box-body">
				<table id="searchTable" data-toggle="table">

				</table>
			</div>
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
 $(function(){
	 $('#searchTable').bootstrapTable({
		    url:_myNetwork + '/telePhoneBook/bookListData.htm',
		    method:'post',
		    columns:[
		      {field:"index",title:"序号",formatter:index},
		      {field:"telephone",title:"电话号码",formatter:telephone},
		      {field:"name",title:"姓名"},
		      {field:"address",title:"地址"},
		      {field:"operate",title:"操作",formatter:operate}
		     ],
		    showColumns: true,
		    sidePagination:'server',
		    addData:addBook
	});
 });
 function index(value,row,index){
	 return index+1;
 }
 function telephone(value,row,index){
	return '<a href="javascript:void(0);" onclick="bookInfo(\'' + row.id + '\')">' + value + '</a>';
 }
function operate(value,row,index){
	var attr = [];
	attr[attr.length] = '<a href="javascript:void(0);" onclick="update(\'' + row.id + '\')"><i class="fa fa-edit" title="修改"></i></a>';
    attr[attr.length] = '<a href="javascript:void(0);" onclick="del(\'' + row.id + '\')"> <i class="fa fa-trash-o" title="删除"></i></a>';
    return attr.join("&nbsp;&nbsp;")
}
function addBook(){
	window.location.href = _myNetwork + '/telePhoneBook/addOrUpdateBook.htm';
}
function update(id){
	window.location.href = _myNetwork + '/telePhoneBook/addOrUpdateBook.htm?bookId=' + id;
}
function del(id){
	layer.confirm('确定删除吗？',{btn:['确定','取消']},
		function(index,layero){
		   $.post(_myNetwork + '/telePhoneBook/delBook.htm',{bookId:id},function(data){
			   if(data.ok){
				   layer.msg('删除成功',{icon:6,time:1000},function(){
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
function bookInfo(id){
	window.location.href = _myNetwork + '/telePhoneBook/bookInfo.htm?bookId=' + id;
}
 </script>
</html>