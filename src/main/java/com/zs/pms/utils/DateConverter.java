package com.zs.pms.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

//S：源 被转换的类型   
//T:target 目标类型  将要转换的类型
//必须先  S T 类型修改后才能实现接口里的方法
public class DateConverter implements Converter<String, Date> {

	@Override
	public Date convert(String source) {
		
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		sf.setLenient(false);   
		try {
			
			return sf.parse(source);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
