<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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

    <form action="${_myNetwork}/login" method="post" id="myForm">
     <span id="erroTip" style="display: none;color: red;"></span>
      <div class="form-group has-feedback">
        <input type="text" class="form-control" placeholder="用户名" name="loginName">
        <span class="glyphicon glyphicon-user form-control-feedback"></span>
      </div>
      <div class="form-group has-feedback">
        <input type="password" class="form-control" placeholder="密码" name="loginPwd">
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
          <button type="button" onclick="login()"  class="btn btn-primary btn-block btn-flat">登录</button>
        </div>
        <!-- /.col -->
      </div>
    </form>

    <a href="#">忘记密码</a>
    <a href="${_myNetwork}/register" class="register">注册新账户</a>
    <span id="platForm"></span>
  </div>
  
</div>



<script>
  $(function () {
	  //$("#platForm").html(navigator.platform);
    $('input').iCheck({
      checkboxClass: 'icheckbox_square-blue',
      radioClass: 'iradio_square-blue',
      increaseArea: '18%' // optional
    });
   
    $('#myForm').bootstrapValidator({
      container: 'tooltip',
  	  fields: {
  		  loginName:{
  			validators:{
  				notEmpty: {message: "用户名 不能为空"}
  			}
  		  },
  		 
  		  loginPwd:{
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
 		 $("#erroTip").show();
    	 $("#erroTip").html('<img src="'+_myNetwork+'/static/img/loading.gif "/>正在登录')
 		 $.post($("#myForm").attr("action"),$("#myForm").serializeArray(),function(data){
 			 if(data.ok){
 				 window.location.href = _myNetwork + "/index";
 			 }else{
 				 $("#erroTip").html("");
 				 $("#erroTip").html(data.errorMsg); 
 			 }
 			 
 		 },'json');
 	 }
  }
</script>
</body>
</html>