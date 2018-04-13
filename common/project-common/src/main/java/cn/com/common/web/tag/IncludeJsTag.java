package cn.com.common.web.tag;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.commons.lang.math.RandomUtils;

import cn.com.common.util.StringUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 导入js
 * Created by Boss on 2017/9/27.
 */
public class IncludeJsTag extends TagSupport {
    private static final long serialVersionUID = -8670488341960429080L;

    private String scriptAttr = "";//导入的js

    public void setScriptAttr(String scriptAttr) {
        this.scriptAttr = scriptAttr;
    }

    @Override
    public int doStartTag() throws JspException {
        return EVAL_PAGE;
    }

    @Override
    public int doEndTag() throws JspException {
        HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
        String contextPath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath();
        if(StringUtil.isNotEmpty(scriptAttr)){
            List<String> resultList = new ArrayList<String>();
            String []script = scriptAttr.split(",");
            if(StringUtil.isContain(script,"jquery")){
                resultList.add("jquery/jquery-3.1.1.min.js");
            }
            if(StringUtil.isContain(script,"bootstrap")){
                resultList.add("bootstrap/css/bootstrap.css");
                resultList.add("bootstrap/js/bootstrap.js");
            }
            if(StringUtil.isContain(script,"bootstrapValidators")){
                resultList.add("bootstrapValidators/css/bootstrapValidator.css");
                resultList.add("bootstrapValidators/bootstrapValidator.js");
            }
            if(StringUtil.isContain(script,"bootstrapTable")){
                resultList.add("bootstrapTable/css/bootstrap-table.css");
                resultList.add("bootstrapTable/js/bootstrap-table.js");
            }
            if(StringUtil.isContain(script,"common")){
                resultList.add("slimScroll/jquery.slimscroll.js");
                resultList.add("fastclick/fastclick.js");
            }
            if(StringUtil.isContain(script,"bootstrap-wysihtml5")){
                resultList.add("bootstrap-wysihtml5/bootstrap3-wysihtml5.all.js");
                resultList.add("bootstrap-wysihtml5/bootstrap3-wysihtml5.css");
            }
            if(StringUtil.isContain(script,"bootstrap-iconpicker")){
                resultList.add("bootstrap-iconpicker/js/iconPicker.js");
                resultList.add("bootstrap-iconpicker/css/icon-picker.css");
            }
            if(StringUtil.isContain(script,"isCheck")){
                resultList.add("iCheck/square/blue.css");
                resultList.add("iCheck/all.css");
                resultList.add("iCheck/icheck.js");
            }
            if(StringUtil.isContain(script,"select2")){
                resultList.add("select2/select2.css");
                resultList.add("select2/select2.full.js");
            }
            if(StringUtil.isContain(script,"layer")){
                resultList.add("layer/skin/layer.css");
                resultList.add("layer/layer.js");
            }
            if(StringUtil.isContain(script,"bootstrapTree")){
                resultList.add("bootstrapTree/css/bootstrap-treeview.css");
                resultList.add("bootstrapTree/js/bootstrap-treeview.js");
            }
           //去除重复元素
            List<String> tempList = new ArrayList<String>();
            for(String s : resultList){
                if(!tempList.contains(s)){
                    tempList.add(s);
                }
            }
            StringBuilder str = new StringBuilder();
//            str.append("<link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css\">\n");
//            str.append("<link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css\">\n");
            for(String s : tempList){
                if(s.endsWith("css")){
                    //<link rel="stylesheet" href="${_myNetwork}/jsPlugin/bootstrap/css/bootstrap.css">
                    str.append("<link rel=\"stylesheet\" href=\"").append(contextPath);
                    str.append("/jsPlugin/").append(s).append("\">\n");
                }
            }
            for(String s : tempList){
              if(s.endsWith("js")){
                   //str.append("<script src=\"${_myNetwork}/jsPlugin/jquery/jquery-3.1.1.min.js\"></script>")
                   str.append("<script src=\"").append(contextPath).append("/jsPlugin/").append(s);
                   str.append("?v=").append(RandomUtils.nextInt(100));
                   str.append("\"></script>\n");
                }
            }
            try {
                pageContext.getOut().print(str.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return EVAL_PAGE;
    }
}
