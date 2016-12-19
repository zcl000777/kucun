package com.warehouse.util;

import gaf2.core.util.DateUtil;

import java.io.StringReader;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import antlr.RecognitionException;
import antlr.TokenStreamException;

import com.sdicons.json.mapper.JSONMapper;
import com.sdicons.json.mapper.MapperException;
import com.sdicons.json.model.JSONString;
import com.sdicons.json.model.JSONValue;
import com.sdicons.json.parser.JSONParser;

import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONNull;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;
import net.sf.json.util.JSONStringer;

public class FormDataUtil {
	public static final String DATE_MINUS = "0";
	public static final String DATE_PLUS  = "1";
	public static DateFormat format8 = new SimpleDateFormat("yyyyMMdd");
	public static Long toLongDate14(String value){
		Long rs = Long.parseLong(value.replaceAll("-", "").replaceAll(" ", "").replaceAll(":", ""));
		return rs;
	}
	
	public static Long toLongDate8(String value){
		Long rs = Long.parseLong(value.replaceAll("-", ""));
		return rs;
	}
	
	public static Long StringToLong(String text){
		double d = Double.valueOf(text);
		double dd = d*100;
		BigDecimal bd = new BigDecimal(dd);
		Long ll =Long.valueOf(bd.longValue());
		return ll;
	}
	
	public static Long DateCompute8(String value,String symbol,int days){
		Date parseDate = DateUtil.parseDate(value);
	    Calendar calendar=Calendar.getInstance();   
	    calendar.setTime(new Date(parseDate.getTime())); 
 		if(parseDate!=null)
			if(DATE_MINUS.equals(symbol)){
				calendar.set(Calendar.DAY_OF_MONTH,calendar.get(Calendar.DAY_OF_MONTH)-days);
				return Long.valueOf(format8.format(calendar.getTime()));
//				return Long.valueOf(format8.format((new Date(parseDate.getTime()-days*24*60*60*1000))));
			}
			if(DATE_PLUS.equals(symbol)){
				calendar.set(Calendar.DAY_OF_MONTH,calendar.get(Calendar.DAY_OF_MONTH)+days);
				return Long.valueOf(format8.format(calendar.getTime()));
//				return Long.valueOf(format8.format((new Date(parseDate.getTime()+days*24*60*60*1000))));
			}
		return null;
	}
	 /**
	  * bean 转 json
	  * @param source
	  * @return
	  */
	public  static  String bean2json(Object source){

		JsonConfig config = new JsonConfig();
		config.registerJsonValueProcessor(String.class, new JsonValueProcessor() {
			
			public Object processObjectValue(String arg0, Object arg1, JsonConfig arg2) {
				// TODO Auto-generated method stub
				if(arg1==null||"".equals(arg1))
					return JSONNull.getInstance();
				return arg1;
			}
			
			public Object processArrayValue(Object arg0, JsonConfig arg1) {
				// TODO Auto-generated method stub
				return null;
			}
		});
		config.registerJsonValueProcessor(Long.class, new JsonValueProcessor() {
			
			public Object processObjectValue(String arg0, Object arg1, JsonConfig arg2) {
				// TODO Auto-generated method stub
				if(arg1==null||"".equals(arg1))
					return JSONNull.getInstance();
				return arg1;
			}
			
			public Object processArrayValue(Object arg0, JsonConfig arg1) {
				// TODO Auto-generated method stub
				return null;
			}
		});
		config.registerJsonValueProcessor(Double.class, new JsonValueProcessor() {
			
			public Object processObjectValue(String arg0, Object arg1, JsonConfig arg2) {
				// TODO Auto-generated method stub
				if(arg1==null||"".equals(arg1))
					return JSONNull.getInstance();
				return arg1;
			}
			 
			public Object processArrayValue(Object arg0, JsonConfig arg1) {
				// TODO Auto-generated method stub
				return null;
			}
		});
		
		config.registerJsonValueProcessor(BigDecimal.class, new JsonValueProcessor() {
			
			public Object processObjectValue(String arg0, Object arg1, JsonConfig arg2) {
				// TODO Auto-generated method stub
				if(arg1==null||"".equals(arg1))
					return JSONNull.getInstance();
				return arg1;
			}
			 
			public Object processArrayValue(Object arg0, JsonConfig arg1) {
				// TODO Auto-generated method stub
				return null;
			}
		});
		config.registerJsonValueProcessor(Integer.class, new JsonValueProcessor() {
			
			public Object processObjectValue(String arg0, Object arg1, JsonConfig arg2) {
				// TODO Auto-generated method stub
				if(arg1==null||"".equals(arg1))
					return JSONNull.getInstance();
				return arg1;
			}
			 
			public Object processArrayValue(Object arg0, JsonConfig arg1) {
				// TODO Auto-generated method stub
				return null;
			}
		});
		
		JSONObject json = JSONObject.fromObject(source, config); 
		return "["+json.toString()+"]";
	}
	/**
	 * json 转list
	 * @param json
	 * @param classtype
	 * @return
	 */
	public static List<?> json2list(String json ,Class<?> classtype){
		JsonConfig config = new JsonConfig();
		config.registerJsonValueProcessor(String.class, new JsonValueProcessor() {
			
			public Object processObjectValue(String arg0, Object arg1, JsonConfig arg2) {
				// TODO Auto-generated method stub
				if(arg1==null||"".equals(arg1))
					return JSONNull.getInstance();
				return arg1;
			}
			
			public Object processArrayValue(Object arg0, JsonConfig arg1) {
				// TODO Auto-generated method stub
				return null;
			}
		});
		config.registerJsonValueProcessor(Long.class, new JsonValueProcessor() {
			
			public Object processObjectValue(String arg0, Object arg1, JsonConfig arg2) {
				// TODO Auto-generated method stub
				if(arg1==null||"".equals(arg1))
					return JSONNull.getInstance();
				return arg1;
			}
			
			public Object processArrayValue(Object arg0, JsonConfig arg1) {
				// TODO Auto-generated method stub
				return null;
			}
		});
		config.registerJsonValueProcessor(Double.class, new JsonValueProcessor() {
			
			public Object processObjectValue(String arg0, Object arg1, JsonConfig arg2) {
				// TODO Auto-generated method stub
				if(arg1==null||"".equals(arg1))
					return JSONNull.getInstance();
				return arg1;
			}
			 
			public Object processArrayValue(Object arg0, JsonConfig arg1) {
				// TODO Auto-generated method stub
				return null;
			}
		});
		config.registerJsonValueProcessor(BigDecimal.class, new JsonValueProcessor() {
			
			public Object processObjectValue(String arg0, Object arg1, JsonConfig arg2) {
				// TODO Auto-generated method stub
				if(arg1==null||"".equals(arg1))
					return JSONNull.getInstance();
				return arg1;
			}
			 
			public Object processArrayValue(Object arg0, JsonConfig arg1) {
				// TODO Auto-generated method stub
				return null;
			}
		});
		JSONArray jarray = JSONArray.fromObject(json,config);
		List<?> list = (List<?>)JSONArray.toCollection(jarray, classtype);
		return list;
	}
	/**
	 *  map转bean
	 * @param source
	 * @param destination
	 * @param keymap
	 * @throws Exception
	 */
	@SuppressWarnings("rawtypes")
	public static void Map2Bean(Map source,Object destination,Properties keymap) throws Exception{
		Method[] methods = destination.getClass().getMethods();
		for(int i=0;i<methods.length;i++){
			String methodName = methods[i].getName();
			if(methodName.length() >= 4 && methodName.substring(0,3).equals("set")){
				String key = methodName.substring(3,4).toLowerCase() + methodName.substring(4);
				if(keymap != null){
					String newkey = keymap.getProperty(key);
					if(newkey!=null) 
						key = newkey;
					else
						continue;
				}
				Object obj = source.get(key); 
				Class<?>[] classtype = methods[i].getParameterTypes();						
				if(obj != null) {
					if (Long.class.equals(classtype[0])){
						if(obj.toString().equals("null"))
							continue;
						else
						methods[i].invoke(destination,Long.valueOf(obj.toString()));
					}
					if (String.class.equals(classtype[0])){
						if(obj.toString().equals("null"))
							continue;
						else
						methods[i].invoke(destination,obj.toString());
					}
					if(BigDecimal.class.equals(classtype[0])){
						if(obj.toString().equals("null"))
							continue;
						else
						methods[i].invoke(destination,BigDecimal.valueOf(Double.valueOf(obj.toString())));
					}
						
				}
			}
		}
	}

	/**
	 * list 转 json
	 * @param list
	 * @return
	 */
	public static String list2Json(List<?> list){
		JsonConfig config = new JsonConfig();
		config.registerJsonValueProcessor(String.class, new JsonValueProcessor() {
			
			public Object processObjectValue(String arg0, Object arg1, JsonConfig arg2) {
				// TODO Auto-generated method stub
				if(arg1==null||"".equals(arg1))
					return JSONNull.getInstance();
				return arg1;
			}
			
			public Object processArrayValue(Object arg0, JsonConfig arg1) {
				// TODO Auto-generated method stub
				return null;
			}
		});
		config.registerJsonValueProcessor(Long.class, new JsonValueProcessor() {
			
			public Object processObjectValue(String arg0, Object arg1, JsonConfig arg2) {
				// TODO Auto-generated method stub
				if(arg1==null||"".equals(arg1))
					return JSONNull.getInstance();
				return arg1;
			}
			
			public Object processArrayValue(Object arg0, JsonConfig arg1) {
				// TODO Auto-generated method stub
				return null;
			}
		});
		config.registerJsonValueProcessor(Double.class, new JsonValueProcessor() {
			
			public Object processObjectValue(String arg0, Object arg1, JsonConfig arg2) {
				// TODO Auto-generated method stub
				if(arg1==null||"".equals(arg1))
					return JSONNull.getInstance();
				return arg1;
			}
			 
			public Object processArrayValue(Object arg0, JsonConfig arg1) {
				// TODO Auto-generated method stub
				return null;
			}
		});
		config.registerJsonValueProcessor(BigDecimal.class, new JsonValueProcessor() {
			
			public Object processObjectValue(String arg0, Object arg1, JsonConfig arg2) {
				// TODO Auto-generated method stub
				if(arg1==null||"".equals(arg1))
					return JSONNull.getInstance();
				return arg1;
			}
			 
			public Object processArrayValue(Object arg0, JsonConfig arg1) {
				// TODO Auto-generated method stub
				return null;
			}
		}); 
		JSONArray jarray = JSONArray.fromObject(list,config);
		return jarray.toString();
	}
	
	public static String parseBean2json(Object object) throws MapperException{
		JSONValue json = JSONMapper.toJSON(object);
		String render = json.render(true);
		return render;
	}
	
	@SuppressWarnings("rawtypes")
	public static Object parseJson2Bean(String source,Class classtype) throws TokenStreamException, RecognitionException, MapperException{
		JSONParser jsonParser = new JSONParser(new StringReader(source));
		JSONValue nextValue = jsonParser.nextValue();
		return JSONMapper.toJava(nextValue, classtype);
	}
	
	@SuppressWarnings("rawtypes")
	public static String parseList2Json(List list) throws MapperException{
		JSONArray jarray = new JSONArray();
		for(int i=0;i<list.size();i++){
			String json = FormDataUtil.parseBean2json(list.get(i));
			JSONObject jobj = JSONObject.fromObject(json);
			jarray.add(jobj);
		}
		return jarray.toString();
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static List parseJson2List(String json,Class classtype) throws Exception{
		JSONArray jsonArray = JSONArray.fromObject(json);
		List list = new ArrayList();
		for(int i =0;i<jsonArray.size();i++){
			Object obj = parseJson2Bean(jsonArray.getString(i),classtype);
			list.add(obj);
		}
		return list;
	}
}
