<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="/myNetwork//jsPlugin/bootstrap/css/bootstrap.css">
<link rel="stylesheet" href="/myNetwork//jsPlugin/layer/skin/layer.css">
<script src="/myNetwork//jsPlugin/jquery/jquery-3.1.1.min.js"></script>
<script src="/myNetwork//jsPlugin/bootstrap/js/bootstrap.js"></script>
<script src="/myNetwork//jsPlugin/layer/layer.js"></script>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
<link rel="stylesheet" href="http://localhost:8080/myNetwork/static/css/AdminLTE.css">
<link rel="stylesheet" type="text/css" href="http://localhost:8080/myNetwork/static/css/reset.css">

<script type="text/javascript">
var _myNetwork="http://localhost:8080/myNetwork";
layer.config({
    extend: ['skin/myskin/style.css'], //加载新皮肤
    skin: 'layer-ext-myskin' //一旦设定，所有弹层风格都采用此主题。
});
if(!localStorage.getItem("SESSION_OUT")){
	localStorage.setItem("SESSION_OUT", "10007");//登录超时
}
</script><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>主页</title>
<link rel="stylesheet" href="/myNetwork//jsPlugin/bootstrapValidators/css/bootstrapValidator.css">
<link rel="stylesheet" href="/myNetwork//jsPlugin/bootstrap-iconpicker/css/icon-picker.css">
<link rel="stylesheet" href="/myNetwork//jsPlugin/iCheck/square/blue.css">
<link rel="stylesheet" href="/myNetwork//jsPlugin/iCheck/all.css">
<link rel="stylesheet" href="/myNetwork//jsPlugin/select2/select2.css">
<link rel="stylesheet" href="/myNetwork//jsPlugin/bootstrapTree/css/bootstrap-treeview.css">
<script src="/myNetwork//jsPlugin/bootstrapValidators/bootstrapValidator.js"></script>
<script src="/myNetwork//jsPlugin/slimScroll/jquery.slimscroll.js"></script>
<script src="/myNetwork//jsPlugin/fastclick/fastclick.js"></script>
<script src="/myNetwork//jsPlugin/bootstrap-iconpicker/js/iconPicker.js"></script>
<script src="/myNetwork//jsPlugin/iCheck/icheck.js"></script>
<script src="/myNetwork//jsPlugin/select2/select2.full.js"></script>
<script src="/myNetwork//jsPlugin/bootstrapTree/js/bootstrap-treeview.js"></script>
</head>
<body>
<button class="btn btn-success" data-target="#modal" data-toggle="modal">modal</button>
<div class="modal fade" id="modal">
<div class="modal-dialog">
<div class="modal-content">
<div class="modal-header">
<button class="close" data-dismiss="modal">×</button>
title
</div>
<div class="modal-body">
this is main content
</div>
<div class="modal-footer">
<button class="btn btn-default" data-dismiss="modal">cancel</button>
<button class="btn btn-success">ok</button>
</div>
</div>
</div>
</div>
</body>
</html>