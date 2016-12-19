package com.warehouse.util;

import java.beans.PropertyEditorSupport;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;
import org.springframework.beans.propertyeditors.PropertiesEditor;

public class LongEditor extends PropertiesEditor
{
	protected transient final Logger log = Logger.getLogger(this.getClass());
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		try {  
			String patterTimeStr = "\\d{4}-\\d{1,2}-\\d{1,2}\\s\\d{1,2}\\:\\d{1,2}\\:\\d{1,2}";
			String patterDateStr = "\\d{4}-\\d{1,2}-\\d{1,2}";
			Pattern patternTime = Pattern.compile(patterTimeStr);
			Pattern patternDate = Pattern.compile(patterDateStr);

			Matcher matcher = patternTime.matcher(text);
			Matcher dateMatcher = patternDate.matcher(text);

			if (matcher.find()) {
				setValue(FormDataUtil.toLongDate14(text));
			} else if (dateMatcher.find()) {
				setValue(FormDataUtil.toLongDate8(text));
			}else{
				setValue(text);
			}
		} catch (Exception e) {
			log.error(e);
		}
	}

}
