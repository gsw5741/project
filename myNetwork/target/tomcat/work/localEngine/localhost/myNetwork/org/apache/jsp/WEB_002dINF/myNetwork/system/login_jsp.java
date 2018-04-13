package org.apache.jsp.WEB_002dINF.myNetwork.system;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("  <meta charset=\"utf-8\">\r\n");
      out.write("  <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n");
      out.write("  ");
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
      out.write("<title>登录</title>\r\n");
      out.write("  ");
      if (_jspx_meth_cmt_005fincludeJs_005f1(_jspx_page_context))
        return;
      out.write("</head>\r\n");
      out.write("<body class=\"hold-transition login-page\">\r\n");
      out.write("<div class=\"login-box\">\r\n");
      out.write("  <div class=\"login-logo\">\r\n");
      out.write("    <a href=\"#\"><b>欢迎</b>登录</a>\r\n");
      out.write("  </div>\r\n");
      out.write("\r\n");
      out.write("  <div class=\"login-box-body\">\r\n");
      out.write("    <p class=\"login-box-msg\"></p>\r\n");
      out.write("\r\n");
      out.write("    <form action=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${_myNetwork}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/login\" method=\"post\" id=\"myForm\">\r\n");
      out.write("     <span id=\"erroTip\" style=\"display: none;color: red;\"></span>\r\n");
      out.write("      <div class=\"form-group has-feedback\">\r\n");
      out.write("        <input type=\"text\" class=\"form-control\" placeholder=\"用户名\" name=\"loginName\">\r\n");
      out.write("        <span class=\"glyphicon glyphicon-user form-control-feedback\"></span>\r\n");
      out.write("      </div>\r\n");
      out.write("      <div class=\"form-group has-feedback\">\r\n");
      out.write("        <input type=\"password\" class=\"form-control\" placeholder=\"密码\" name=\"loginPwd\">\r\n");
      out.write("        <span class=\"glyphicon glyphicon-lock form-control-feedback\"></span>\r\n");
      out.write("        \r\n");
      out.write("      </div>\r\n");
      out.write("      <div class=\"row\">\r\n");
      out.write("        <div class=\"col-xs-8\">\r\n");
      out.write("          <div class=\"checkbox icheck\">\r\n");
      out.write("            <label>\r\n");
      out.write("              <input type=\"checkbox\" name=\"isRememberme\" value=\"1\"> <span>记住我</span>\r\n");
      out.write("            </label>\r\n");
      out.write("          </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <!-- /.col -->\r\n");
      out.write("        <div class=\"col-xs-4\">\r\n");
      out.write("          <button type=\"button\" onclick=\"login()\"  class=\"btn btn-primary btn-block btn-flat\">登录</button>\r\n");
      out.write("        </div>\r\n");
      out.write("        <!-- /.col -->\r\n");
      out.write("      </div>\r\n");
      out.write("    </form>\r\n");
      out.write("\r\n");
      out.write("    <a href=\"#\">忘记密码</a>\r\n");
      out.write("    <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${_myNetwork}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/register\" class=\"register\">注册新账户</a>\r\n");
      out.write("    <span id=\"platForm\"></span>\r\n");
      out.write("  </div>\r\n");
      out.write("  \r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("  $(function () {\r\n");
      out.write("\t  //$(\"#platForm\").html(navigator.platform);\r\n");
      out.write("    $('input').iCheck({\r\n");
      out.write("      checkboxClass: 'icheckbox_square-blue',\r\n");
      out.write("      radioClass: 'iradio_square-blue',\r\n");
      out.write("      increaseArea: '18%' // optional\r\n");
      out.write("    });\r\n");
      out.write("   \r\n");
      out.write("    $('#myForm').bootstrapValidator({\r\n");
      out.write("      container: 'tooltip',\r\n");
      out.write("  \t  fields: {\r\n");
      out.write("  \t\t  loginName:{\r\n");
      out.write("  \t\t\tvalidators:{\r\n");
      out.write("  \t\t\t\tnotEmpty: {message: \"用户名 不能为空\"}\r\n");
      out.write("  \t\t\t}\r\n");
      out.write("  \t\t  },\r\n");
      out.write("  \t\t \r\n");
      out.write("  \t\t  loginPwd:{\r\n");
      out.write("  \t\t\tvalidators:{\r\n");
      out.write("  \t\t\t\t notEmpty: {message: \"密码 不能为空\"}\r\n");
      out.write("  \t\t\t}\r\n");
      out.write("  \t\t  }\r\n");
      out.write("  \t  }\r\n");
      out.write("    });\r\n");
      out.write("  });\r\n");
      out.write("  function login(){\r\n");
      out.write("\t  var bootstrap =$(\"#myForm\").data(\"bootstrapValidator\");\r\n");
      out.write("\t  bootstrap.validate();//表单验证\r\n");
      out.write(" \t  if(bootstrap.isValid()){\r\n");
      out.write(" \t\t $(\"#erroTip\").show();\r\n");
      out.write("    \t $(\"#erroTip\").html('<img src=\"'+_myNetwork+'/static/img/loading.gif \"/>正在登录')\r\n");
      out.write(" \t\t $.post($(\"#myForm\").attr(\"action\"),$(\"#myForm\").serializeArray(),function(data){\r\n");
      out.write(" \t\t\t if(data.ok){\r\n");
      out.write(" \t\t\t\t window.location.href = _myNetwork + \"/index\";\r\n");
      out.write(" \t\t\t }else{\r\n");
      out.write(" \t\t\t\t $(\"#erroTip\").html(\"\");\r\n");
      out.write(" \t\t\t\t $(\"#erroTip\").html(data.errorMsg); \r\n");
      out.write(" \t\t\t }\r\n");
      out.write(" \t\t\t \r\n");
      out.write(" \t\t },'json');\r\n");
      out.write(" \t }\r\n");
      out.write("  }\r\n");
      out.write("</script>\r\n");
      out.write("</body>\r\n");
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
    // /WEB-INF/myNetwork/system/login.jsp(9,2) name = scriptAttr type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_cmt_005fincludeJs_005f1.setScriptAttr("isCheck,bootstrapValidators");
    int _jspx_eval_cmt_005fincludeJs_005f1 = _jspx_th_cmt_005fincludeJs_005f1.doStartTag();
    if (_jspx_th_cmt_005fincludeJs_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fcmt_005fincludeJs_0026_005fscriptAttr_005fnobody.reuse(_jspx_th_cmt_005fincludeJs_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fcmt_005fincludeJs_0026_005fscriptAttr_005fnobody.reuse(_jspx_th_cmt_005fincludeJs_005f1);
    return false;
  }
}
