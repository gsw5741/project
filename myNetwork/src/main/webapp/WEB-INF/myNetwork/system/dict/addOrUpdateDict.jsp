<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"+ request.getServerName() + ":" + request.getServerPort() + path;
%>
<c:set var="_myNetwork" value="<%=basePath%>" />
<div class="box box-info">
	
	<!-- /.box-header -->
	<!-- form start -->
	<form class="form-horizontal form-info" id="myDictForm" action="${_myNetwork}/sysDict/addDictMethod">
		<div class="box-body">
			<div class="form-group">
				<label class="col-sm-2 control-label">字典标签</label>

				<div class="col-sm-8">
					<input type="text" class="form-control" name="codeLabel" value="${dataInfo.codeLabel }"  placeholder="字典标签">
					
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">字典值</label>

				<div class="col-sm-8">
					<input type="text" class="form-control" name="codeValue"  <c:if test="${dataInfo.dictId!=null}">readonly="readonly"</c:if> value="${dataInfo.codeValue}" placeholder="字典值">
				</div>
			</div>
	        <input name="dictTypeId" type="hidden" value="${dataInfo.dictTypeId}">
	        <input name="code" type="hidden" value="${dataInfo.code}">
	        <input name="dictId" type="hidden" value="${dataInfo.dictId}">
			<div class="form-group">
			
			 <div class="col-sm-offset-2 col-sm-7 button-list">
                  <button type="button" class="btn btn-primary" title="保存" onclick="saveDict();"><i class="fa fa-save"></i></button>
                  <button type="reset" class="btn btn-default" title="重置"><i class="fa fa-refresh"></i></button>
                  
             </div>
             </div>
		</div>
	</form>
</div>