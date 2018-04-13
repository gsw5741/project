<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <%@include file="/common/common-taglib.jsp"%>
  <title>登录</title>
  <cmt:includeJs scriptAttr="isCheck,bootstrapValidators"/>
</head>
<body class="hold-transition login-page">
<div class="login-box">
  <div class="login-logo">
    <a href="#"><b>欢迎</b>登录</a>
  </div>
  <div class="login-box-body">
    <p class="login-box-msg"></p>
    
    <form:form action="${_myNetwork}/login" method="post" id="myForm" htmlEscape="true" commandName="${commandName}">
      <form:errors id="msg" element="div" path="*" htmlEscape="false" cssStyle="color: red;"/>
     <!--  <span id="erroTip" style="color: red;"></span> -->
      <div class="form-group has-feedback">
        <form:input path="username" placeholder="用户名" cssClass="form-control" tabindex="1" accesskey="n"  htmlEscape="true"/>
       <!--  <input type="text" class="form-control" placeholder="用户名" tabindex="1" name="username" accesskey="n"> -->
        <span class="glyphicon glyphicon-user form-control-feedback"></span>
      </div>
      <div class="form-group has-feedback">
      <form:password path="password" placeholder="密码" cssClass="form-control" tabindex="2" accesskey="p"  htmlEscape="true"/>
        <!-- <input type="password" class="form-control" placeholder="密码" tabindex="2"  name="password" accesskey="p"> -->
        <span class="glyphicon glyphicon-lock form-control-feedback"></span>
        
      </div>
      <div class="row">
        <div class="col-xs-8">
          <div class="checkbox icheck">
            <label>
              <input type="checkbox" name="isRememberme" value="1"> <span>记住我</span>
            </label>
          </div>
        </div>
        <!-- /.col -->
        <div class="col-xs-4">
         <input type="hidden" name="lt" value="${loginTicket}" />
         <input type="hidden" name="execution" value="${flowExecutionKey}" />
         <input type="hidden" name="_eventId" value="submit" />
          <button type="button" onclick="login()" class="btn btn-primary btn-block btn-flat">登录</button>
        </div>
        <!-- /.col -->
      </div>
      
    </form:form>
   
    <a href="#">忘记密码</a>
    <a href="${_myNetwork}/register.htm" class="register">注册新账户</a>
    <span id="platForm"></span>
  </div>
  
</div>



<script>
  $(function () {
	  //$("#platForm").html(navigator.platform);
    $('input').iCheck({
      checkboxClass: 'icheckbox_square-blue',
      radioClass: 'iradio_square-blue',
      increaseArea: '15%' // optional
    });
   
     $('#myForm').bootstrapValidator({
      container: 'tooltip',
  	  fields: {
  		  username:{
  			validators:{
  				notEmpty: {message: "用户名 不能为空"}
  			}
  		  },
  		 
  		  password:{
  			validators:{
  				 notEmpty: {message: "密码 不能为空"}
  			}
  		  }
  	  }
    }); 
    
  });
  function login(){
	
	  var bootstrap =$("#myForm").data("bootstrapValidator");
	  bootstrap.validate();//表单验证
 	  if(bootstrap.isValid()){
 		 bootstrap.destroy();
 		 $("#erroTip").show();
    	 $("#erroTip").html('<img src="'+_myNetwork+'/static/img/loading.gif "/>正在登录');
    	 $("#myForm").submit();
 	 }
  }
</script>
</body>
</html>