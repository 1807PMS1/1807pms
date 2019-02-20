package com.zs.pms.utils;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;





/**
 * @author Administrator
 *时间工具类
 */
public class DateUtil {
/**
 *  获得当前时间的方法（字符串）
 * @return 放回当前时间字符串
 */
	public static String getStrDate(Date date) {
		//获得日历对象
		Calendar cal =Calendar.getInstance();
		//当前的年
		int y=cal.get(Calendar.YEAR);
		//当前的月(月份是从0开始的)
		int m=cal.get(Calendar.MONTH)+1;
		//当前的日
		int d=cal.get(Calendar.DAY_OF_MONTH);
		//当前的小时（24小时制）
		int hh=cal.get(Calendar.HOUR_OF_DAY);
		//通过获得当前的小时来判断是上午中午下午
		String str="";
		if (hh>=6&&hh<=11) {
			str="上午好";
		} else if (hh>11&&hh<=14) {
			str="中午好";
		}else if (hh>14&&hh<=18) {
			str="下午好";
		}else if (hh>18&&hh<24) {
			str="晚上好";
		}else {
			str="太晚了，快去睡觉";
		}
		return y+"-"+m+"-"+d+" "+str;	
	}
	
	
	/**
	 * 字符串转Date的方法
	 * @param time
	 * @param pattern 输入字符串的时间格式
	 * @return 返回的是date的时间
	 * @throws ParseException
	 */
	public static Date getStrToDate(String time,String pattern) throws ParseException {
		//获得格式化对象
		SimpleDateFormat sdf =new SimpleDateFormat(pattern);
	    //返回格式化后的时间
		return sdf.parse(time);
	}
	
	
	/**
	 * date转string时间的方法
	 * @param time date类的时间
	 * @param pattern 把时间格式化什么样
	 * @return 字符串类的时间
	 */
	public static String getDateToStr(Date time,String pattern) {
		// 获得格式化对象
		SimpleDateFormat sdf =new SimpleDateFormat(pattern);
		// 返回格式化后的时间
		return sdf.format(time);
		
	}

	//测试的输出方法
//	public static void main(String[] args) {
//		System.out.println(DateUtil.getStrDate());
//		try {
//			System.out.println(DateUtil.getStrToDate("2018-1-1 12:22:12", "yyyy-MM-dd hh:mm:ss"));
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
}
