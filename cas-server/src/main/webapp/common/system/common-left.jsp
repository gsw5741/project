<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%> 
<c:set var="_myNetwork" value="<%=basePath%>"/>
<link rel="stylesheet" href="${_myNetwork }/static/css/skins/_all-skins.min.css">
  <aside class="main-sidebar">
    <section class="sidebar">
      <div class="user-panel">
        <div class="pull-left image">
          <img src="${_myNetwork}/static/img/user2-160x160.jpg" class="img-circle" alt="User Image">
        </div>
        <div class="pull-left info">
          <p>${currentUser.loginName}</p>
         
        </div>
      </div>
      <!-- search form -->
      <form action="#" method="get" class="sidebar-form">
        <div class="input-group">
          <input type="text" name="q" class="form-control" placeholder="Search...">
              <span class="input-group-btn">
                <button type="submit" name="search" id="search-btn" class="btn btn-flat"><i class="fa fa-search"></i>
                </button>
              </span>
        </div>
      </form>
    
      <ul class="sidebar-menu" data-widget="tree">
        <li class="header"></li>
        
        <c:forEach items="${menuList}" var="item">
       
          <c:if test="${item.pMenuId eq '0' && item.menuState eq '1'&&item.menuType eq '2'}">
            <li class="treeview">
             <a href="javascript:void(0);" <c:if test="${item.menuUrl!=null&&item.menuUrl!=''}"> onclick="gotoMenu('${item.menuUrl}')"</c:if>>
            <i class="${item.menuCss}"></i> <span>${item.menuName}</span>
            <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
          </a>
          
          <ul class="treeview-menu">
          <c:forEach items="${menuList}" var="bean">
             <c:if test="${bean.pMenuId eq item.menuId && bean.menuType eq '2' && bean.menuState eq '1' }">
               <c:if test="${bean.menuName=='数据源监控'}">
                <li><a href="${_myNetwork}/admin/druid" target="_blank"><i class="${bean.menuCss}"></i> ${bean.menuName}</a></li>
               </c:if>
                <c:if test="${bean.menuName!='数据源监控'}">
                <li><a href="javascript:void(0);" <c:if test="${bean.menuUrl!=null&&bean.menuUrl!=''}">onclick="gotoMenu('${bean.menuUrl}')"</c:if> ><i class="${bean.menuCss}"></i> ${bean.menuName}</a></li>
               </c:if>
              
             </c:if>
          </c:forEach>
          </ul>
           </li>
          </c:if>
          
        </c:forEach>
       
      </ul>
    </section>
  </aside>
  <script>
   function gotoMenu(url){
	   window.location.href = _myNetwork + '/'+url;
   }
  
  </script>
  