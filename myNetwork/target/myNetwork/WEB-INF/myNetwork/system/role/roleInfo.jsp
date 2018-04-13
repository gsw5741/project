<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">

<div class="box box-info">
	
	<!-- /.box-header -->
	<!-- form start -->
	<form class="form-horizontal form-info" action="">
		<div class="box-body">
			<div class="form-group">
				<label class="col-sm-4 control-label">角色名称</label>

				<div class="col-sm-6">${dataInfo.roleName }</div>
			</div>
			<div class="form-group">
				<label class="col-sm-4 control-label">描述</label>

				<div class="col-sm-6">
				<div class="input-group">${dataInfo.description}</div>	
				</div>
			</div>
			
		</div>
	</form>
</div>