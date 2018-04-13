package org.apache.jsp.WEB_002dINF.myNetwork.system;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

static private org.apache.jasper.runtime.ProtectedFunctionMapper _jspx_fnmap_0;

static {
  _jspx_fnmap_0= org.apache.jasper.runtime.ProtectedFunctionMapper.getMapForFunction("dict:getSystemName", cn.com.component.system.dic.DictContext.class, "getSystemConfig", new Class[] {java.lang.String.class});
}

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList(3);
    _jspx_dependants.add("/common/common-taglib.jsp");
    _jspx_dependants.add("/WEB-INF/tlds/dic.tld");
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
      out.write("<title>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${dict:getSystemName('systemName')}", java.lang.String.class, (PageContext)_jspx_page_context, _jspx_fnmap_0, false));
      out.write("</title>\r\n");
      if (_jspx_meth_cmt_005fincludeJs_005f1(_jspx_page_context))
        return;
      out.write("<link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${_myNetwork}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/jsPlugin/jvectormap/jquery-jvectormap-1.2.2.css\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic\">\r\n");
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
      out.write("      <h1>资源展示<small>Version 2.0</small></h1>\r\n");
      out.write("      <ol class=\"breadcrumb\">\r\n");
      out.write("        <li><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${_myNetwork}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/index\"><i class=\"fa fa-dashboard\"></i> 主页</a></li>\r\n");
      out.write("        <li class=\"active\">资源展示</li>\r\n");
      out.write("      </ol>\r\n");
      out.write("    </section>\r\n");
      out.write("\r\n");
      out.write("    <!-- Main content -->\r\n");
      out.write("    <section class=\"content\">\r\n");
      out.write("      <!-- Info boxes -->\r\n");
      out.write("      <div class=\"row\">\r\n");
      out.write("        <div class=\"col-md-3 col-sm-6 col-xs-12\">\r\n");
      out.write("          <div class=\"info-box\">\r\n");
      out.write("            <span class=\"info-box-icon bg-aqua\"><i class=\"ion ion-ios-gear-outline\"></i></span>\r\n");
      out.write("\r\n");
      out.write("            <div class=\"info-box-content\">\r\n");
      out.write("              <span class=\"info-box-text\">CPU Traffic</span>\r\n");
      out.write("              <span class=\"info-box-number\">90<small>%</small></span>\r\n");
      out.write("            </div>\r\n");
      out.write("            <!-- /.info-box-content -->\r\n");
      out.write("          </div>\r\n");
      out.write("          <!-- /.info-box -->\r\n");
      out.write("        </div>\r\n");
      out.write("        <!-- /.col -->\r\n");
      out.write("        <div class=\"col-md-3 col-sm-6 col-xs-12\">\r\n");
      out.write("          <div class=\"info-box\">\r\n");
      out.write("            <span class=\"info-box-icon bg-red\"><i class=\"fa fa-google-plus\"></i></span>\r\n");
      out.write("\r\n");
      out.write("            <div class=\"info-box-content\">\r\n");
      out.write("              <span class=\"info-box-text\">Likes</span>\r\n");
      out.write("              <span class=\"info-box-number\">41,410</span>\r\n");
      out.write("            </div>\r\n");
      out.write("            <!-- /.info-box-content -->\r\n");
      out.write("          </div>\r\n");
      out.write("          <!-- /.info-box -->\r\n");
      out.write("        </div>\r\n");
      out.write("        <!-- /.col -->\r\n");
      out.write("\r\n");
      out.write("        <!-- fix for small devices only -->\r\n");
      out.write("        <div class=\"clearfix visible-sm-block\"></div>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"col-md-3 col-sm-6 col-xs-12\">\r\n");
      out.write("          <div class=\"info-box\">\r\n");
      out.write("            <span class=\"info-box-icon bg-green\"><i class=\"ion ion-ios-cart-outline\"></i></span>\r\n");
      out.write("\r\n");
      out.write("            <div class=\"info-box-content\">\r\n");
      out.write("              <span class=\"info-box-text\">Sales</span>\r\n");
      out.write("              <span class=\"info-box-number\">760</span>\r\n");
      out.write("            </div>\r\n");
      out.write("            <!-- /.info-box-content -->\r\n");
      out.write("          </div>\r\n");
      out.write("          <!-- /.info-box -->\r\n");
      out.write("        </div>\r\n");
      out.write("        <!-- /.col -->\r\n");
      out.write("        <div class=\"col-md-3 col-sm-6 col-xs-12\">\r\n");
      out.write("          <div class=\"info-box\">\r\n");
      out.write("            <span class=\"info-box-icon bg-yellow\"><i class=\"ion ion-ios-people-outline\"></i></span>\r\n");
      out.write("\r\n");
      out.write("            <div class=\"info-box-content\">\r\n");
      out.write("              <span class=\"info-box-text\">New Members</span>\r\n");
      out.write("              <span class=\"info-box-number\">2,000</span>\r\n");
      out.write("            </div>\r\n");
      out.write("            <!-- /.info-box-content -->\r\n");
      out.write("          </div>\r\n");
      out.write("          <!-- /.info-box -->\r\n");
      out.write("        </div>\r\n");
      out.write("        <!-- /.col -->\r\n");
      out.write("      </div>\r\n");
      out.write("      <!-- /.row -->\r\n");
      out.write("      <!-- /.row -->\r\n");
      out.write("\r\n");
      out.write("      <!-- Main row -->\r\n");
      out.write("      <div class=\"row\">\r\n");
      out.write("        <!-- Left col -->\r\n");
      out.write("        <div class=\"col-md-8\">\r\n");
      out.write("          <!-- /.box -->\r\n");
      out.write("          <div class=\"row\">\r\n");
      out.write("           \r\n");
      out.write("            <!-- /.col -->\r\n");
      out.write("\r\n");
      out.write("            <div class=\"col-md-6\">\r\n");
      out.write("              <!-- USERS LIST -->\r\n");
      out.write("              <div class=\"box box-danger\">\r\n");
      out.write("                <div class=\"box-header with-border\">\r\n");
      out.write("                  <h3 class=\"box-title\">我的相册</h3>\r\n");
      out.write("\r\n");
      out.write("                  <div class=\"box-tools pull-right\">\r\n");
      out.write("                    <span class=\"label label-danger\">8 New Members</span>\r\n");
      out.write("                    <button type=\"button\" class=\"btn btn-box-tool\" data-widget=\"collapse\"><i class=\"fa fa-minus\"></i>\r\n");
      out.write("                    </button>\r\n");
      out.write("                    <button type=\"button\" class=\"btn btn-box-tool\" data-widget=\"remove\"><i class=\"fa fa-times\"></i>\r\n");
      out.write("                    </button>\r\n");
      out.write("                  </div>\r\n");
      out.write("                </div>\r\n");
      out.write("                <!-- /.box-header -->\r\n");
      out.write("                <div class=\"box-body no-padding\">\r\n");
      out.write("                  <ul class=\"users-list clearfix\">\r\n");
      out.write("                    <li>\r\n");
      out.write("                      <img src=\"dist/img/user1-128x128.jpg\" alt=\"User Image\">\r\n");
      out.write("                      <a class=\"users-list-name\" href=\"#\">Alexander Pierce</a>\r\n");
      out.write("                      <span class=\"users-list-date\">Today</span>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    <li>\r\n");
      out.write("                      <img src=\"dist/img/user8-128x128.jpg\" alt=\"User Image\">\r\n");
      out.write("                      <a class=\"users-list-name\" href=\"#\">Norman</a>\r\n");
      out.write("                      <span class=\"users-list-date\">Yesterday</span>\r\n");
      out.write("                    </li>\r\n");
      out.write("                  \r\n");
      out.write("                  </ul>\r\n");
      out.write("                  <!-- /.users-list -->\r\n");
      out.write("                </div>\r\n");
      out.write("                <!-- /.box-body -->\r\n");
      out.write("                <div class=\"box-footer text-center\">\r\n");
      out.write("                  <a href=\"javascript:void(0)\" class=\"uppercase\">View All Users</a>\r\n");
      out.write("                </div>\r\n");
      out.write("                <!-- /.box-footer -->\r\n");
      out.write("              </div>\r\n");
      out.write("              <!--/.box -->\r\n");
      out.write("            </div>\r\n");
      out.write("             <div class=\"col-md-6\">\r\n");
      out.write("              <!-- USERS LIST -->\r\n");
      out.write("              <div class=\"box box-danger\">\r\n");
      out.write("                <div class=\"box-header with-border\">\r\n");
      out.write("                  <h3 class=\"box-title\">我的通讯录</h3>\r\n");
      out.write("\r\n");
      out.write("                  <div class=\"box-tools pull-right\">\r\n");
      out.write("                    <span class=\"label label-danger\">8 New Members</span>\r\n");
      out.write("                    <button type=\"button\" class=\"btn btn-box-tool\" data-widget=\"collapse\"><i class=\"fa fa-minus\"></i>\r\n");
      out.write("                    </button>\r\n");
      out.write("                    <button type=\"button\" class=\"btn btn-box-tool\" data-widget=\"remove\"><i class=\"fa fa-times\"></i>\r\n");
      out.write("                    </button>\r\n");
      out.write("                  </div>\r\n");
      out.write("                </div>\r\n");
      out.write("                <!-- /.box-header -->\r\n");
      out.write("                <div class=\"box-body no-padding\">\r\n");
      out.write("                  <ul class=\"users-list clearfix\">\r\n");
      out.write("                    <li>\r\n");
      out.write("                      <img src=\"dist/img/user1-128x128.jpg\" alt=\"User Image\">\r\n");
      out.write("                      <a class=\"users-list-name\" href=\"#\">Alexander Pierce</a>\r\n");
      out.write("                      <span class=\"users-list-date\">Today</span>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    <li>\r\n");
      out.write("                      <img src=\"dist/img/user8-128x128.jpg\" alt=\"User Image\">\r\n");
      out.write("                      <a class=\"users-list-name\" href=\"#\">Norman</a>\r\n");
      out.write("                      <span class=\"users-list-date\">Yesterday</span>\r\n");
      out.write("                    </li>\r\n");
      out.write("                   \r\n");
      out.write("                  </ul>\r\n");
      out.write("                  <!-- /.users-list -->\r\n");
      out.write("                </div>\r\n");
      out.write("                <!-- /.box-body -->\r\n");
      out.write("                <div class=\"box-footer text-center\">\r\n");
      out.write("                  <a href=\"javascript:void(0)\" class=\"uppercase\">View All Users</a>\r\n");
      out.write("                </div>\r\n");
      out.write("                <!-- /.box-footer -->\r\n");
      out.write("              </div>\r\n");
      out.write("              <!--/.box -->\r\n");
      out.write("            </div>\r\n");
      out.write("            <!-- /.col -->\r\n");
      out.write("          </div>\r\n");
      out.write("          <!-- /.row -->\r\n");
      out.write("\r\n");
      out.write("          <!-- TABLE: LATEST ORDERS -->\r\n");
      out.write("          <div class=\"box box-info\">\r\n");
      out.write("            <div class=\"box-header with-border\">\r\n");
      out.write("              <h3 class=\"box-title\">我的通讯录</h3>\r\n");
      out.write("\r\n");
      out.write("              <div class=\"box-tools pull-right\">\r\n");
      out.write("                <button type=\"button\" class=\"btn btn-box-tool\" data-widget=\"collapse\"><i class=\"fa fa-minus\"></i>\r\n");
      out.write("                </button>\r\n");
      out.write("                <button type=\"button\" class=\"btn btn-box-tool\" data-widget=\"remove\"><i class=\"fa fa-times\"></i></button>\r\n");
      out.write("              </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <!-- /.box-header -->\r\n");
      out.write("            <div class=\"box-body\">\r\n");
      out.write("              <div class=\"table-responsive\">\r\n");
      out.write("                <table class=\"table no-margin\">\r\n");
      out.write("                  <thead>\r\n");
      out.write("                  <tr>\r\n");
      out.write("                    <th>电话号码</th>\r\n");
      out.write("                    <th>姓名</th>\r\n");
      out.write("                    <th>所属群组</th>\r\n");
      out.write("                    <th>操作</th>\r\n");
      out.write("                  </tr>\r\n");
      out.write("                  </thead>\r\n");
      out.write("                  <tbody>\r\n");
      out.write("                  <tr>\r\n");
      out.write("                    <td><a href=\"pages/examples/invoice.html\">OR9842</a></td>\r\n");
      out.write("                    <td>Call of Duty IV</td>\r\n");
      out.write("                    <td><span class=\"label label-success\">Shipped</span></td>\r\n");
      out.write("                    <td>\r\n");
      out.write("                      <div class=\"sparkbar\" data-color=\"#00a65a\" data-height=\"20\">90,80,90,-70,61,-83,63</div>\r\n");
      out.write("                    </td>\r\n");
      out.write("                  </tr>\r\n");
      out.write("                  <tr>\r\n");
      out.write("                    <td><a href=\"pages/examples/invoice.html\">OR1848</a></td>\r\n");
      out.write("                    <td>Samsung Smart TV</td>\r\n");
      out.write("                    <td><span class=\"label label-warning\">Pending</span></td>\r\n");
      out.write("                    <td>\r\n");
      out.write("                      <div class=\"sparkbar\" data-color=\"#f39c12\" data-height=\"20\">90,80,-90,70,61,-83,68</div>\r\n");
      out.write("                    </td>\r\n");
      out.write("                  </tr>\r\n");
      out.write("                  <tr>\r\n");
      out.write("                    <td><a href=\"pages/examples/invoice.html\">OR7429</a></td>\r\n");
      out.write("                    <td>iPhone 6 Plus</td>\r\n");
      out.write("                    <td><span class=\"label label-danger\">Delivered</span></td>\r\n");
      out.write("                    <td>\r\n");
      out.write("                      <div class=\"sparkbar\" data-color=\"#f56954\" data-height=\"20\">90,-80,90,70,-61,83,63</div>\r\n");
      out.write("                    </td>\r\n");
      out.write("                  </tr>\r\n");
      out.write("                  <tr>\r\n");
      out.write("                    <td><a href=\"pages/examples/invoice.html\">OR7429</a></td>\r\n");
      out.write("                    <td>Samsung Smart TV</td>\r\n");
      out.write("                    <td><span class=\"label label-info\">Processing</span></td>\r\n");
      out.write("                    <td>\r\n");
      out.write("                      <div class=\"sparkbar\" data-color=\"#00c0ef\" data-height=\"20\">90,80,-90,70,-61,83,63</div>\r\n");
      out.write("                    </td>\r\n");
      out.write("                  </tr>\r\n");
      out.write("                  <tr>\r\n");
      out.write("                    <td><a href=\"pages/examples/invoice.html\">OR1848</a></td>\r\n");
      out.write("                    <td>Samsung Smart TV</td>\r\n");
      out.write("                    <td><span class=\"label label-warning\">Pending</span></td>\r\n");
      out.write("                    <td>\r\n");
      out.write("                      <div class=\"sparkbar\" data-color=\"#f39c12\" data-height=\"20\">90,80,-90,70,61,-83,68</div>\r\n");
      out.write("                    </td>\r\n");
      out.write("                  </tr>\r\n");
      out.write("                  \r\n");
      out.write("                 \r\n");
      out.write("                  </tbody>\r\n");
      out.write("                </table>\r\n");
      out.write("              </div>\r\n");
      out.write("              <!-- /.table-responsive -->\r\n");
      out.write("            </div>\r\n");
      out.write("            <!-- /.box-body -->\r\n");
      out.write("            <div class=\"box-footer clearfix\">\r\n");
      out.write("              <a href=\"javascript:void(0)\" class=\"btn btn-sm btn-info btn-flat pull-left\">Place New Order</a>\r\n");
      out.write("              <a href=\"javascript:void(0)\" class=\"btn btn-sm btn-default btn-flat pull-right\">View All Orders</a>\r\n");
      out.write("            </div>\r\n");
      out.write("            <!-- /.box-footer -->\r\n");
      out.write("          </div>\r\n");
      out.write("          <!-- /.box -->\r\n");
      out.write("        </div>\r\n");
      out.write("        <!-- /.col -->\r\n");
      out.write("\r\n");
      out.write("        <div class=\"col-md-4\">\r\n");
      out.write("          <!-- Info Boxes Style 2 -->\r\n");
      out.write("        \r\n");
      out.write("          <!-- /.info-box -->\r\n");
      out.write("         \r\n");
      out.write("          <!-- /.info-box -->\r\n");
      out.write("         \r\n");
      out.write("          <!-- /.info-box -->\r\n");
      out.write("          \r\n");
      out.write("          <!-- /.info-box -->\r\n");
      out.write("\r\n");
      out.write("          <div class=\"box box-default\">\r\n");
      out.write("            <div class=\"box-header with-border\">\r\n");
      out.write("              <h3 class=\"box-title\">我的音乐</h3>\r\n");
      out.write("\r\n");
      out.write("              <div class=\"box-tools pull-right\">\r\n");
      out.write("                <button type=\"button\" class=\"btn btn-box-tool\" data-widget=\"collapse\"><i class=\"fa fa-minus\"></i>\r\n");
      out.write("                </button>\r\n");
      out.write("                <button type=\"button\" class=\"btn btn-box-tool\" data-widget=\"remove\"><i class=\"fa fa-times\"></i></button>\r\n");
      out.write("              </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        \r\n");
      out.write("            <!-- /.box-body -->\r\n");
      out.write("            <div class=\"box-footer no-padding\">\r\n");
      out.write("              <ul class=\"nav nav-pills nav-stacked\">\r\n");
      out.write("                <li><a href=\"#\">United States of America\r\n");
      out.write("                  <span class=\"pull-right text-red\"><i class=\"fa fa-angle-down\"></i> 12%</span></a></li>\r\n");
      out.write("                <li><a href=\"#\">India <span class=\"pull-right text-green\"><i class=\"fa fa-angle-up\"></i> 4%</span></a>\r\n");
      out.write("                </li>\r\n");
      out.write("                <li><a href=\"#\">China\r\n");
      out.write("                  <span class=\"pull-right text-yellow\"><i class=\"fa fa-angle-left\"></i> 0%</span></a></li>\r\n");
      out.write("              </ul>\r\n");
      out.write("            </div>\r\n");
      out.write("            <!-- /.footer -->\r\n");
      out.write("          </div>\r\n");
      out.write("          <!-- /.box -->\r\n");
      out.write("\r\n");
      out.write("          <!-- PRODUCT LIST -->\r\n");
      out.write("          <div class=\"box box-primary\">\r\n");
      out.write("            <div class=\"box-header with-border\">\r\n");
      out.write("              <h3 class=\"box-title\">我的笔记</h3>\r\n");
      out.write("\r\n");
      out.write("              <div class=\"box-tools pull-right\">\r\n");
      out.write("                <button type=\"button\" class=\"btn btn-box-tool\" data-widget=\"collapse\"><i class=\"fa fa-minus\"></i>\r\n");
      out.write("                </button>\r\n");
      out.write("                <button type=\"button\" class=\"btn btn-box-tool\" data-widget=\"remove\"><i class=\"fa fa-times\"></i></button>\r\n");
      out.write("              </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <!-- /.box-header -->\r\n");
      out.write("            <div class=\"box-body\">\r\n");
      out.write("              <ul class=\"products-list product-list-in-box\">\r\n");
      out.write("                <li class=\"item\">\r\n");
      out.write("                  <div class=\"product-img\">\r\n");
      out.write("                    <img src=\"dist/img/default-50x50.gif\" alt=\"Product Image\">\r\n");
      out.write("                  </div>\r\n");
      out.write("                  <div class=\"product-info\">\r\n");
      out.write("                    <a href=\"javascript:void(0)\" class=\"product-title\">Samsung TV\r\n");
      out.write("                      <span class=\"label label-warning pull-right\">$1800</span></a>\r\n");
      out.write("                        <span class=\"product-description\">\r\n");
      out.write("                          Samsung 32\" 1080p 60Hz LED Smart HDTV.\r\n");
      out.write("                        </span>\r\n");
      out.write("                  </div>\r\n");
      out.write("                </li>\r\n");
      out.write("                <!-- /.item -->\r\n");
      out.write("                <li class=\"item\">\r\n");
      out.write("                  <div class=\"product-img\">\r\n");
      out.write("                    <img src=\"dist/img/default-50x50.gif\" alt=\"Product Image\">\r\n");
      out.write("                  </div>\r\n");
      out.write("                  <div class=\"product-info\">\r\n");
      out.write("                    <a href=\"javascript:void(0)\" class=\"product-title\">Bicycle\r\n");
      out.write("                      <span class=\"label label-info pull-right\">$700</span></a>\r\n");
      out.write("                        <span class=\"product-description\">\r\n");
      out.write("                          26\" Mongoose Dolomite Men's 7-speed, Navy Blue.\r\n");
      out.write("                        </span>\r\n");
      out.write("                  </div>\r\n");
      out.write("                </li>\r\n");
      out.write("                <!-- /.item -->\r\n");
      out.write("                <li class=\"item\">\r\n");
      out.write("                  <div class=\"product-img\">\r\n");
      out.write("                    <img src=\"dist/img/default-50x50.gif\" alt=\"Product Image\">\r\n");
      out.write("                  </div>\r\n");
      out.write("                  <div class=\"product-info\">\r\n");
      out.write("                    <a href=\"javascript:void(0)\" class=\"product-title\">Xbox One <span class=\"label label-danger pull-right\">$350</span></a>\r\n");
      out.write("                        <span class=\"product-description\">\r\n");
      out.write("                          Xbox One Console Bundle with Halo Master Chief Collection.\r\n");
      out.write("                        </span>\r\n");
      out.write("                  </div>\r\n");
      out.write("                </li>\r\n");
      out.write("                <!-- /.item -->\r\n");
      out.write("                <li class=\"item\">\r\n");
      out.write("                  <div class=\"product-img\">\r\n");
      out.write("                    <img src=\"dist/img/default-50x50.gif\" alt=\"Product Image\">\r\n");
      out.write("                  </div>\r\n");
      out.write("                  <div class=\"product-info\">\r\n");
      out.write("                    <a href=\"javascript:void(0)\" class=\"product-title\">PlayStation 4\r\n");
      out.write("                      <span class=\"label label-success pull-right\">$399</span></a>\r\n");
      out.write("                        <span class=\"product-description\">\r\n");
      out.write("                          PlayStation 4 500GB Console (PS4)\r\n");
      out.write("                        </span>\r\n");
      out.write("                  </div>\r\n");
      out.write("                </li>\r\n");
      out.write("                <!-- /.item -->\r\n");
      out.write("              </ul>\r\n");
      out.write("            </div>\r\n");
      out.write("            <!-- /.box-body -->\r\n");
      out.write("            <div class=\"box-footer text-center\">\r\n");
      out.write("              <a href=\"javascript:void(0)\" class=\"uppercase\">View All Products</a>\r\n");
      out.write("            </div>\r\n");
      out.write("            <!-- /.box-footer -->\r\n");
      out.write("          </div>\r\n");
      out.write("          <!-- /.box -->\r\n");
      out.write("        </div>\r\n");
      out.write("        <!-- /.col -->\r\n");
      out.write("      </div>\r\n");
      out.write("      <!-- /.row -->\r\n");
      out.write("    </section>\r\n");
      out.write("    <!-- /.content -->\r\n");
      out.write("  </div>\r\n");
      out.write("  <!-- /.content-wrapper -->\r\n");
      out.write("    \r\n");
      out.write("    <!--   公共底部 -->\r\n");
      out.write("  ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/common/system/common-footer.jsp", out, false);
      out.write("</div>\r\n");
      out.write("</body>\r\n");
      out.write("<!-- Sparkline -->\r\n");
      out.write("<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${_myNetwork}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/jsPlugin/chartjs/Chart.min.js\"></script>\r\n");
      out.write("<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${_myNetwork}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/jsPlugin/sparkline/jquery.sparkline.min.js\"></script>\r\n");
      out.write("<!-- jvectormap -->\r\n");
      out.write("<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${_myNetwork}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/jsPlugin/jvectormap/jquery-jvectormap-1.2.2.min.js\"></script>\r\n");
      out.write("<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${_myNetwork}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/jsPlugin/jvectormap/jquery-jvectormap-world-mill-en.js\"></script>\r\n");
      out.write("<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${_myNetwork}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/static/js/adminlte.js\"></script>\r\n");
      out.write("\r\n");
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
    // /WEB-INF/myNetwork/system/index.jsp(10,0) name = scriptAttr type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_cmt_005fincludeJs_005f1.setScriptAttr("common,bootstrapTable");
    int _jspx_eval_cmt_005fincludeJs_005f1 = _jspx_th_cmt_005fincludeJs_005f1.doStartTag();
    if (_jspx_th_cmt_005fincludeJs_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fcmt_005fincludeJs_0026_005fscriptAttr_005fnobody.reuse(_jspx_th_cmt_005fincludeJs_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fcmt_005fincludeJs_0026_005fscriptAttr_005fnobody.reuse(_jspx_th_cmt_005fincludeJs_005f1);
    return false;
  }
}
