package com.lpq.base.lib.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 功能：格式化日期时间工具类 <br/>
 * 作者：lipanquan on 2018/1/9 <br />
 * 邮箱：862321807@qq.cn <br />
 */
public class DateFormat {

	private SimpleDateFormat ymdhmFormat, ymdhmsFormat, ymdFormat, ymdFormat2;

	private DateFormat() {
		ymdhmFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		ymdhmsFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		ymdFormat = new SimpleDateFormat("yyyy-MM-dd");
		ymdFormat2 = new SimpleDateFormat("yyyy/MM/dd");
	}

	private static DateFormat instance;

	public synchronized static DateFormat getInstance() {
		if (instance == null)
			instance = new DateFormat();
		return instance;
	}

	/**
	 * 获取当前时间
	 * 
	 * @return yyyy-MM-dd HH:mm
	 */
	public String getCurrentDate() {
		return ymdhmFormat.format(new Date());
	}
	

	/**
	 * 获取当前时间
	 * 
	 * @return yyyy-MM-dd HH:mm:ss
	 */
	public String getCurrentDate2() {
		return ymdhmsFormat.format(new Date());
	}

	/**
	 * 获取格式化后的日期
	 *
	 * @return yyyy-MM-dd
	 */
	public String getDate(long date) {
		return ymdFormat.format(new Date(date));
	}

	/**
	 * 获取格式化后的日期
	 *
	 * @return yyyy/MM/dd
	 */
	public String getDate2(long date) {
		return ymdFormat2.format(new Date(date));
	}

	/**
	 * 获取格式化后的日期
	 *
	 * @return yyyy-MM-dd
	 */
	public long getDateLong(String date) {
		try {
			Date dDate = ymdFormat.parse(date);
			return dDate.getTime();
		} catch (ParseException e) {
		}
		return 0;
	}
}
