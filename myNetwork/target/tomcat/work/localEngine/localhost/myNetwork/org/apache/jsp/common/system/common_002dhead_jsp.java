package org.apache.jsp.common.system;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class common_002dhead_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005ffmt_005fformatDate_0026_005fvalue_005fpattern_005fnobody;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005ffmt_005fformatDate_0026_005fvalue_005fpattern_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.release();
    _005fjspx_005ftagPool_005ffmt_005fformatDate_0026_005fvalue_005fpattern_005fnobody.release();
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;


String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;

      //  c:set
      org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_005fset_005f0 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
      _jspx_th_c_005fset_005f0.setPageContext(_jspx_page_context);
      _jspx_th_c_005fset_005f0.setParent(null);
      // /common/system/common-head.jsp(9,0) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fset_005f0.setVar("_myNetwork");
      // /common/system/common-head.jsp(9,0) name = value type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
      _jspx_th_c_005fset_005f0.setValue(basePath);
      int _jspx_eval_c_005fset_005f0 = _jspx_th_c_005fset_005f0.doStartTag();
      if (_jspx_th_c_005fset_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f0);
        return;
      }
      _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f0);
      out.write("<header class=\"main-header\">\r\n");
      out.write("\r\n");
      out.write("    <a href=\"javascript:void(0);\" class=\"logo\">\r\n");
      out.write("      <span class=\"logo-mini\"><b>网站</b></span>\r\n");
      out.write("      <span class=\"logo-lg\"><b>个人网站</b></span>\r\n");
      out.write("      \r\n");
      out.write("    </a>\r\n");
      out.write("    \r\n");
      out.write("    <nav class=\"navbar navbar-static-top\">\r\n");
      out.write("     \r\n");
      out.write("      <a href=\"javascript:void(0);\" class=\"sidebar-toggle\" data-toggle=\"push-menu\" role=\"button\">\r\n");
      out.write("        <span class=\"sr-only\">Toggle navigation</span>\r\n");
      out.write("        <span class=\"icon-bar\"></span>\r\n");
      out.write("        <span class=\"icon-bar\"></span>\r\n");
      out.write("        <span class=\"icon-bar\"></span>\r\n");
      out.write("         <span id=\"localDate\"></span>\r\n");
      out.write("      </a>\r\n");
      out.write("     \r\n");
      out.write("      <div class=\"navbar-custom-menu\">\r\n");
      out.write("        <ul class=\"nav navbar-nav\">\r\n");
      out.write("          <li class=\"dropdown messages-menu\">\r\n");
      out.write("            <a href=\"#\" class=\"dropdown-toggle\"  title=\"修改密码\">\r\n");
      out.write("               <span class=\"pointer\" data-toggle=\"modal\" data-target=\"#myModal\"><i class=\"fa fa-edit\"></i></span>\r\n");
      out.write("              \r\n");
      out.write("            </a>\r\n");
      out.write("           <div class=\"modal fade in\" id=\"myModal\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"myModalLabel\" aria-hidden=\"true\">\r\n");
      out.write("\t\t\t    <div class=\"modal-dialog\">\r\n");
      out.write("\t\t\t        <div class=\"modal-content\">\r\n");
      out.write("\t\t\t            <div class=\"modal-header\">\r\n");
      out.write("\t\t\t                <h4 class=\"modal-title\" id=\"myModalLabel\">选择菜单</h4>\r\n");
      out.write("\t\t\t            </div>\r\n");
      out.write("\t\t\t            <div class=\"modal-body\" id=\"choiceMenu\"></div>\r\n");
      out.write("\t\t\t            <div class=\"modal-footer\">\r\n");
      out.write("\t\t\t                <button type=\"button\" class=\"btn btn-default\" data-dismiss=\"modal\">关闭</button>\r\n");
      out.write("\r\n");
      out.write("\t\t\t            </div>\r\n");
      out.write("\t\t\t        </div><!-- /.modal-content -->\r\n");
      out.write("\t\t\t    </div><!-- /.modal -->\r\n");
      out.write("             </div>\r\n");
      out.write("          </li>\r\n");
      out.write("       \r\n");
      out.write("            <li class=\"dropdown user user-menu\">\r\n");
      out.write("            <a href=\"#\" class=\"dropdown-toggle\" data-toggle=\"dropdown\">\r\n");
      out.write("              <img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${_myNetwork}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/static/img/user2-160x160.jpg\" class=\"user-image\" alt=\"User Image\">\r\n");
      out.write("              <span class=\"hidden-xs\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${currentUser.loginName}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</span>\r\n");
      out.write("            </a>\r\n");
      out.write("            <ul class=\"dropdown-menu\">\r\n");
      out.write("              <!-- User image -->\r\n");
      out.write("              <li class=\"user-header\">\r\n");
      out.write("                <img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${_myNetwork}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/static/img/user2-160x160.jpg\" class=\"img-circle\" alt=\"User Image\">\r\n");
      out.write("\r\n");
      out.write("                <p>\r\n");
      out.write("                  ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${currentUser.loginName}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write(" - Web Developer\r\n");
      out.write("                  <small>");
      if (_jspx_meth_fmt_005fformatDate_005f0(_jspx_page_context))
        return;
      out.write("</small>\r\n");
      out.write("                </p>\r\n");
      out.write("              </li>\r\n");
      out.write("            \r\n");
      out.write("              <!-- Menu Footer-->\r\n");
      out.write("              <li class=\"user-footer\">\r\n");
      out.write("                <div class=\"pull-left\">\r\n");
      out.write("                  <a href=\"#\" class=\"btn btn-default btn-flat\">编辑个人信息</a>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"pull-right\">\r\n");
      out.write("                  <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${_myNetwork}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/loginOut\" class=\"btn btn-default btn-flat\">注销</a>\r\n");
      out.write("                </div>\r\n");
      out.write("              </li>\r\n");
      out.write("            </ul>\r\n");
      out.write("          </li>\r\n");
      out.write("        </ul>\r\n");
      out.write("      </div>\r\n");
      out.write("      \r\n");
      out.write("    </nav>\r\n");
      out.write("  </header>\r\n");
      out.write("  <script>\r\n");
      out.write(" function showLocal(dateObj){\r\n");
      out.write("\t  var daystr=\"\";\r\n");
      out.write("\t  var yy = dateObj.getYear();\r\n");
      out.write("\t\tif (yy < 1900)\r\n");
      out.write("\t\t\tyy = yy + 1900;\r\n");
      out.write("\t\tvar MM = dateObj.getMonth() + 1;\r\n");
      out.write("\t\tif (MM < 10)\r\n");
      out.write("\t\t\tMM = '0' + MM;\r\n");
      out.write("\t\tvar dd = dateObj.getDate();\r\n");
      out.write("\t\tif (dd < 10)\r\n");
      out.write("\t\t\tdd = '0' + dd;\r\n");
      out.write("\t\tvar hh = dateObj.getHours();\r\n");
      out.write("\t\tif (hh < 10)\r\n");
      out.write("\t\t\thh = '0' + hh;\r\n");
      out.write("\t\tvar mm = dateObj.getMinutes();\r\n");
      out.write("\t\tif (mm < 10)\r\n");
      out.write("\t\t\tmm = '0' + mm;\r\n");
      out.write("\t\tvar ss = dateObj.getSeconds();\r\n");
      out.write("\t\tif (ss < 10)\r\n");
      out.write("\t\t\tss = '0' + ss;\r\n");
      out.write("\t  switch(dateObj.getDay()){\r\n");
      out.write("\t  case 0:daystr=\"周日\";break;\r\n");
      out.write("\t  case 1:daystr=\"周一\";break;\r\n");
      out.write("\t  case 2:daystr=\"周二\";break;\r\n");
      out.write("\t  case 3:daystr=\"周三\";break;\r\n");
      out.write("\t  case 4:daystr=\"周四\";break;\r\n");
      out.write("\t  case 5:daystr=\"周五\";break;\r\n");
      out.write("\t  case 6:daystr=\"周六\";break;\r\n");
      out.write("\t  }\r\n");
      out.write("\t  return daystr + \" \" + yy + \"-\" + MM + \"-\" + dd + \" \" + hh + \":\" + mm + \":\" + ss;\r\n");
      out.write("}\r\n");
      out.write("  \r\n");
      out.write("  function showTime(){\r\n");
      out.write("\t  $(\"#localDate\").html(showLocal(new Date()));\r\n");
      out.write("\t  setTimeout(\"showTime()\",1000);\r\n");
      out.write("  } \r\n");
      out.write("  showTime();\r\n");
      out.write("  \r\n");
      out.write("  </script>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_fmt_005fformatDate_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  fmt:formatDate
    org.apache.taglibs.standard.tag.rt.fmt.FormatDateTag _jspx_th_fmt_005fformatDate_005f0 = (org.apache.taglibs.standard.tag.rt.fmt.FormatDateTag) _005fjspx_005ftagPool_005ffmt_005fformatDate_0026_005fvalue_005fpattern_005fnobody.get(org.apache.taglibs.standard.tag.rt.fmt.FormatDateTag.class);
    _jspx_th_fmt_005fformatDate_005f0.setPageContext(_jspx_page_context);
    _jspx_th_fmt_005fformatDate_005f0.setParent(null);
    // /common/system/common-head.jsp(63,25) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_fmt_005fformatDate_005f0.setValue((java.util.Date) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${currentUser.createTime}", java.util.Date.class, (PageContext)_jspx_page_context, null, false));
    // /common/system/common-head.jsp(63,25) name = pattern type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_fmt_005fformatDate_005f0.setPattern("yyyy/MM/dd");
    int _jspx_eval_fmt_005fformatDate_005f0 = _jspx_th_fmt_005fformatDate_005f0.doStartTag();
    if (_jspx_th_fmt_005fformatDate_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005ffmt_005fformatDate_0026_005fvalue_005fpattern_005fnobody.reuse(_jspx_th_fmt_005fformatDate_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005ffmt_005fformatDate_0026_005fvalue_005fpattern_005fnobody.reuse(_jspx_th_fmt_005fformatDate_005f0);
    return false;
  }
}
