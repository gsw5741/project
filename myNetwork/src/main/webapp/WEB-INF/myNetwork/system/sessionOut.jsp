<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="/common/common-taglib.jsp" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
$(function(){
	layer.open({
	  title: '登录超时',
	  content: "登录超时，请重新登录",
	  yes:function(index, layero){
		  window.top.location.href=_myNetwork+'/loginOut';
		  layer.close(index);
	  }
	});     
})

</script>
</head>
<body>

</body>
</html>