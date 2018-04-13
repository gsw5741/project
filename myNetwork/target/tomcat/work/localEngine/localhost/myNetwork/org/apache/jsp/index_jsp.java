package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
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

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("<link rel=\"stylesheet\" href=\"/myNetwork//jsPlugin/bootstrap/css/bootstrap.css\">\n");
      out.write("<link rel=\"stylesheet\" href=\"/myNetwork//jsPlugin/layer/skin/layer.css\">\n");
      out.write("<script src=\"/myNetwork//jsPlugin/jquery/jquery-3.1.1.min.js\"></script>\n");
      out.write("<script src=\"/myNetwork//jsPlugin/bootstrap/js/bootstrap.js\"></script>\n");
      out.write("<script src=\"/myNetwork//jsPlugin/layer/layer.js\"></script>\n");
      out.write("<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("<meta content=\"width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no\" name=\"viewport\">\n");
      out.write("<link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css\">\n");
      out.write("<link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css\">\n");
      out.write("<link rel=\"stylesheet\" href=\"http://localhost:8080/myNetwork/static/css/AdminLTE.css\">\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"http://localhost:8080/myNetwork/static/css/reset.css\">\n");
      out.write("\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("var _myNetwork=\"http://localhost:8080/myNetwork\";\n");
      out.write("layer.config({\n");
      out.write("    extend: ['skin/myskin/style.css'], //加载新皮肤\n");
      out.write("    skin: 'layer-ext-myskin' //一旦设定，所有弹层风格都采用此主题。\n");
      out.write("});\n");
      out.write("if(!localStorage.getItem(\"SESSION_OUT\")){\n");
      out.write("\tlocalStorage.setItem(\"SESSION_OUT\", \"10007\");//登录超时\n");
      out.write("}\n");
      out.write("</script><meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("<title>主页</title>\n");
      out.write("<link rel=\"stylesheet\" href=\"/myNetwork//jsPlugin/bootstrapValidators/css/bootstrapValidator.css\">\n");
      out.write("<link rel=\"stylesheet\" href=\"/myNetwork//jsPlugin/bootstrap-iconpicker/css/icon-picker.css\">\n");
      out.write("<link rel=\"stylesheet\" href=\"/myNetwork//jsPlugin/iCheck/square/blue.css\">\n");
      out.write("<link rel=\"stylesheet\" href=\"/myNetwork//jsPlugin/iCheck/all.css\">\n");
      out.write("<link rel=\"stylesheet\" href=\"/myNetwork//jsPlugin/select2/select2.css\">\n");
      out.write("<link rel=\"stylesheet\" href=\"/myNetwork//jsPlugin/bootstrapTree/css/bootstrap-treeview.css\">\n");
      out.write("<script src=\"/myNetwork//jsPlugin/bootstrapValidators/bootstrapValidator.js\"></script>\n");
      out.write("<script src=\"/myNetwork//jsPlugin/slimScroll/jquery.slimscroll.js\"></script>\n");
      out.write("<script src=\"/myNetwork//jsPlugin/fastclick/fastclick.js\"></script>\n");
      out.write("<script src=\"/myNetwork//jsPlugin/bootstrap-iconpicker/js/iconPicker.js\"></script>\n");
      out.write("<script src=\"/myNetwork//jsPlugin/iCheck/icheck.js\"></script>\n");
      out.write("<script src=\"/myNetwork//jsPlugin/select2/select2.full.js\"></script>\n");
      out.write("<script src=\"/myNetwork//jsPlugin/bootstrapTree/js/bootstrap-treeview.js\"></script>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("<button class=\"btn btn-success\" data-target=\"#modal\" data-toggle=\"modal\">modal</button>\n");
      out.write("<div class=\"modal fade\" id=\"modal\">\n");
      out.write("<div class=\"modal-dialog\">\n");
      out.write("<div class=\"modal-content\">\n");
      out.write("<div class=\"modal-header\">\n");
      out.write("<button class=\"close\" data-dismiss=\"modal\">×</button>\n");
      out.write("title\n");
      out.write("</div>\n");
      out.write("<div class=\"modal-body\">\n");
      out.write("this is main content\n");
      out.write("</div>\n");
      out.write("<div class=\"modal-footer\">\n");
      out.write("<button class=\"btn btn-default\" data-dismiss=\"modal\">cancel</button>\n");
      out.write("<button class=\"btn btn-success\">ok</button>\n");
      out.write("</div>\n");
      out.write("</div>\n");
      out.write("</div>\n");
      out.write("</div>\n");
      out.write("</body>\n");
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
}
