<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="cmt" uri="/common-includeJs" %>
<%@ page trimDirectiveWhitespaces="true" %>
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Cache-Control" content="no-cache">
<meta http-equiv="Expires" content="0">
<%
String path = request.getContextPath();
String requestUrl = request.getRequestURL().toString();
int index = requestUrl.indexOf(path);
String basePath = requestUrl.substring(0, index) + path;
%>
<c:set var="_myNetwork" value="<%=basePath%>"/>

<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
<link rel="stylesheet" href="${_myNetwork}/static/css/AdminLTE.css">
<link rel="stylesheet" type="text/css" href="${_myNetwork}/static/css/reset.css">
<cmt:includeJs scriptAttr="jquery,layer,bootstrap"/>

<script type="text/javascript">
var _myNetwork="${_myNetwork}";
layer.config({
    extend: ['skin/myskin/style.css'], //加载新皮肤
    skin: 'layer-ext-myskin' //一旦设定，所有弹层风格都采用此主题。
});
if(!localStorage.getItem("SESSION_OUT")){
	localStorage.setItem("SESSION_OUT", "10007");//登录超时
}
</script>
