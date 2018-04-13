package cn.com.common.propertyEditor;

import java.beans.PropertyEditorSupport;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang3.StringEscapeUtils;
/**
 * html标签转换
 */
public class HtmlEscapeEditor extends PropertyEditorSupport {

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		setValue(StringUtils.isEmpty(text)?null:StringEscapeUtils.escapeHtml4(text));
	}
   
}
