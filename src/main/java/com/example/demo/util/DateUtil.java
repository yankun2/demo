package com.example.demo.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

import javax.xml.datatype.XMLGregorianCalendar;


/**
 * @author 309814490@qq.com
 * @date 2015年11月12日 上午11:54:41
 * @version V1.0
 */
public class DateUtil {
    /**
     * 时间格式 yyyy-MM-dd HH:mm:ss
     */
	public static String DEFAULT = "yyyy-MM-dd HH:mm:ss";
	/**
     * 时间格式 yyyyMM
     */
	public static String yyyyMM = "yyyyMM";
	/**
     * 时间格式 yyyyMMdd
     */
	public static String yyyyMMdd = "yyyyMMdd";
	/**
     * 时间格式 yyyy-MM-dd 
     */
	public static String yyyy_MM_dd = "yyyy-MM-dd";
	/**
     * 时间格式 yyyyMMddHHmmss
     */
	public static String yyyyMMddHHmmss = "yyyyMMddHHmmss";
	/**
     * 时间格式 yyyy-MM-dd HH:mm:ss.SSS
     */
	public static String yyyyMMddHHmmssSSS = "yyyy-MM-dd HH:mm:ss.SSS";
	
	/**
	 * 获取当前时间
	 * @return
	 */
	public static long getCurrentTime() {
		return Calendar.getInstance().getTime().getTime();
	}
	/**
	 * 获取当前时间 yyyy-MM-dd HH:mm:ss
	 * @param date
	 * @return
	 */
	public static String getTime(Date date) {
		SimpleDateFormat format = new SimpleDateFormat(DEFAULT);
		date = (date == null ? Calendar.getInstance().getTime() : date);
		return format.format(date);
	}
	/**
	 * 根据时间戳生成当前时间 yyyy-MM-dd HH:mm:ss
	 * @param time
	 * @return
	 */
	public static String getTime(long time) {
		Calendar instance = Calendar.getInstance();
		instance.setTimeInMillis(time);
		return new SimpleDateFormat(DEFAULT).format(instance.getTime());
	}
	/**
	 * 根据时间戳生成当前时间  格式传入
	 * @param time
	 * @param format
	 * @return
	 */
	public static String getTime(long time, String format) {
		Calendar instance = Calendar.getInstance();
		instance.setTimeInMillis(time);
		return new SimpleDateFormat(format).format(instance.getTime());
	}
	/**
	 * 根据传入格式的时间获取时间戳
	 * @param date
	 * @param parttern
	 * @return
	 */
	public static long getTime(String date, String parttern) {
		SimpleDateFormat format = new SimpleDateFormat(parttern);
		try {
			return format.parse(date).getTime();
		} catch (ParseException e) {
			return 0;
		}
	}
	/**
	 * 根据yyyy-MM-dd HH:mm:ss格式的时间获取时间戳
	 * @param date
	 * @return
	 */
	public static long getTime(String date) {
		SimpleDateFormat format = new SimpleDateFormat(DEFAULT);
		try {
			return format.parse(date).getTime();
		} catch (ParseException e) {
			return 0;
		}
	}
	/**
	 * 获取yyyy-MM-dd HH:mm:ss格式的日期
	 * @param date
	 * @return
	 */
	public static Date getDate(String date) {
		SimpleDateFormat format = new SimpleDateFormat(DEFAULT);
		try {
			return format.parse(date);
		} catch (ParseException e) {
			return null;
		}
	}
	/**
     * 获取传入格式的日期
     * @param date
     * @return
     */
	public static Date getDate(String date, String format) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		try {
			return dateFormat.parse(date);
		} catch (ParseException e) {
			return null;
		}
	}
	
	public static Date convertToDate(XMLGregorianCalendar cal) throws Exception {
		GregorianCalendar ca = cal.toGregorianCalendar();
		return ca.getTime();
	}
	/**
	 * 根据传入格式的日期转换为字符串时间
	 * @param date
	 * @param format
	 * @return
	 */
	public static String format(Date date, String format) {
		return new SimpleDateFormat(format).format(date);
	}
	/**
     * 根据传入格式的字符串时间转换为日期
     * @param date
     * @param format
     * @return
     */
	public static Date parse(String date, String format) {
		try {
			return new SimpleDateFormat(format).parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return null;
	}
	/**
	 * 根据yyyyMMdd获取星期一
	 * @param date
	 * @return
	 */
	public static String genMonday(String date) {
		SimpleDateFormat format = new SimpleDateFormat(yyyyMMdd);
		Date d = null;
		try {
			d = format.parse(date);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(d);
		cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		if (d.compareTo(cal.getTime()) < 0) {
			cal.set(Calendar.DATE, cal.get(Calendar.DATE) - 7);
		}
		return format.format(cal.getTime());
	}
	/**
	 * 日期比较
	 * @param begin
	 * @param end
	 * @return
	 */
	public static boolean compareAcTime(Date begin, Date end) {
        boolean flag = false;
        if (begin.getTime() <= System.currentTimeMillis()
                && System.currentTimeMillis() <= end.getTime()) {
            flag = true;
        }
        return flag;
    }
	
	/**
	 * 获取当前日期与本周星期一相差的天数
	 * 
	 * @param date
	 * @return
	 */
	public static int getMondayPlus(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		// 获得今天是一周的第几天，星期日是第一天，星期一是第二天...
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
		if (Locale.CHINA.equals(Locale.getDefault())) {
			// 中国的星期一作为第一天（减1天）
			dayOfWeek = (dayOfWeek - 1);
		}
		if (dayOfWeek == 1) {
			return 0;
		} else {
			return (1 - dayOfWeek);
		}
	}
	
	/**
	 * 获取指定日期所在周星期一的日期
	 * 
	 * @param date
	 * @return
	 */
	public static String getMonday(Date date) {
		int mondayPlus = getMondayPlus(date);
		GregorianCalendar currDate = new GregorianCalendar();
		currDate.setTime(date);
		currDate.add(GregorianCalendar.DATE, mondayPlus);
		return format(currDate.getTime(),yyyy_MM_dd);
	}
	
	/**
	 * 获取指定日期所在周星期日的日期
	 * 
	 * @param date
	 * @return
	 */
	public static String getSunday(Date date) {
		int mondayPlus = getMondayPlus(date);
		GregorianCalendar currDate = new GregorianCalendar();
		currDate.setTime(date);
		currDate.add(GregorianCalendar.DATE, mondayPlus + 6);
		return format(currDate.getTime(),yyyy_MM_dd);
	}
	/**
	 * 获取指定日期月份的第一天
	 * 
	 * @param date
	 * @return
	 */
	public static String getDateOfMonthBegin(Date date) {
		try {
			if (date != null) {
				return format(date,"yyyy-MM").concat("-01");
			}
		} catch (Exception ex) {
		}
		return null;
	}

	
	/**
	 * 获取指定的格式化日期
	 * 
	 * @param date
	 * @return 2009-09-24 yyyy-MM-dd
	 */
	public static Date getFormatDate(Date date) {
		if (date != null) {
			try {
				DateFormat df = new SimpleDateFormat(yyyy_MM_dd);
				return df.parse(df.format(date));
			} catch (Exception ex) {
				// throw ex;
			}
		}
		return null;
	}
	
	/**
	 * 获取以指定的某天为基准的任意一天
	 * 
	 * @param i
	 *            :0表示当天,1表示明天,-1表示昨天...
	 * @return 1900-01-01
	 */
	public static String getCustomDay(int i, Date date) {
		Calendar calendar = Calendar.getInstance();
		try {
			calendar.setTime(getFormatDate(date));
			calendar.add(Calendar.DAY_OF_MONTH, i);
			return format(calendar.getTime(),yyyy_MM_dd);
		} catch (Exception ex) {
			// throw ex;
		}
		return null;
	}
	
	/**
	 * 获取时间后几天
	 * @param d
	 * @param day
	 * @return
	 */
	public static Date getDateAfter(Date d, int day) {  
        Calendar now = Calendar.getInstance();  
        now.setTime(d);  
        now.set(Calendar.DATE, now.get(Calendar.DATE) + day);  
        return parse(getTime(now.getTime()),DEFAULT);  
    }
	
	/**
	 * 获取以当月为基准的任意一个月的日期
	 * 
	 * @param i
	 *            :0表示当月,1表示下个月,-1表示上个月...
	 * @return strDate
	 */
	public static String getCustomMonth(int i, String strDate) {
		Calendar calendar = Calendar.getInstance();
		try {
			calendar.setTime(parse(strDate,yyyy_MM_dd));
			calendar.add(Calendar.MONTH, i);
			return format(calendar.getTime(),yyyy_MM_dd);
		} catch (Exception ex) {
		}
		return null;
	}


	
	/**
	 * 获取指定日期的23点时间
	 * 
	 * @param dateTime
	 * @return
	 */
	public static String getTimeOfDayEnd(Date dateTime) {
		return getCustomDay(0, dateTime).concat(" 23:59:59");
	}
	
	/**
	 * 获取指定日期的零点时间
	 * 
	 * @param dateTime
	 * @return
	 */
	public static String getTimeOfDayBegin(Date dateTime) {
		return getCustomDay(0, dateTime).concat(" 00:00:00");
	}
	
	/**
	 * 获取指定日期的零点时间
	 * 
	 * @return
	 */
	public static String getTimeOfDayBegin() {
		return getTimeOfDayBegin(new Date());
	}
	
	/**
	 * 获取指定日期的23点时间
	 * 
	 * @return
	 */
	public static String getTimeOfDayEnd() {
		return getTimeOfDayEnd(new Date());
	}
	
	/**
	 * 获取指定周星期一的日期零点时间
	 * 
	 * @param date
	 * @return
	 */
	public static String getTimeOfMonday(Date date) {
		return getMonday(date).concat(" 00:00:00");
	}
	
	/**
	 * 获取指定周星期一的日期零点时间
	 * 
	 * @return
	 */
	public static String getTimeOfMonday() {
		return getTimeOfMonday(new Date());
	}
	
	/**
	 * 获取指定周的星期日日期23点时间
	 * 
	 * @return
	 */
	public static String getTimeOfSunday() {
		return getTimeOfSunday(new Date());
	}
	
	/**
	 * 获取指定周的星期日日期23点时间
	 * 
	 * @param date
	 * @return
	 */
	public static String getTimeOfSunday(Date date) {
		return DateUtil.getSunday(date).concat(" 23:59:59");
	}
	
	/**
	 * 获取指定日期月份第一天的零点时间
	 * 
	 * @param date
	 * @return
	 */
	public static String getTimeOfMonthBegin(Date date) {
		return DateUtil.getDateOfMonthBegin(date).concat(" 00:00:00");
	}
	
	/**
	 * 获取指定日期月份第一天的零点时间
	 * 
	 * @return
	 */
	public static String getTimeOfMonthBegin() {
		return getTimeOfMonthBegin(new Date());
	}
	
	/**
	 * 获取指定日期月份最后一天的23点时间
	 * 
	 * @return
	 */
	public static String getTimeOfMonthEnd() {
		return getTimeOfMonthEnd(new Date());
	}
	
	/**
	 * 获取指定日期月份最后一天的23点时间
	 * 
	 * @param date
	 * @return
	 */
	public static String getTimeOfMonthEnd(Date date) {
		return getDateOfMonthEnd(date).concat(" 23:59:59");
	}
	
	/**
	 * 获取指定日期月份的最后一天
	 * 
	 * @param date
	 * @return
	 */
	public static String getDateOfMonthEnd(Date date) {
		return getCustomDay(-1,parse(getCustomMonth(1, getDateOfMonthBegin(date)),yyyy_MM_dd));
	}
	
	/**
	 * 获取当前时间的几小时后时间
	 * @param hour
	 * @return
	 */
	public  static Date getTimeByHour(int hour) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY) + hour);
		return calendar.getTime();
	}

	/**
	 * 获取以当月为基准的任意一个月的最后一天23点
	 * 
	 * @param i
	 *            :0表示当月,1表示下个月...
	 * @return strDate
	 */
	public static String getCustomMonthTime(int i) {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MONTH, i);
		return DateUtil.getTimeOfMonthEnd(calendar.getTime());
	}
	
	public static String getAcTypeWinPeriodKey(String period,String date) {
		String periodKey = null;
		if ("d".equals(period)) {
			// 按天
			periodKey = date.replace("-", "");
		} else if ("w".equals(period)) {
			// 按周
			periodKey = genMonday(date).replace("-", "");
		} else if ("m".equals(period)) {
			// 按月
			periodKey = getDateOfMonthBegin(parse(date,yyyyMMdd)).replace("-", "");
		}
		return periodKey;
	}
	

	
	/**
	 * 获取指定日期的周几
	 *  0 周日 , 1 周一 ,...6 周六
	 * @param date
	 *            util.Date日期
	 * @return int 日份
	 */
	public static int getWeekOfDate(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		if(1==cal.get(Calendar.DAY_OF_WEEK) ){
			return 7;
		}else{
			return cal.get(Calendar.DAY_OF_WEEK)-1;
		}
		 
	}
	
	/**
	 * 获取指定日期的小时
	 * 
	 * @param date
	 *            util.Date日期
	 * @return int 日份
	 */
	public static int getHourOfDate(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(Calendar.HOUR_OF_DAY);
	}
	
	/**
	 * 判断是否符合指定格式的日期
	 * 
	 * @param pattern
	 *            yyyy-MM-dd
	 * @param str
	 * @return
	 */
	public static boolean isDate(String pattern, String str) {
		String date = null;
		try {
			DateFormat df = new SimpleDateFormat(pattern);
			// df.setLenient(true);
			date = df.format(df.parse(str));
		} catch (Exception ex) {
			date = null;
		}
		return StringUtils.formatNULL(date) != null ? true : false;
	}
	
	/**
	 * 判断比较两个日期,返回0=相等;-1=firstDate在secondDate之前;1=firstDate在secondDate之后.
	 * 
	 * @param firstDate
	 * @param secondDate
	 * @return
	 */
	private static int compareDate(String firstDateStr, String secondDateStr) {
		int flag = 2;
		Date firstDate = null;
		Date secondDate = null;
		try {
			firstDate = parse(firstDateStr,yyyy_MM_dd);
			secondDate = parse(secondDateStr,yyyy_MM_dd);
			if (firstDate != null && secondDate != null) {
				flag = firstDate.compareTo(secondDate);
			}
		} catch (Exception ex) {
			flag = 2;
		}
		return flag;
	}
	
	/**
	 * 判断日期firstDate是否在secondDate之前,格式 2010-06-21.
	 * 
	 * @param firstDate
	 * @param secondDate
	 * @return
	 */
	public static boolean isBeforeDate(String firstDate, String secondDate) {
		return compareDate(firstDate, secondDate) == -1 ? true : false;
	}

	/**
	 * 判断日期firstDate是否在secondDate之后,格式 2010-06-21.
	 * 
	 * @param firstDate
	 * @param secondDate
	 * @return
	 */
	public static boolean isAfterDate(String firstDate, String secondDate) {
		return compareDate(firstDate, secondDate) == 1 ? true : false;
	}
	
	public static boolean isYesterday(String today, String yesterday) {
		Date todayDate = parse(today,yyyy_MM_dd);

		Date yesterdayDate = parse(yesterday,yyyy_MM_dd);
		Calendar instance = Calendar.getInstance();
		instance.setTime(yesterdayDate);
		instance.add(Calendar.DAY_OF_YEAR, 1);
		yesterdayDate = instance.getTime();
		
		String todayTime = getTime(todayDate.getTime(), yyyy_MM_dd);
		String yesterdayTime = getTime(yesterdayDate.getTime(), yyyy_MM_dd);

		return todayTime.equals(yesterdayTime);
	}
	
	public static int getSecondsBetweenDates(Date date1, Date date2) {
		Long timeDistance = date1.getTime() - date2.getTime();
		String timeDistenceStr = String.valueOf(timeDistance/1000) ;
		return Integer.parseInt(timeDistenceStr);
	}
	
	/**
	 * 两个日期相隔的天数   bigDate -littleDate
	 * @param bigDate 被减数
	 * @param littleDate 减数
	 * @return 只拿日期作比较   忽略时分秒
	 */
	public static long getDaysBetweenDates(Date bigDate, Date littleDate){
		String dateString1 =  DateUtil.format(bigDate, DateUtil.yyyy_MM_dd);
		String dateString2 =  DateUtil.format(littleDate, DateUtil.yyyy_MM_dd);
		long betweenTime = 0;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DateUtil.yyyy_MM_dd);
		try {
			Date parse1 = simpleDateFormat.parse(dateString1);
			Date parse2 = simpleDateFormat.parse(dateString2);
			betweenTime = (parse1.getTime() - parse2.getTime()) / (1000 * 60 * 60 * 24);
			return betweenTime;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

}
