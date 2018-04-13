<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%> 
<c:set var="_myNetwork" value="<%=basePath%>"/>
<header class="main-header">

    <a href="javascript:void(0);" class="logo">
      <span class="logo-mini"><b>网站</b></span>
      <span class="logo-lg"><b>个人网站</b></span>
      
    </a>
    
    <nav class="navbar navbar-static-top">
     
      <a href="javascript:void(0);" class="sidebar-toggle" data-toggle="push-menu" role="button">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
         <span id="localDate"></span>
      </a>
     
      <div class="navbar-custom-menu">
        <ul class="nav navbar-nav">
          <li class="dropdown messages-menu">
            <a href="#" class="dropdown-toggle"  title="修改密码">
               <span class="pointer" data-toggle="modal" data-target="#myModal"><i class="fa fa-edit"></i></span>
              
            </a>
           <div class="modal fade in" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			    <div class="modal-dialog">
			        <div class="modal-content">
			            <div class="modal-header">
			                <h4 class="modal-title" id="myModalLabel">选择菜单</h4>
			            </div>
			            <div class="modal-body" id="choiceMenu"></div>
			            <div class="modal-footer">
			                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>

			            </div>
			        </div><!-- /.modal-content -->
			    </div><!-- /.modal -->
             </div>
          </li>
       
            <li class="dropdown user user-menu">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
              <img src="${_myNetwork}/static/img/user2-160x160.jpg" class="user-image" alt="User Image">
              <span class="hidden-xs">${currentUser.loginName}</span>
            </a>
            <ul class="dropdown-menu">
              <!-- User image -->
              <li class="user-header">
                <img src="${_myNetwork}/static/img/user2-160x160.jpg" class="img-circle" alt="User Image">

                <p>
                  ${currentUser.loginName} - Web Developer
                  <small><fmt:formatDate value="${currentUser.createTime}" pattern="yyyy/MM/dd"/> </small>
                </p>
              </li>
            
              <!-- Menu Footer-->
              <li class="user-footer">
                <div class="pull-left">
                  <a href="#" class="btn btn-default btn-flat">编辑个人信息</a>
                </div>
                <div class="pull-right">
                  <a href="${_myNetwork}/loginOut" class="btn btn-default btn-flat">注销</a>
                </div>
              </li>
            </ul>
          </li>
        </ul>
      </div>
      
    </nav>
  </header>
  <script>
 function showLocal(dateObj){
	  var daystr="";
	  var yy = dateObj.getYear();
		if (yy < 1900)
			yy = yy + 1900;
		var MM = dateObj.getMonth() + 1;
		if (MM < 10)
			MM = '0' + MM;
		var dd = dateObj.getDate();
		if (dd < 10)
			dd = '0' + dd;
		var hh = dateObj.getHours();
		if (hh < 10)
			hh = '0' + hh;
		var mm = dateObj.getMinutes();
		if (mm < 10)
			mm = '0' + mm;
		var ss = dateObj.getSeconds();
		if (ss < 10)
			ss = '0' + ss;
	  switch(dateObj.getDay()){
	  case 0:daystr="周日";break;
	  case 1:daystr="周一";break;
	  case 2:daystr="周二";break;
	  case 3:daystr="周三";break;
	  case 4:daystr="周四";break;
	  case 5:daystr="周五";break;
	  case 6:daystr="周六";break;
	  }
	  return daystr + " " + yy + "-" + MM + "-" + dd + " " + hh + ":" + mm + ":" + ss;
}
  
  function showTime(){
	  $("#localDate").html(showLocal(new Date()));
	  setTimeout("showTime()",1000);
  } 
  showTime();
  
  </script>