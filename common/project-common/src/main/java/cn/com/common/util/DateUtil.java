package cn.com.common.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * <p>日期工具类 .</p>
 * 
 * @author: liuqing
 */
public class DateUtil {

	public static final String DATE_FORMATTER = "yyyy-MM-dd";
	public static final String DATE_FORMATTERYM = "yyyyMM";
	public static final String DATE_FORMATTERY = "yyyy";
	public static final String DATE_FORMATTER_HMS = "yyyy-MM-dd HH:mm:ss";
	public static final String DATE_FORMATTER_HM = "yyyy-MM-dd HH:mm";
	public static final String DATE_FORMATTER_HMS_SSS = "yyyy-MM-dd HH:mm:ss.SSS";

	public static final String DATE_FORMATTER_WEEK = "yyyy-MM-dd E";
	public static final String DATE_FORMATTER_China_HMS = "yyyy年MM月dd日 HH:mm:ss";
	
	
	public static Date getAddTime(Date d,int hour) {
	     Calendar   calendar   =   new   GregorianCalendar(); 
	     calendar.setTime(d); 
	     calendar.add(Calendar.HOUR_OF_DAY,hour);//把日期往后增加时间.整数往后推,负数往前移动 
         return calendar.getTime();   //这个时间就是日期往后推一天的结果 
		 }

	/**
	 * 获取当前时间时分秒
	 * @return
	 */
	public static String getNowHHMMSS() {
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		String date = sdf.format(new Date());
		return date;
	}
	
	/**
	 * 获取当前时间时分秒
	 * @return
	 */
	public static String getDateHMS(Date d) {
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMATTER_HMS_SSS);
		String date = sdf.format(d);
		return date;
	}
	
	/**
	 * 获取当前时间时分秒
	 * @return
	 */
	public static String getDateFmort(Date d) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String date = sdf.format(d);
		return date;
	}
	public static boolean checkDateStr(String dateStr,String format){
		if(dateStr==null||dateStr.length()==0){
			return true;
		}
		if(dateStr.length()!=format.length()){
			return false;
		}
		if(parseDate(dateStr, format)==null){
			return false;
		}
		return true;
	}
	/**
	 *获取当前时间 年-月
	 * @return
	 */
	public static String getNowMonth(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
		String date = sdf.format(new Date());
		return date;
	}
	/**
	 *获取当前时间 年-月-日
	 * @return
	 */
	public static String getNowDay(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String date = sdf.format(new Date());
		return date;
	}
	/**
	 * <p>根据指定的格式把字符串转日期.</p> 
	 *  
	 * @param: @param dateStr 日期字符串
	 * @param: @param format 日期格式
	 * @param: @return    日期
	 * @return: java.util.Date      
	 * @throws
	 */
	public static java.util.Date parseDate(String dateStr, String format) {
		java.util.Date date = null;
		DateFormat df = new SimpleDateFormat(format);
		try {
			date = df.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return date;
	}
	/**
	 * <p>把日期字符串yyyy-MM-dd转化为日期 .</p>  
	 * 
	 * @param: @param dateStr 日期字符串
	 * @param: @return   日期   
	 * @return: java.util.Date      
	 * @throws
	 */
	public static java.util.Date parseDate(String dateStr) {
		return parseDate(dateStr, DATE_FORMATTER);
	}
	/**
	 * <p>把日期字符串yyyy-MM-dd HH:mm:ss转化为日期 .</p>  
	 * 
	 * @param: @param dateStr 日期字符串
	 * @param: @return   日期   
	 * @return: java.util.Date      
	 * @throws
	 */
	
	public static java.util.Date parseDateTime(String dateStr) {
		return parseDate(dateStr, DATE_FORMATTER_HMS);
	}
	/**
	 * <p>把当前日期转为yyyy-MM-dd格式的字符串 .</p>  
	 * 
	 * @param: @return   日期   
	 * @return: java.util.Date      
	 * @throws
	 */
	public static String todayDateStr() {
		return formatDateToStr(new Date(), DATE_FORMATTER);
	}
	
	/**
	 * <p>把当前日期转为yyyyMM格式的字符串 .</p>  
	 * 
	 * @param: @return   日期   
	 * @return: java.util.Date      
	 * @throws
	 */
	public static String toymDateStr() {
		return formatDateToStr(new Date(), DATE_FORMATTERYM);
	}
	/**
	 * 对显示日期格式处理
	 * 1如果不是当前年份，显示年月日（2011年4月5日）；2如果是当前年份，不是当天，显示月日（12月5日）；3如果是当天，显示时分（5:09）
	 * @param date(yyyy-MM-dd HH24:mi:ss)
	 * @return
	 */
	public static  String  showDatePattern(Date  dateAndroid) {
		String dateStr="";
		Date dateSever=new java.util.Date();
		try {			
			if(dateSever.getYear()==dateAndroid.getYear()){
				if(dateSever.getMonth()==dateAndroid.getMonth()&&dateSever.getDate()==dateAndroid.getDate()){
					int hour=dateAndroid.getHours();
					String hourStr=hour<10?"0"+hour:hour+"";
					int minu=dateAndroid.getMinutes();
					String minuStr=minu<10?"0"+minu:minu+"";
					dateStr = hourStr+":"+minuStr;
				}else{
					dateStr = (dateAndroid.getMonth()+1)+"月"+dateAndroid.getDate()+"日";
				}					
			}else{
				dateStr =  (dateAndroid.getYear()+1900)+"年"+(dateAndroid.getMonth()+1)+"月"+dateAndroid.getDate()+"日";
			}
		} catch (Exception e) {			
			e.printStackTrace();
		}
		return dateStr;			
	}
	/**
	 * <p>把当前日期转为yyyy格式的字符串 .</p>  
	 * 
	 * @param: @return   日期   
	 * @return: java.util.Date      
	 * @throws
	 */
	public static String toyDateStr() {
		return formatDateToStr(new Date(), DATE_FORMATTERY);
	}



	/**
	 * 按照formatter指定的格式的日期字符串 .
	 * @param date
	 *            需要格式化的日期对像
	 * @param formatter
	 *            格式化的字符串形式
	 * @return 日期字符串
	 */
	public static String formatDateToStr(Date date, String formatter) {
		if (date == null){
			return null;
		}
		try {
			return new java.text.SimpleDateFormat(formatter).format(date);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 生成默认格式的日期yyyy-MM-dd.
	 * @param date 日期
	 * @return 日期字符串
	 */
	public static String formatDateToStr(Date date) {
		return formatDateToStr(date, DATE_FORMATTER);
	}
	public static String dyncFormatDateToStr(Date date){
		if(date.getDay()==0){
			return formatDateToStr(date, "yyyy-MM");
		}
		if(date.getHours()==0){
			return formatDateToStr(date, "yyyy-MM-dd");
		}
		if(date.getSeconds()==0){
			return formatDateToStr(date, "yyyy-MM-dd HH:mm");
		}
		return formatDateToStr(date, "yyyy-MM-dd HH:mm:ss");
	}
	/**
	 * 将日期按照指定的模式格式化 .
	 *  
	 * @param date {@link Date}
	 * @param format 如：yyyy/MM/dd
	 * @return 返回空表示格式化产生异常
	 */
	public static String format(java.util.Date date, String format) {
		String result = "";
		try {
			if (date != null) {
				java.text.DateFormat df = new java.text.SimpleDateFormat(format);
				result = df.format(date);
			}
		} catch (Exception e) {
		}
		return result;
	}

	/**
	 * 字符串型日期格式转换.
	 * 
	 * @param sDate
	 *            formatFrom格式的日期字符串
	 * @param formatFrom
	 *            转换前格式
	 * @param formatTo
	 *            转换后格式
	 * 
	 * @return formatTo格式的日期字符串
	 */
	public static String getDateWeek(String sDate, String formatFrom,
			String formatTo) {
		try {
			SimpleDateFormat format = new SimpleDateFormat(formatFrom);
			Date date = format.parse(sDate);
			format.applyPattern(formatTo);
			return format.format(date);
		} catch (Exception ex) {
			return sDate;
		}
	}

	/**
	 * 将一种字符日期转化成另外一种日期格式.
	 * 
	 * @param date 日期字符串
	 * @param fmtSrc 日期格式
	 * @param fmtTag 新日期格式
	 * @return 转化后的字符串
	 */
	public static String format(String date, String fmtSrc, String fmtTag) {
		if (null == fmtSrc){
			return null;
		}
		if (fmtSrc.equals(fmtTag)) {
			return date;
		}
		String year, month, daty;
		int y, m, d;
		fmtSrc = fmtSrc.toUpperCase();
		y = fmtSrc.indexOf("YYYY");
		m = fmtSrc.indexOf("MM");
		d = fmtSrc.indexOf("DD");
		if (y < 0 || m < 0 || d < 0) {
			return date;
		}
		year = date.substring(y, y + 4);
		month = date.substring(m, m + 2);
		daty = date.substring(d, d + 2);
		fmtTag = fmtTag.toUpperCase();
		fmtTag = fmtTag.replaceAll("YYYY", year);
		fmtTag = fmtTag.replaceAll("MM", month);
		fmtTag = fmtTag.replaceAll("DD", daty);
		return fmtTag;
	}

	/**
	 * 计算指定年月的日期数.
	 * 
	 * @param year 指定年份
	 * @param month 指定月份，从1开始
	 * @return 天数
	 */
	public static int maxDayOfMonth(int year, int month) {
		switch (month) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			return 31;
		case 4:
		case 6:
		case 9:
		case 11:
			return 30;
		case 2:
			boolean isRunYear = (year % 400 == 0)
					|| (year % 4 == 0 && year % 100 != 0);
			return isRunYear ? 29 : 28;
		default:
			return 31;
		}
	}

	/**
	 * 获取指定年月的日期数.
	 * 
	 * @param year 指定年份
	 * @param month 指定月份，从1开始
	 * @return 天数
	 */
	public static int maxDayOfMonth(String year, String month) {
		return maxDayOfMonth(Integer.parseInt(year), Integer.parseInt(month));
	}

	/**
	 * 获取指定年月上月月末日期 .
	 * 
	 * @param year 指定年份
	 * @param month 指定月份，从1开始
	 * @return 月末日期字符串
	 */
	public static String getLastMonthDate(String year, String month) {
		return getLastMonthDate(Integer.parseInt(year), Integer.parseInt(month));
	}

	/**
	 * 获取指定年月上月月末日期 .
	 * 
	 * @param year 指定年份
	 * @param month 指定月份，从1开始
	 * @return 月末日期字符串
	 */
	public static String getLastMonthDate(int year, int month) {
		
		StringBuffer bfDate = new StringBuffer();
		bfDate.append(year);
		bfDate.append("-");
		if (month < 10){
			bfDate.append("0");
		}
		
		bfDate.append(month);
		bfDate.append("-");
		bfDate.append(maxDayOfMonth(year, month));
		return bfDate.toString();
	}
	/**
	 * 获取指定年月上月月末日期 .
	 * 
	 * @param year 指定年份
	 * @param month 指定月份，从1开始
	 * @return 月末日期字符串
	 */
	public static String getBeginMonthDate(int year, int month) {
		
		StringBuffer bfDate = new StringBuffer();
		bfDate.append(year);
		bfDate.append("-");
		if (month < 10){
			bfDate.append("0");
		}
		
		bfDate.append(month);
		bfDate.append("-");
		bfDate.append("01");
		return bfDate.toString();
	}
	/**
	 * 提前N天的日期.
	 * 
	 * @param date 当天日期
	 * @param days 提前的天数，正数表示提前，负数表示推后
	 * @return 提前后的日期
	 */
	public static Date beforeDate(Date date, int days) {
		java.util.Calendar c = java.util.Calendar.getInstance();
		c.setTime(date);
		c.add(java.util.Calendar.DAY_OF_YEAR, -days);
		return c.getTime();

	}

	/**
	 * 一周前的日期.
	 * 
	 * @return  一周前的日期
	 */
	public static Date getLastWeek() {
		java.util.Calendar c = java.util.Calendar.getInstance();
		c.add(java.util.Calendar.DAY_OF_YEAR, -7);
		return c.getTime();

	}
	/**
	 * 获取日期的小时数 .
	 * 
	 * @param cal 日期
	 * @return  小时数
	 */
	public static int curHour(Calendar cal) {
		return cal.get(Calendar.HOUR_OF_DAY);
	}
	/**
	 * 获取日期的分钟数 .
	 * 
	 * @param cal 日期
	 * @return  分钟数 
	 */
	public static int curMinute(Calendar cal) {
		return cal.get(Calendar.MINUTE);
	}
	/**
	 * 获取日期的秒数 .
	 * 
	 * @param cal 日期
	 * @return  秒数 
	 */
	public static int curSecond(Calendar cal) {
		return cal.get(Calendar.SECOND);
	}

	

	/**
	 * 计算当前日期某年的第几周 .
	 * @return interger
	 * @throws ParseException
	 **/
	public static int getWeekNumOfYear() {
		Calendar calendar = Calendar.getInstance();
		int iWeekNum = calendar.get(Calendar.WEEK_OF_YEAR);
		return iWeekNum;
	}

	/**
	 * 计算指定日期某年的第几周 .
	 * @param strDate 日期字符串yyyy-MM-dd
	 * @return interger
	 * @throws ParseException
	 */
	public static int getWeekNumOfYearDay(String strDate) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(parseDate(strDate));
		int iWeekNum = calendar.get(Calendar.WEEK_OF_YEAR);
		return iWeekNum;
	}

	/**
	 * yearNum年份第weekNum周周一的日期转yyyy-MM-dd.
	 * 
	 * @param yearNum 年份
	 * @param weekNum 该年的第几周
	 * @return 日期字符串
	 */
	public static String getWeekFirstDay(int yearNum, int weekNum) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, yearNum);
		cal.set(Calendar.WEEK_OF_YEAR, weekNum);
		cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		// 分别取得当前日期的年、月、日
		String tempYear = Integer.toString(yearNum);
		String tempMonth = Integer.toString(cal.get(Calendar.MONTH) + 1);
		String tempDay = Integer.toString(cal.get(Calendar.DATE));
		return tempYear + "-" + tempMonth + "-" + tempDay;
	}
	/**
	 * 当前年份第weekNum周周一的日期转yyyy-MM-dd.
	 * 
	 * @param weekNum 该年的第几周
	 * @return 日期字符串
	 */
	public static String getWeekFirstDay(int weekNum) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.WEEK_OF_YEAR, weekNum);
		cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		// 分别取得当前日期的年、月、日
		String tempMonth = Integer.toString(cal.get(Calendar.MONTH) + 1);
		String tempDay = Integer.toString(cal.get(Calendar.DATE));
		return cal.get(Calendar.YEAR) + "-" + tempMonth + "-" + tempDay;
	}

	/**
	 * yearNum年份第weekNum周周末的日期转yyyy-MM-dd.
	 * 
	 * @param yearNum 年份
	 * @param weekNum 该年的第几周
	 * @return 日期字符串
	 */
	public static String getWeekEndDay(int yearNum, int weekNum) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, yearNum);
		cal.set(Calendar.WEEK_OF_YEAR, weekNum + 1);
		cal.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
		// 分别取得当前日期的年、月、日
		String tempMonth = Integer.toString(cal.get(Calendar.MONTH) + 1);
		String tempDay = Integer.toString(cal.get(Calendar.DATE));
		return cal.get(Calendar.YEAR) + "-" + tempMonth + "-" + tempDay;
	}
	/**
	 * 当前年份第weekNum周周末的日期转yyyy-MM-dd.
	 * 
	 * @param weekNum 该年得到第几周
	 * @return 日期字符串
	 */
	public static String getWeekEndDay(int weekNum) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.WEEK_OF_YEAR, weekNum + 1);
		cal.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
		// 分别取得当前日期的年、月、日
		String tempMonth = Integer.toString(cal.get(Calendar.MONTH) + 1);
		String tempDay = Integer.toString(cal.get(Calendar.DATE));
		return cal.get(Calendar.YEAR) + "-" + tempMonth + "-" + tempDay;
	}

	/**
	 * date+len天后的日期转字符串yyyyMMdd格式.
	 * 
	 * @param date 传入yyyyMMdd格式日期
	 * @param len 距离的天数
	 * @return 今天加len后的日期
	 */
	public static String getDay(String date, int len) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		try {
			Calendar cal = Calendar.getInstance();
			cal.setTime(sdf.parse(date));
			cal.add(Calendar.DATE, len);
			return sdf.format(cal.getTime());
		} catch (Exception e) {
			return date;
		}
	}
	public static int getYearNow(){
		Calendar cal = Calendar.getInstance();
		return cal.get(Calendar.YEAR);
	}
	public static String getYearForDate(Date date){
		if(date == null){
			return "";
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(Calendar.YEAR)+"";
	}
	public static int getMonthNow(){
		Calendar cal = Calendar.getInstance();
		return cal.get(Calendar.MONTH)+1;
	}
	public static String getMonthForDate(Date date){
		if(date == null){
			return "";
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(Calendar.MONTH)+1+"";
	}
	public static String getDayForDate(Date date){
		if(date == null){
			return "";
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(Calendar.DAY_OF_MONTH)+"";
	}
	public static String getHourForDate(Date date){
		if(date == null){
			return "";
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(Calendar.HOUR_OF_DAY)+"";
	}
	public static String getMinuteForDate(Date date){
		if(date == null){
			return "";
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(Calendar.MINUTE)+"";
	}
	public static String getCurMonthEndStr(){
		Calendar cal = Calendar.getInstance();
		int year=cal.get(Calendar.YEAR);
		int month=cal.get(Calendar.MONTH)+1;
		String day=getLastMonthDate(year,month);
		return day;
	}
	public static String getCurMonthBeginStr(){
		Calendar cal = Calendar.getInstance();
		int year=cal.get(Calendar.YEAR);
		int month=cal.get(Calendar.MONTH)+1;
		return getBeginMonthDate(year,month);
	}
	public static void main(String[] args) {
         System.out.println(dyncFormatDateToStr(formatStrToDateByLength("2014-05-06 05:07")));
         System.out.println(dyncFormatDateToStr(formatStrToDateByLength("2014-05-06")));
	}
	
	/**
	 * 将yyyy-MM型的日期格式进行转换
	 * @param date 需进行转换的日期
	 * @param format 需进行转换的日期格式
	 * @param num 月份加或减的数量 如+2 月份加2，-2月份减2
	 * @return
	 */
	public static String changeMonth(String date,String format,int num){
		GregorianCalendar gc=new GregorianCalendar(); 
		 try {
			gc.setTime( new SimpleDateFormat("yyyy-MM").parse(date));
		} catch (ParseException e) {
			e.printStackTrace();
		}
        gc.add(2,num);
        String df=  new SimpleDateFormat(format).format(gc.getTime());
		return  df;
	}
	/**
	 * 获取当前年count年后的时间
	 * @param startdate
	 * @param count
	 * @return
	 */
	public static String getAllowPreMonth(Date date, int count,String format) {
		Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.YEAR, count);
        date = calendar.getTime();
        return format(date, format);
	}
	
	/**
	 * 当前时间+len天后的日期转字符串 yyyyMMdd.
	 * @param len 距离的天数，正负均可
	 * @return 今天加len后的日期
	 */
	public static String getDay(int len) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String date = sdf.format(new Date());
		try {
			Calendar cal = Calendar.getInstance();
			cal.setTime(sdf.parse(date));
			cal.add(Calendar.DATE, len);
			return sdf.format(cal.getTime());
		} catch (Exception e) {
			return date;
		}
	}

	/**
	 * 当前时间转yyyy-MM-dd HH:mm:ss.SSS.
	 * @return 日期
	 */
	public static String getToDate() {
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMATTER_HMS_SSS);
		String date = sdf.format(new Date());
		return date;
	}

	/**
	 * String 转 Date yyyy-MM-dd HH:mm:ss.SSS .
	 * @param time 日期字符串
	 * @return 日期
	 */
	public static Date getStrToDateByAll(String time) {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMATTER_HMS_SSS);
		try {
			date = sdf.parse(time);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	/**
	 * String 转 Date yyyy-MM-dd .
	 * @param time 日期字符串
	 * @return 日期
	 */
	public static Date getStrToDateByTen(String time) {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMATTER);
		try {
			date = sdf.parse(time);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	/**
	 * 将传入时间格式转换成传出时间格式 .
	 * @param dateStr 日期字符串
	 * @param inFormat 传入字符串的日期格式
	 * @param toFormat 返回的字符串的日期格式
	 * @return toFormat time
	 */
	public static String formatStrDateToStr(String dateStr, String inFormat,
			String toFormat) {
		SimpleDateFormat sf = new SimpleDateFormat(inFormat);
		Date date;
		String time = "";
		try {
			date = sf.parse(dateStr);
			sf = new SimpleDateFormat(toFormat);
			time = sf.format(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return time;
	}

	/**
	 * <p>获得日期是一周的第几天，星期日是第一天，星期二是第二天.... .</p>  
	 * @param: @param cd 日期
	 * @param: @return  返回第几天      
	 * @return: int      
	 * @throws
	 */
	private static int getMondayPlus(Calendar cd) {

		int dayOfWeek = cd.get(Calendar.DAY_OF_WEEK);
		if (dayOfWeek == 1) {
			return 7;
		} else {
			return dayOfWeek - 1;
		}
	}

	/**
	 * 获取相对某天的过去日期 .
	 * @param cal
	 *            某天的日期
	 * @param num
	 *            相对某天的数目
	 * @param state
	 *            0代表相对天，1代表相对月
	 * @return String 日期字符串
	 * @throws
	 */
	private static String getPreDay(Calendar cal, int num, int state) {
		if (state == 0) {
			cal.add(Calendar.DAY_OF_MONTH, -num);
		} else if (state == 1) {
			cal.add(Calendar.MONTH, -num);
		}
		return format(cal.getTime(), DATE_FORMATTER);
	}

	/**
	 * 根据state状态（周，月，季度，半年，年）获取相应的起始时间和结束时间 .
	 * @param state
	 *            统计时间段状态
	 * @return  本期起始日期，本期结束日期， 上期起始日期，上期结束日期文本
	 * @throws
	 */
	public static Map<String, String> getDatesByState(String state) {
		Map<String, String> map = new HashMap<String, String>();
		Calendar cal = Calendar.getInstance(Locale.CHINA);
		map.put("curEndDate", format(cal.getTime(), DATE_FORMATTER));
		// 周信息
		if ("1".equals(state)) {
			int dayPeriod = getMondayPlus(cal);
			map.put("curStartDate", getPreDay(cal, dayPeriod - 1, 0));
			map.put("preEndDate", getPreDay(cal, 1, 0));
			map.put("preStartDate", getPreDay(cal, 6, 0));
			// 月信息
		} else if ("2".equals(state)) {
			cal.set(Calendar.DAY_OF_MONTH, 1);
			map.put("curStartDate", format(cal.getTime(), DATE_FORMATTER));
			map.put("preEndDate", getPreDay(cal, 1, 0));
			cal.set(Calendar.DAY_OF_MONTH, 1);
			map.put("preStartDate", format(cal.getTime(), DATE_FORMATTER));
			// 季度信息
		} else if ("3".equals(state)) {
			cal.set(Calendar.DAY_OF_MONTH, 1);
			map.put("curStartDate", getPreDay(cal, 2, 1));
			map.put("preEndDate", getPreDay(cal, 1, 0));
			cal.set(Calendar.DAY_OF_MONTH, 1);
			map.put("preStartDate", getPreDay(cal, 2, 1));
			// 半年信息
		} else if ("4".equals(state)) {
			cal.set(Calendar.DAY_OF_MONTH, 1);
			map.put("curStartDate", getPreDay(cal, 5, 1));
			map.put("preEndDate", getPreDay(cal, 1, 0));
			cal.set(Calendar.DAY_OF_MONTH, 1);
			map.put("preStartDate", getPreDay(cal, 5, 1));
			// 年信息
		} else if ("5".equals(state)) {
			cal.set(Calendar.DAY_OF_MONTH, 1);
			cal.set(Calendar.MONTH, 0);
			map.put("curStartDate", format(cal.getTime(), DATE_FORMATTER));
			map.put("preEndDate", getPreDay(cal, 1, 0));
			cal.set(Calendar.DAY_OF_MONTH, 1);
			cal.set(Calendar.MONTH, 0);
			map.put("preStartDate", format(cal.getTime(), DATE_FORMATTER));
		}
		return map;
	}
	
	/**
	 * 根据当月显示哪半年返回起始时间
	 * @return  本期起始日期
	 * @throws
	 */
	public static String getDatesByM() {
		String ym=getNowMonth();
		String[] yms=ym.split("-");
		String y=yms[0];
		String m=yms[1];
		if (Integer.parseInt(m)<7) {
			return y+"-01-01";
		} else {
			return y+"-06-01";
		} 
	}
	/**
	 * <p>根据字符串长度来转换日期。失败返回null.</p>  
	 * @param: @param dateStr 日期字符串
	 * @param: @return   日期   
	 * @return: Date      
	 * @throws
	 */
	public static Date formatStrToDateByLength(String dateStr) {
		if (dateStr==null||dateStr.isEmpty()) {
			return null;
		}
		int strLength = dateStr.length();
		Date date = new Date();
		String dateFormat = DATE_FORMATTER;
		SimpleDateFormat sdf = null;
		try {
			if(strLength==DATE_FORMATTER_HMS_SSS.length()){
				dateFormat = DATE_FORMATTER_HMS_SSS;
			}if(strLength==DATE_FORMATTER_HM.length()){
				dateFormat = DATE_FORMATTER_HM;
			}if(strLength==DATE_FORMATTER_HMS.length()){
				dateFormat = DATE_FORMATTER_HMS;
			}
			sdf = new SimpleDateFormat(dateFormat);
			date = sdf.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
		return date;
	}
	/**
	 * 得到当前时间，时间到毫秒.
	 * @return Long
	 */
	public static Long getNow(){
		Date dt = new Date();
		long time = dt.getTime();   //得到秒数
		return time;
	}
	/**
	 * <p>毫秒数转日期.</p>  
	 * @param: @param time 毫秒数
	 * @param: @return    日期  
	 * @return: Date      
	 * @throws
	 */
	public static Date longToDate(long time){
		Date dt = new Date(time);
		return dt;
	}
	public static long getNextDay0HourDiff(int hour, int minute) {
		long systemTime = System.currentTimeMillis();
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(systemTime);
		cal.set(Calendar.DATE, cal.get(Calendar.DATE) + 1);
		cal.set(Calendar.HOUR_OF_DAY, hour);
		cal.set(Calendar.MINUTE, minute);
		cal.set(Calendar.SECOND, 0);
		long diff = cal.getTimeInMillis() - systemTime;
		if (diff <= 0L) {
			diff = 1 * 1000 * 10L;
		}
		return diff;
	}
	

}
