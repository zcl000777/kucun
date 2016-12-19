package com.warehouse.util;

import java.beans.PropertyEditorSupport;
import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;
import org.springframework.beans.propertyeditors.PropertiesEditor;

public class MoneyEditor extends PropertiesEditor {
	protected transient final Logger log = Logger.getLogger(this.getClass());
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		String req = "^[0-9]+(.[0-9]{2})?$";
		Pattern patternstr = Pattern.compile(req);
		Matcher matcher = patternstr.matcher(text);
		try{
		if(matcher.find()){
			double d = Double.valueOf(text);
			double dd = d*100;
			BigDecimal bd = new BigDecimal(dd);
			Long ll =Long.valueOf(bd.longValue());
			setValue(ll);
		}
		else{
			setValue(text);
		}
		}catch(Exception e){
			log.error(e.getMessage());
		}
	}
}
