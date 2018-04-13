package cn.com.common.propertyEditor;

import java.beans.PropertyEditorSupport;

import cn.com.common.util.DateUtil;
/**
 * 日期转换器
 *
 */
public class DateConvertEditor extends PropertyEditorSupport {
   
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		setValue(DateUtil.formatStrToDateByLength(text));
	}
   
}
