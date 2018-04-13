package org.apache.jsp.WEB_002dINF.myNetwork.telephoneBook;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class bookList_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList(2);
    _jspx_dependants.add("/common/common-taglib.jsp");
    _jspx_dependants.add("/WEB-INF/tlds/custom.tld");
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fcmt_005fincludeJs_0026_005fscriptAttr_005fnobody;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fcmt_005fincludeJs_0026_005fscriptAttr_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.release();
    _005fjspx_005ftagPool_005fcmt_005fincludeJs_0026_005fscriptAttr_005fnobody.release();
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

      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Pragma\" content=\"no-cache\">\r\n");
      out.write("<meta http-equiv=\"Cache-Control\" content=\"no-cache\">\r\n");
      out.write("<meta http-equiv=\"Expires\" content=\"0\">\r\n");

String path = request.getContextPath();
String requestUrl = request.getRequestURL().toString();
int index = requestUrl.indexOf(path);
String basePath = requestUrl.substring(0, index) + path;

      //  c:set
      org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_005fset_005f0 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
      _jspx_th_c_005fset_005f0.setPageContext(_jspx_page_context);
      _jspx_th_c_005fset_005f0.setParent(null);
      // /common/common-taglib.jsp(16,0) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fset_005f0.setVar("_myNetwork");
      // /common/common-taglib.jsp(16,0) name = value type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
      _jspx_th_c_005fset_005f0.setValue(basePath);
      int _jspx_eval_c_005fset_005f0 = _jspx_th_c_005fset_005f0.doStartTag();
      if (_jspx_th_c_005fset_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f0);
        return;
      }
      _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f0);
      out.write("<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n");
      out.write("<meta content=\"width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no\" name=\"viewport\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${_myNetwork}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/static/css/AdminLTE.css\">\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${_myNetwork}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/static/css/reset.css\">\r\n");
      if (_jspx_meth_cmt_005fincludeJs_005f0(_jspx_page_context))
        return;
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("var _myNetwork=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${_myNetwork}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\";\r\n");
      out.write("layer.config({\r\n");
      out.write("    extend: ['skin/myskin/style.css'], //加载新皮肤\r\n");
      out.write("    skin: 'layer-ext-myskin' //一旦设定，所有弹层风格都采用此主题。\r\n");
      out.write("});\r\n");
      out.write("if(!localStorage.getItem(\"SESSION_OUT\")){\r\n");
      out.write("\tlocalStorage.setItem(\"SESSION_OUT\", \"10007\");//登录超时\r\n");
      out.write("}\r\n");
      out.write("</script>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<title>主页</title>\r\n");
      if (_jspx_meth_cmt_005fincludeJs_005f1(_jspx_page_context))
        return;
      out.write("</head>\r\n");
      out.write("<body class=\"hold-transition skin-blue sidebar-mini\">\r\n");
      out.write("<div class=\"wrapper\">\r\n");
      out.write("  <!-- 公共头部 -->\r\n");
      out.write("  ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/common/system/common-head.jsp", out, false);
      out.write("<!-- 菜单列表 -->\r\n");
      out.write("  ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/common/system/common-left.jsp", out, false);
      out.write("<!-- Content Wrapper. Contains page content -->\r\n");
      out.write("  <div class=\"content-wrapper\">\r\n");
      out.write("    <!-- Content Header (Page header) -->\r\n");
      out.write("    <section class=\"content-header\">\r\n");
      out.write("      <h1>\r\n");
      out.write("        我的个人网站\r\n");
      out.write("        <small>我的通讯录</small>\r\n");
      out.write("      </h1>\r\n");
      out.write("      <ol class=\"breadcrumb\">\r\n");
      out.write("        <li><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${_myNetwork}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/index.htm\"><i class=\"fa fa-home\"></i> 主页</a></li>\r\n");
      out.write("        <li><a href=\"#\">我的通讯录</a></li>\r\n");
      out.write("        <li class=\"active\">通讯录列表</li>\r\n");
      out.write("      </ol>\r\n");
      out.write("    </section>\r\n");
      out.write("\r\n");
      out.write("    <!-- Main content -->\r\n");
      out.write("   <section class=\"content\">\r\n");
      out.write("      <div class=\"row\">\r\n");
      out.write("\t\t<div class=\"col-xs-12\">\r\n");
      out.write("\t\t\t<div class=\"box-body\">\r\n");
      out.write("\t\t\t\t<table id=\"searchTable\" data-toggle=\"table\">\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t</table>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("     </section>\r\n");
      out.write("      </div>\r\n");
      out.write("\r\n");
      out.write("    <!--   公共底部 -->\r\n");
      out.write("  ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/common/system/common-footer.jsp", out, false);
      out.write("</div>\r\n");
      out.write("</body>\r\n");
      out.write("<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${_myNetwork}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/static/js/adminlte.js\"></script>\r\n");
      out.write(" <script type=\"text/javascript\">\r\n");
      out.write(" $(function(){\r\n");
      out.write("\t $('#searchTable').bootstrapTable({\r\n");
      out.write("\t\t    url:_myNetwork + '/telePhoneBook/bookListData.htm',\r\n");
      out.write("\t\t    method:'post',\r\n");
      out.write("\t\t    columns:[\r\n");
      out.write("\t\t      {field:\"index\",title:\"序号\",formatter:index},\r\n");
      out.write("\t\t      {field:\"telephone\",title:\"电话号码\",formatter:telephone},\r\n");
      out.write("\t\t      {field:\"name\",title:\"姓名\"},\r\n");
      out.write("\t\t      {field:\"address\",title:\"地址\"},\r\n");
      out.write("\t\t      {field:\"operate\",title:\"操作\",formatter:operate}\r\n");
      out.write("\t\t     ],\r\n");
      out.write("\t\t    showColumns: true,\r\n");
      out.write("\t\t    sidePagination:'server',\r\n");
      out.write("\t\t    addData:addBook\r\n");
      out.write("\t});\r\n");
      out.write(" });\r\n");
      out.write(" function index(value,row,index){\r\n");
      out.write("\t return index+1;\r\n");
      out.write(" }\r\n");
      out.write(" function telephone(value,row,index){\r\n");
      out.write("\treturn '<a href=\"javascript:void(0);\" onclick=\"bookInfo(\\'' + row.id + '\\')\">' + value + '</a>';\r\n");
      out.write(" }\r\n");
      out.write("function operate(value,row,index){\r\n");
      out.write("\tvar attr = [];\r\n");
      out.write("\tattr[attr.length] = '<a href=\"javascript:void(0);\" onclick=\"update(\\'' + row.id + '\\')\"><i class=\"fa fa-edit\" title=\"修改\"></i></a>';\r\n");
      out.write("    attr[attr.length] = '<a href=\"javascript:void(0);\" onclick=\"del(\\'' + row.id + '\\')\"> <i class=\"fa fa-trash-o\" title=\"删除\"></i></a>';\r\n");
      out.write("    return attr.join(\"&nbsp;&nbsp;\")\r\n");
      out.write("}\r\n");
      out.write("function addBook(){\r\n");
      out.write("\twindow.location.href = _myNetwork + '/telePhoneBook/addOrUpdateBook.htm';\r\n");
      out.write("}\r\n");
      out.write("function update(id){\r\n");
      out.write("\twindow.location.href = _myNetwork + '/telePhoneBook/addOrUpdateBook.htm?bookId=' + id;\r\n");
      out.write("}\r\n");
      out.write("function del(id){\r\n");
      out.write("\tlayer.confirm('确定删除吗？',{btn:['确定','取消']},\r\n");
      out.write("\t\tfunction(index,layero){\r\n");
      out.write("\t\t   $.post(_myNetwork + '/telePhoneBook/delBook.htm',{bookId:id},function(data){\r\n");
      out.write("\t\t\t   if(data.ok){\r\n");
      out.write("\t\t\t\t   layer.msg('删除成功',{icon:6,time:1000},function(){\r\n");
      out.write("\t\t\t\t\t   $('#searchTable').bootstrapTable(\"refresh\");\r\n");
      out.write("\t\t\t\t   });\r\n");
      out.write("\t\t\t\t  \r\n");
      out.write("\t\t\t   }else{\r\n");
      out.write("\t\t\t\t   layer.alert(data.errorMsg);\r\n");
      out.write("\t\t\t   }\r\n");
      out.write("\t\t\t   \r\n");
      out.write("\t\t   },'json')\r\n");
      out.write("\t    },\r\n");
      out.write("\t    function(index,layero){\r\n");
      out.write("\t    \tlayer.close(index);\r\n");
      out.write("\t    }\r\n");
      out.write("\t);\r\n");
      out.write("}\r\n");
      out.write("function bookInfo(id){\r\n");
      out.write("\twindow.location.href = _myNetwork + '/telePhoneBook/bookInfo.htm?bookId=' + id;\r\n");
      out.write("}\r\n");
      out.write(" </script>\r\n");
      out.write("</html>");
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

  private boolean _jspx_meth_cmt_005fincludeJs_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  cmt:includeJs
    cn.com.common.web.tag.IncludeJsTag _jspx_th_cmt_005fincludeJs_005f0 = (cn.com.common.web.tag.IncludeJsTag) _005fjspx_005ftagPool_005fcmt_005fincludeJs_0026_005fscriptAttr_005fnobody.get(cn.com.common.web.tag.IncludeJsTag.class);
    _jspx_th_cmt_005fincludeJs_005f0.setPageContext(_jspx_page_context);
    _jspx_th_cmt_005fincludeJs_005f0.setParent(null);
    // /common/common-taglib.jsp(24,0) name = scriptAttr type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_cmt_005fincludeJs_005f0.setScriptAttr("jquery,layer,bootstrap");
    int _jspx_eval_cmt_005fincludeJs_005f0 = _jspx_th_cmt_005fincludeJs_005f0.doStartTag();
    if (_jspx_th_cmt_005fincludeJs_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fcmt_005fincludeJs_0026_005fscriptAttr_005fnobody.reuse(_jspx_th_cmt_005fincludeJs_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fcmt_005fincludeJs_0026_005fscriptAttr_005fnobody.reuse(_jspx_th_cmt_005fincludeJs_005f0);
    return false;
  }

  private boolean _jspx_meth_cmt_005fincludeJs_005f1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  cmt:includeJs
    cn.com.common.web.tag.IncludeJsTag _jspx_th_cmt_005fincludeJs_005f1 = (cn.com.common.web.tag.IncludeJsTag) _005fjspx_005ftagPool_005fcmt_005fincludeJs_0026_005fscriptAttr_005fnobody.get(cn.com.common.web.tag.IncludeJsTag.class);
    _jspx_th_cmt_005fincludeJs_005f1.setPageContext(_jspx_page_context);
    _jspx_th_cmt_005fincludeJs_005f1.setParent(null);
    // /WEB-INF/myNetwork/telephoneBook/bookList.jsp(8,0) name = scriptAttr type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_cmt_005fincludeJs_005f1.setScriptAttr("bootstrapTable,common");
    int _jspx_eval_cmt_005fincludeJs_005f1 = _jspx_th_cmt_005fincludeJs_005f1.doStartTag();
    if (_jspx_th_cmt_005fincludeJs_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fcmt_005fincludeJs_0026_005fscriptAttr_005fnobody.reuse(_jspx_th_cmt_005fincludeJs_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fcmt_005fincludeJs_0026_005fscriptAttr_005fnobody.reuse(_jspx_th_cmt_005fincludeJs_005f1);
    return false;
  }
}
