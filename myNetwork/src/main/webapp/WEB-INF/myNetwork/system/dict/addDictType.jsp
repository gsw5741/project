<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"+ request.getServerName() + ":" + request.getServerPort() + path;
%>
<c:set var="_myNetwork" value="<%=basePath%>" />
<div class="box box-info">
	
	<!-- /.box-header -->
	<!-- form start -->
	<form class="form-horizontal form-info" id="myDictTypeForm" action="${_myNetwork}/sysDict/addTypeMethod">
		<div class="box-body">
			<div class="form-group">
				<label class="col-sm-2 control-label">字典名称</label>

				<div class="col-sm-8">
					<input type="text" class="form-control" name="name" value="${dataInfo.name }"  placeholder="字典名称">
					
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">字典代码</label>

				<div class="col-sm-8">
					<input type="text" class="form-control" name="code" value="${dataInfo.code}" placeholder="字典代码">
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">字典描述</label>
				<div class="col-sm-8">
					<input type="text" class="form-control" name="description" value="${dataInfo.description }"  placeholder="字典描述" >
				</div>
				
			</div>
	        <input name="typeId" type="hidden" value="${dataInfo.typeId}">
			<div class="form-group">
			
			 <div class="col-sm-offset-2 col-sm-7 button-list">
                  <button type="button" class="btn btn-primary" title="保存" onclick="saveDictType();"><i class="fa fa-save"></i></button>
                  <button type="reset" class="btn btn-default" title="重置"><i class="fa fa-refresh"></i></button>
                  
             </div>
             </div>
		</div>
	</form>
</div>