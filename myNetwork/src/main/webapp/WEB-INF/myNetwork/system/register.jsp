<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
   <%@include file="/common/common-taglib.jsp"%>
  <title>注册</title>
  <cmt:includeJs scriptAttr="iCheck,bootstrapValidators"/>
</head>
<body class="hold-transition register-page">
<div class="register-box">
  <div class="register-logo"><a href="#"><strong>欢迎</strong>注册</a></div>

  <div class="register-box-body">
    <p class="login-box-msg">注册新账户</p>

    <form action="${_myNetwork}/registerMethod" method="post" id="myForm">
      <div class="form-group has-feedback">
        <input type="text" class="form-control" placeholder="用户名" name="loginName">
        <span class="glyphicon glyphicon-user form-control-feedback"></span>
      </div>
      <div class="form-group has-feedback">
        <input type="email" class="form-control" placeholder="常用邮箱" name="email">
        <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
      </div>
      <div class="form-group has-feedback">
        <input type="password" class="form-control" placeholder="密码" name="loginPwd">
        <span class="glyphicon glyphicon-lock form-control-feedback"></span>
      </div>
      <div class="form-group has-feedback">
        <input type="password" class="form-control" placeholder="确认密码" name="rePasswd">
        <span class="glyphicon glyphicon-log-in form-control-feedback"></span>
      </div>
      <div class="row">
        <div class="col-xs-8">
          <div class="checkbox icheck">
            <label>
              <input type="checkbox"> 注册成功后自动登录 
            </label>
          </div>
        </div>
     
        <div class="col-xs-4">
          <button type="submit"  class="btn btn-primary btn-block btn-flat">注册</button>
        </div>
       
      </div>
    </form>
    <a href="${_myNetwork}/login" class="text-center">我已有账号</a>
  </div>

</div>

<script>
  $(function () {
    $('input').iCheck({
      checkboxClass: 'icheckbox_square-blue',
      radioClass: 'iradio_square-blue',
      increaseArea: '18%' // optional
    });
    //表单验证
   $("form").bootstrapValidator({
         container: 'tooltip',
    	fields:{
    		loginName:{
    			validators: {
    				notEmpty:{message: "用户名不能为空"},
    				regexp: {
    					regexp:/^[a-zA-Z0-9_]+$/,
    					message:'用户名仅支持字母、数字、下划线'
    				},
    				stringLength:{
    					min:6,
    					max:10,
    					message:'请输入6-10个字符'
    				},
    				remote: {
    					type:'POST',
    					url:_myNetwork + '/checkLoginName',
    					message:"该用户名已注册",
    					delay:2000
    				}
    				
    			}
    		},
    		email:{
    			validators:{
    				notEmpty:{message:'邮箱不能为空'},
    				emailAddress:{message:'请输入有效的邮箱地址'},
    				remote: {
    					type:'POST',
    					url:_myNetwork + '/checkEmail',
    					message:"该用户名已注册",
    					delay:2000
    				}
    			}
    		},
    		loginPwd:{
    			validators:{
    				notEmpty:{message:"密码不能为空"},
    				regexp: {
    					regexp:/^[a-zA-Z0-9]+$/,
    					message:'密码由字母、数字组成'
    				},
    				stringLength:{
    					min:6,
    					max:10,
    					message:'请输入6-10位数的密码'
    				}
    			}
    		},
    		rePasswd:{
    			validators:{
    				notEmpty:{message:"确认密码不能为空"},
    				identical: {
    					field:'loginPwd',
    					message:'两次输入密码不一致'
    				}
    				
    			}
    		}
    	}
    }).on('success.form.bv',function(e){
    	e.preventDefault();//阻止同步提交表单
    	var $form=$(e.target);
    	var bootstrap=$form.data("bootstrapValidator");
    	if(bootstrap.isValid()){
    		$.post($form.attr("action"),$form.serializeArray(),function(data){
    			if(data.ok){
    				layer.msg('注册成功', {icon: 6,time: 2000},function(){
    					window.location.href = _myNetwork + '/login';
    				});
    			}else{
    				layer.alert(data.errorMsg);
    			}
    		},'json');
    	}
    	
    	
    });
    
  });
 
</script>
</body>
</html>
