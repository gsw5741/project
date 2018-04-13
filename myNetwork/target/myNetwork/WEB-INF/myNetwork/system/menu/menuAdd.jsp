<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="dict" uri="/common-dict-tags"%>
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
	<form class="form-horizontal form-info" id="myForm" action="${_myNetwork}/sysMenu/menuAddMethod">
		<div class="box-body">
			<div class="form-group">
				<label class="col-sm-2 control-label">菜单名称</label>

				<div class="col-sm-8">
					<input type="text" class="form-control" name="menuName" value="${dataInfo.menuName }"  placeholder="菜单名称">
					
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">上级菜单</label>

				<div class="col-sm-8">
				<div class="input-group">
					<input type="text" class="form-control " name="pMenuName" value="${dataInfo.pMenuName}"  placeholder="上级菜单" id="pMenuName"  >
					 <input type="hidden" name="pMenuId" value="${dataInfo.pMenuId}" id="pMenuId">
					<span class="input-group-addon pointer" data-toggle="modal" data-target="#myModal"><i class="fa fa-tree "></i></span>
				   <div class="modal" id="myModal" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
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
				</div>	
				</div>
			</div>
			

			<div class="form-group">
				<label class="col-sm-2 control-label">菜单地址</label>

				<div class="col-sm-8">
					<input type="text" class="form-control" name="menuUrl" value="${dataInfo.menuUrl}" placeholder="菜单地址">
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">菜单类型</label>
				<div class="col-sm-4 control-label">
				<%-- <label>
                  <input type="radio" name="menuType" class="minimal" value="2" <c:if test="${empty dataInfo.menuType || dataInfo.menuType=='2'}">checked="checked"</c:if>>导航菜单
                </label>
				 <label>
                  <input type="radio" name="menuType" class="minimal" value="1" <c:if test="${dataInfo.menuType=='1'}">checked="checked"</c:if>>按钮 
                </label> --%>
                 <c:forEach items="${dict:getSystemDictByCode('MENU_TYPE')}" var="item">
                    <label>
                      <input type="radio" name="menuType" class="minimal" value="${item.codeValue}" <c:if test="${empty dataInfo.menuType || dataInfo.menuType==item.codeValue}">checked="checked"</c:if>>
                      ${item.codeLabel}&nbsp;&nbsp;&nbsp;
                    </label>
                 
                 </c:forEach>
                </div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">显示顺序</label>
				<div class="col-sm-8">
					<input type="text" class="form-control" name="sort" value="${dataInfo.sort}" placeholder="显示顺序">
				</div>
				
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">菜单样式</label>
				<div class="col-sm-8">
					<input type="text" class="form-control" name="menuCss" value="${dataInfo.menuCss }" id="menuCss" placeholder="菜单图标" >
				</div>
				
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">访问权限</label>
				<div class="col-sm-8">
					<input type="text" class="form-control" name="menuAuth" value="${dataInfo.menuAuth }" placeholder="访问权限">
				</div>
				
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">菜单状态</label>
				<div class="col-sm-4 control-label">
				<%--  <label>
                  <input type="radio" name="menuState" class="minimal" value="1" <c:if test="${empty dataInfo.menuState || dataInfo.menuState=='1'}">checked="checked"</c:if>>正常启用 
                </label>
                 <label>
                  <input type="radio" name="menuState" class="minimal" value="2" <c:if test="${dataInfo.menuState=='2'}">checked="checked"</c:if>>功能关闭
                </label> --%>
                 <c:forEach items="${dict:getSystemDictByCode('MENU_STATE')}" var="item">
                    <label>
                      <input type="radio" name="menuStatus" class="minimal" value="${item.codeValue}" <c:if test="${empty dataInfo.menuState || dataInfo.menuState==item.codeValue}">checked="checked"</c:if>>
                      ${item.codeLabel}&nbsp;&nbsp;&nbsp;
                    </label>
                 
                 </c:forEach>
                </div>
				<input name="menuId" type="hidden" value="${dataInfo.menuId}">
			</div>
			
			<div class="form-group">
			
			 <div class="col-sm-offset-2 col-sm-7 button-list">
                  <button type="button" class="btn btn-primary" title="保存" onclick="save();"><i class="fa fa-save"></i></button>
                  <button type="reset" class="btn btn-default" title="重置"><i class="fa fa-refresh"></i></button>
                  
             </div>
             </div>
		</div>
	</form>
</div>