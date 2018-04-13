<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"+ request.getServerName() + ":" + request.getServerPort() + path;
%>
<c:set var="_myNetwork" value="<%=basePath%>" />
<div class="box box-info">
	
	<!-- /.box-header -->
	<!-- form start -->
	<form class="form-horizontal form-info" id="myForm" action="${_myNetwork}/sysRole/roleAddMethod">
		<div class="box-body">
			<div class="form-group">
				<label class="col-sm-4 control-label">角色名称</label>

				<div class="col-sm-6">
					<input type="text" class="form-control" name="roleName" value="${dataInfo.roleName }"  placeholder="角色名称">
					
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-4 control-label">描述</label>

				<div class="col-sm-6">
				<div class="input-group">
					<input type="text" class="form-control " name="description" value="${dataInfo.description}" >
					
				</div>	
				</div>
			</div>
			<input type="hidden" name="roleId" value="${dataInfo.roleId}" >
			
			<div class="form-group">
			
			 <div class="col-sm-offset-2 col-sm-7 button-list">
                  <button type="button" class="btn btn-primary" title="保存" onclick="save();"><i class="fa fa-save"></i></button>
                  <button type="reset" class="btn btn-default" title="重置"><i class="fa fa-refresh"></i></button>
                  
             </div>
             </div>
		</div>
	</form>
</div>