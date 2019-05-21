package com.zhcw.pay.utils.DateUtils;


import org.apache.log4j.Logger;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class DateUtils {
	private static Logger logger = Logger.getLogger(DateUtils.class);
	private static final String Simple_Date_Format = "yyyy-MM-dd";
	private static final int Simple_Date_Format_Length = Simple_Date_Format
			.length();
	private static final String Simple_DateTime_Format = "yyyy-MM-dd HH:mm:ss";
	/*
	 * 
	 * @Title: getInterval
	 * @Description: 
	 * @param nowDateStr
	 * @param buyDateStr
	 * @param formtStr
	 * @return long
	 */
	public static long getInterval(String nowDateStr, String buyDateStr,String formtStr) {
		long quot = 0;
		SimpleDateFormat ft = new SimpleDateFormat(formtStr);
		try {
			Date buyDate = ft.parse(buyDateStr);
			Date nowDate = ft.parse(nowDateStr);
			quot =nowDate.getTime()  - buyDate.getTime();
			quot = quot / 1000 / 60 / 60 / 24;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return quot;
	}
	public static String getWeekDayNumber(Date date) throws Exception {
		String weekDayNumber = "";
		final String dayNames[] = { "SUN", "MON", "TUE", "WED", "THU", "FRI",
				"SAT" };
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
		weekDayNumber = dayNames[dayOfWeek - 1];
		return weekDayNumber;
	}

	/**
	 * �õ�����ǰ��ʱ��
	 *
	 * @param d
	 * @param day
	 * @return
	 */
	public static Date getDateBefore(Date d, int day) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(d);
		calendar.set(Calendar.DATE, calendar.get(Calendar.DATE) - day);
		return calendar.getTime();
	}



	/**
	 *
	 *
	 * @param date
	 * @param dayQty
	 * @return
	 */
	public static Date getDateAfter(Date date, int dayQty) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DATE, dayQty);
		return calendar.getTime();
	}

	/**
	 * �ַ�ת��Ϊ��ͨ������
	 */
	public static Date strToSysDate(String str) {
		if (null != str && str.length() > 0) {
			try {
				if (str.length() <= Simple_Date_Format_Length) { // ֻ�����ڡ�
					return (new SimpleDateFormat(Simple_Date_Format))
							.parse(str);
				} else { // ������ʱ��
					return (new SimpleDateFormat(Simple_DateTime_Format))
							.parse(str);
				}
			} catch (ParseException error) {
				return null;
			}
		} else
			return null;
	}

	public static Date strToSysDate(String str, String fromatStr)
			throws Exception {
		if (null != str && str.length() > 0) {
			try {
				return (new SimpleDateFormat(fromatStr)).parse(str);
			} catch (ParseException error) {
				error.printStackTrace();
				throw error;
			}
		} else
			return null;
	}

	/**
	 * �ַ�ת��Ϊsql������
	 */
	public static java.sql.Date strToSqlDate(String str) {
		if (strToSysDate(str) == null || str.length() < 1)
			return null;
		else
			return new java.sql.Date(strToSysDate(str).getTime());
	}

	/**
	 * sql������ת��Ϊ��ʱ����ַ�
	 */
	public static String toDateTimeStr(java.sql.Date dDate) {
		return toDateTimeStr(dDate, Simple_DateTime_Format);
	}

	/**
	 * sql������ת��Ϊ��ʱ����ַ�
	 */
	public static String toDateTimeStr(java.sql.Date dDate,
			String dateTimeFormatStr) {
		if (dDate == null) {
			return null;
		} else {
			return (new SimpleDateFormat(dateTimeFormatStr)).format(dDate);
		}
	}

	public static String toDateTimeStr(java.sql.Timestamp dDate) {
		return toDateTimeStr(dDate, Simple_DateTime_Format);
	}

	/**
	 * sql������ת��Ϊ��ʱ����ַ�
	 */
	public static String toDateTimeStr(java.sql.Timestamp dDate,
			String dateTimeFormatStr) {
		if (dDate == null) {
			return null;
		} else {
			return (new SimpleDateFormat(dateTimeFormatStr)).format(dDate);
		}
	}

	/**
	 * ��ͨ������ת��Ϊ��ʱ����ַ�
	 */
	public static String toDateTimeStr(Date dDate) {
		return toDateTimeStr(dDate, Simple_DateTime_Format);
	}

	public static String toDateTimeStr(Date dDate,
			String dateTimeFormatStr) {
		if (dDate == null) {
			return null;
		} else {
			return (new SimpleDateFormat(dateTimeFormatStr)).format(dDate);
		}
	}

	/**
	 * sql������ת��Ϊ����ʱ����ַ�
	 */
	public static String toDateStr(java.sql.Date d) {
		if (d == null) {
			return null;
		} else {
			return (new SimpleDateFormat(Simple_Date_Format)).format(d);
		}
	}

	/**
	 * ��ͨ������ת��Ϊ����ʱ����ַ�
	 */
	public static String toDateStr(Date d) {
		if (d == null) {
			return null;
		} else {
			return (new SimpleDateFormat(Simple_Date_Format)).format(d);
		}
	}

	/**
	 * ��õ�ʱ��ʱ�� ����: java.sql.Date
	 */
	public static java.sql.Date getCurrentDate() {
		return new java.sql.Date(new Date().getTime());
	}

	public static java.sql.Date utilToSql(Date date) {
		return new java.sql.Date(date.getTime());
	}

	public static Date sqlToUtil(java.sql.Date date) {
		return new Date(date.getTime());
	}

	public static java.sql.Date compositeDateTime(java.sql.Date date,
			java.sql.Time time) {
		if (null == date || null == time)
			return null;
		Calendar calDate = new GregorianCalendar();
		calDate.setTimeInMillis(date.getTime());

		Calendar calTime = new GregorianCalendar();
		calTime.setTimeInMillis(time.getTime());

		Calendar calCompositeDateTime = new GregorianCalendar();
		int iYear = calDate.get(Calendar.YEAR);
		int iMonth = calDate.get(Calendar.MONTH);
		int iDay = calDate.get(Calendar.DATE);
		int iHour = calTime.get(Calendar.HOUR_OF_DAY);
		int iMin = calTime.get(Calendar.MINUTE);
		int iSec = calTime.get(Calendar.SECOND);
		int iMSec = calTime.get(Calendar.MILLISECOND);
		calCompositeDateTime.set(iYear, iMonth, iDay, iHour, iMin, iSec);
		calCompositeDateTime.set(Calendar.MILLISECOND, iMSec);
		return utilToSql(calCompositeDateTime.getTime());
	}

	public static Date getFirstDateOfThisWeek() throws Exception {
		Date retDate = null;
		Calendar cal = Calendar.getInstance();

		int dayofweek = cal.get(cal.DAY_OF_WEEK) - cal.getFirstDayOfWeek();
		cal.add(cal.DATE, 1 - dayofweek);
		retDate = cal.getTime();
		retDate = new Date(retDate.getTime() - 1 * 24 * 60 * 60 * 1000);

		return retDate;
	}

	public static Date getFirstDateOfThisMonth() throws Exception {
		Date retDate = null;
		Calendar cal = Calendar.getInstance();

		int dayofmonth = cal.get(cal.DATE);
		cal.add(cal.DATE, 1 - dayofmonth);
		retDate = cal.getTime();

		return retDate;
	}
	public static Date getFirstDateOfMonth(Date date) throws Exception {
		int year = DateUtils.getYear(date);
		int month = DateUtils.getMonth(date);
		return (Date)DateUtils.makeDate(year,month, 1);
	}
	public static Date getLastDateOfThisMonth() throws Exception {
		Date retDate = null;

		Calendar cal = Calendar.getInstance();
		cal.add(cal.MONTH, 1);
		int dayofmonth = cal.get(cal.DATE);
		cal.add(cal.DATE, -dayofmonth);
		retDate = cal.getTime();

		return retDate;
	}

	public static Date getLastDateOfMonth(Date date) {
		int year = DateUtils.getYear(date);
		int month = DateUtils.getMonth(date);
		return (Date) DateUtils.addDay(DateUtils.addMonth(DateUtils.makeDate(year,
				month, 1), 1), -1);

	}

	public static Date makeDate(int year, int month, int day) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(1, year);
		calendar.set(2, month - 1);
		calendar.set(5, day);
		calendar.set(11, 0);
		calendar.set(12, 0);
		calendar.set(13, 0);
		calendar.set(14, 0);
		return (Date) calendar.getTime();
	}

	public static Date getDateByMacro(String macro) throws Exception {
		Date retDate = null;
		Date toDate = null;

		if (macro != null) {
			toDate = new Date();

			if (macro.equals("yesterday")) {
				retDate = new Date(toDate.getTime() - 1 * 24 * 60 * 60 * 1000);
			} else if (macro.equals("today")) {
				retDate = toDate;
			} else if (macro.equals("tomorrow")) {
				retDate = new Date(toDate.getTime() + 1 * 24 * 60 * 60 * 1000);
			} else if (macro.equals("before7day")) {
				retDate = new Date(toDate.getTime() - 7 * 24 * 60 * 60 * 1000);
			} else if (macro.equals("after7day")) {
				retDate = new Date(toDate.getTime() + 7 * 24 * 60 * 60 * 1000);
			} else if (macro.equals("lastweekfirstday")) {
				retDate = new Date(getFirstDateOfThisWeek().getTime() - 7 * 24
						* 60 * 60 * 1000);
			} else if (macro.equals("lastweeklastday")) {
				retDate = new Date(getFirstDateOfThisWeek().getTime() - 1 * 24
						* 60 * 60 * 1000);
			} else if (macro.equals("thisweekfirstday")) {
				retDate = getFirstDateOfThisWeek();
			} else if (macro.equals("thisweeklastday")) {
				retDate = getFirstDateOfThisWeek();
				retDate = new Date(retDate.getTime() + 6 * 24 * 60 * 60 * 1000);
			} else if (macro.equals("nextweekfirstday")) {
				retDate = getFirstDateOfThisWeek();
				retDate = new Date(retDate.getTime() + 7 * 24 * 60 * 60 * 1000);
			} else if (macro.equals("nextweeklastday")) {
				retDate = getFirstDateOfThisWeek();
				retDate = new Date(retDate.getTime() + 13 * 24 * 60 * 60 * 1000);
			} else if (macro.equals("lastmonthfirstday")) {
				Calendar cal = Calendar.getInstance();
				cal.add(cal.MONTH, -1);
				int dayofmonth = cal.get(cal.DATE);
				cal.add(cal.DATE, 1 - dayofmonth);
				retDate = cal.getTime();
			} else if (macro.equals("lastmonthlastday")) {
				retDate = DateUtils.getFirstDateOfThisMonth();
				retDate = new Date(retDate.getTime() - 1 * 24 * 60 * 60 * 1000);
			} else if (macro.equals("thismonthfirstday")) {
				retDate = DateUtils.getFirstDateOfThisMonth();
			} else if (macro.equals("thismonthlastday")) {
				retDate = DateUtils.getLastDateOfThisMonth();
			} else if (macro.equals("nextmonthfirstday")) {
				retDate = DateUtils.getLastDateOfThisMonth();
				retDate = new Date(retDate.getTime() + 1 * 24 * 60 * 60 * 1000);
			} else if (macro.equals("nextmonthlastday")) {
				Calendar cal = Calendar.getInstance();
				cal.add(cal.MONTH, 2);
				int dayofmonth = cal.get(cal.DATE);
				cal.add(cal.DATE, -dayofmonth);
				retDate = cal.getTime();
			}
		}

		logger.info(macro + ":" + retDate);

		return retDate;
	}

	public static void main(String[] args) {
		try {

			System.out.println(DateUtils.strToSysDate("2011-07-18 ",
					"yyyy-MM-dd HH:mm:ss").toLocaleString());

			System.out.println(DateUtils.toDateTimeStr(DateUtils.strToSysDate(
					"2011-07-18 23:59:59", "yyyy-MM-dd HH:mm:ss"),
					"yyyy-MM-dd HH:mm:ss"));

		//	if (true)
				//return;
			Date dateTemp = null;
			String macro = "";

			macro = "lastweekfirstday";
			dateTemp = DateUtils.getDateByMacro(macro);
			System.out.println(macro + ":"
					+ DateUtils.toDateTimeStr(dateTemp, "yyyy-MM-dd"));

			macro = "lastweeklastday";
			dateTemp = DateUtils.getDateByMacro(macro);
			System.out.println(macro + ":"
					+ DateUtils.toDateTimeStr(dateTemp, "yyyy-MM-dd"));

			macro = "thisweekfirstday";
			dateTemp = DateUtils.getDateByMacro(macro);
			System.out.println(macro + ":"
					+ DateUtils.toDateTimeStr(dateTemp, "yyyy-MM-dd"));

			macro = "thisweeklastday";
			dateTemp = DateUtils.getDateByMacro(macro);
			System.out.println(macro + ":"
					+ DateUtils.toDateTimeStr(dateTemp, "yyyy-MM-dd"));

			macro = "nextweekfirstday";
			dateTemp = DateUtils.getDateByMacro(macro);
			System.out.println(macro + ":"
					+ DateUtils.toDateTimeStr(dateTemp, "yyyy-MM-dd"));

			macro = "nextweeklastday";
			dateTemp = DateUtils.getDateByMacro(macro);
			System.out.println(macro + ":"
					+ DateUtils.toDateTimeStr(dateTemp, "yyyy-MM-dd"));

			macro = "lastmonthfirstday";
			dateTemp = DateUtils.getDateByMacro(macro);
			System.out.println(macro + ":"
					+ DateUtils.toDateTimeStr(dateTemp, "yyyy-MM-dd"));

			macro = "lastmonthlastday";
			dateTemp = DateUtils.getDateByMacro(macro);
			System.out.println(macro + ":"
					+ DateUtils.toDateTimeStr(dateTemp, "yyyy-MM-dd"));

			macro = "thismonthfirstday";
			dateTemp = DateUtils.getDateByMacro(macro);
			System.out.println(macro + ":"
					+ DateUtils.toDateTimeStr(dateTemp, "yyyy-MM-dd"));

			macro = "thismonthlastday";
			dateTemp = DateUtils.getDateByMacro(macro);
			System.out.println(macro + ":"
					+ DateUtils.toDateTimeStr(dateTemp, "yyyy-MM-dd"));

			macro = "nextmonthfirstday";
			dateTemp = DateUtils.getDateByMacro(macro);
			System.out.println(macro + ":"
					+ DateUtils.toDateTimeStr(dateTemp, "yyyy-MM-dd 00:00:00"));

			System.out.println(DateUtils.toDateTimeStr((DateUtils.addMonth(DateUtils.strToSysDate(DateUtils.toDateTimeStr(dateTemp, "yyyy-MM-dd 00:00:00"), "yyyy-MM-dd 00:00:00"), 1)),"yyyy-MM-dd HH:mm:ss"));

			macro = "nextmonthlastday";
			dateTemp = DateUtils.getDateByMacro(macro);
			System.out.println(macro + ":"
					+ DateUtils.toDateTimeStr(dateTemp, "yyyy-MM-dd"));

			Date nowDate = new Date();
			System.out.println(DateUtils.getWeekDayNumber(nowDate));

			System.out.println(DateUtils.getDateAfter(nowDate, 3));
			System.out.println(DateUtils.getWeekDayNumber(DateUtils
					.getDateAfter(nowDate, 3)));

			System.out.println(DateUtils.getDateBefore(nowDate, 2));
			System.out.println(DateUtils.getWeekDayNumber(DateUtils
					.getDateBefore(nowDate, 2)));

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	public static Date addDate(Date date, int dayQty)
			throws Exception {
		return DateUtils.getDateAfter(date, dayQty);
	}

	/**
	 * �õ�ms������ʱ��
	 *
	 * @param
	 * @param
	 * @return
	 */
	public static Date getDateAfterMs(Date date, int ms) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MILLISECOND, ms);
		return calendar.getTime();
	}

	/**
	 * 加月份
	 *
	 * @param date
	 * @param month
	 * @return
	 * @throws Exception
	 */
	public static Date distanceMonth(Date date, int month)
			throws Exception {
		Calendar ca = Calendar.getInstance();
		ca.setTime(date);
		ca.set(Calendar.MONTH, ca.get(Calendar.MONTH) + month);
		Date newDate = ca.getTime();
		return newDate;
	}

	/**
	 * 时间格式化
	 *
	 * @param date
	 * @param format
	 * @return date
	 */
	public static Date formatDate(Date date, String format) {
		if (date == null || format == null) {
			format = "yyyy-MM-dd";
		}
		String dateStr = "";
		DateFormat dateFormat = new SimpleDateFormat(format);
		dateStr = dateFormat.format(date);
		Date result = null;
		try {
			result = dateFormat.parse(dateStr);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 在日期上增加数个整月
	 */
	public static Date addMonth(Date date, int n) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MONTH, n);
		return cal.getTime();
	}

	public static Date addYear(Date date, int n) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.YEAR, n);
		return cal.getTime();
	}

	/**
	 * 在日期上增加数个整天
	 */
	public static Date addDay(Date date, int n) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, n);
		return cal.getTime();
	}

	/**
	 * 在日期上增加数个小时
	 */
	public static Date addHour(Date date, int n) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.HOUR_OF_DAY, n);
		return cal.getTime();
	}

	/**
	 * 在日期上增加数个分钟
	 */
	public static Date addMinute(Date date, int n) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MINUTE, n);
		return cal.getTime();
	}

	/**
	 * 在日期上增加数个秒
	 */
	public static Date addSecond(Date date, int n) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.SECOND, n);
		return cal.getTime();
	}

	/**
	 * 得到两个日期时间的差额
	 */
	public static long betDate(Date date, Date otherDate) {
		return date.getTime() - otherDate.getTime();
	}

	public static int getMonth(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(2) + 1;
	}

	/**
	 * 杩斿洖鎸囧畾鏃ユ湡鏄摢涓�骞�
	 */
	public static int getYear(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(1);
	}

	/**
	 * 杩斿洖鎸囧畾鏃ユ湡鏄摢涓�骞�
	 */
	public static int getDay(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(5);
	}
	/**
	 * 得到指定月的天数
	 * */

	public static int getMonthMaxDay(int year, int month)
	{
		Calendar a = Calendar.getInstance();
		a.set(Calendar.YEAR, year);
		a.set(Calendar.MONTH, month - 1);
		a.set(Calendar.DATE, 1);//把日期设置为当月第一天
		a.roll(Calendar.DATE, -1);//日期回滚一天，也就是最后一天
		int maxDate = a.get(Calendar.DATE);
		return maxDate;
	}
	public static Map<String, Object> betDate2(Date beginDate, Date endDate) {
		Map<String, Object> returnVal=null;
		long between=(endDate.getTime()-beginDate.getTime())/1000;//除以1000是为了转换成秒
		if(between>0){
			returnVal=new HashMap<String, Object>();
			long day1=between/(24*3600);
			long hour1=between%(24*3600)/3600;
			long minute1=between%3600/60;
			long second1=between%60/60;
			returnVal.put("d", day1);
			returnVal.put("h", hour1);
			returnVal.put("m", minute1);
			returnVal.put("s", second1);
		}
		return returnVal;


	}
	  public static long getBetweenMinQty(Date date1,Date date2) throws Exception
	  {
		  Date date11;
		  Date date22;
		  
		  date11 = DateUtils.strToSysDate(DateUtils.toDateTimeStr(date1, "yyyyMMddHHmmss"),"yyyyMMddHHmmss");
		  date22 = DateUtils.strToSysDate(DateUtils.toDateTimeStr(date2, "yyyyMMddHHmmss"),"yyyyMMddHHmmss");
		  
		  Calendar cal1 = Calendar.getInstance();
		  cal1.setTime(date11);
		  
		  Calendar cal2 = Calendar.getInstance();
		  cal2.setTime(date22);		  
		  
	      return (cal2.getTimeInMillis()-cal1.getTimeInMillis())/(1000*60);
	  }
	  
	  public static Date getLastDate(){
	      Calendar calendar = Calendar.getInstance();  
	      calendar.setTime(getCurrentDate());  
	      calendar.add(Calendar.DAY_OF_MONTH, -1);  
	      
		  return calendar.getTime();
	  }
	  public static String getyyyyMMddTime() {
		  SimpleDateFormat ft = new SimpleDateFormat("yyyyMMdd");
		  return ft.format(getLastDate());
	  }
	  
	  public static int getnowEndTime() {
		  LocalDateTime midnight = LocalDateTime.now().plusDays(1).withHour(0).withMinute(0).withSecond(0).withNano(0);
	      long seconds = ChronoUnit.SECONDS.between(LocalDateTime.now(), midnight);
	      return (int)seconds;
	  }
}
