package com.lpq.base.lib.adapter;

import android.app.Application;
import android.content.Context;
import android.support.v4.view.PagerAdapter;

import com.lpq.base.lib.utils.IsNull;
import com.lpq.base.lib.utils.Logger;
import com.lpq.base.lib.utils.SharedPreferencesUtils;
import com.lpq.base.lib.utils.SystemOut;
import com.lpq.base.lib.utils.ToastUtils;

public abstract class LibPagerAdapter extends PagerAdapter {

	/**
	 * 短时间显示土司
	 * 
	 * @param msg
	 *            要显示的文字
	 * @param context
	 */
	public void showToastShort(Context context, String msg) {
		ToastUtils.showToastShort(getApplication(context), msg);
	}

	/**
	 * 短时间显示土司
	 * 
	 * @param context
	 *            上下文对象
	 * 
	 * @param msgId
	 *            要显示的文字的id
	 */
	public void showToastShort(Context context, int msgId) {
		ToastUtils.showToastShort(getApplication(context), msgId);
	}

	/**
	 * 长时间显示土司
	 * 
	 * @param context
	 *            上下文对象
	 * 
	 * @param msg
	 *            要显示的文字
	 */
	public void showToastLong(Context context, String msg) {
		ToastUtils.showToastLong(getApplication(context), msg);
	}

	/**
	 * 长时间显示土司
	 * 
	 * @param context
	 *            上下文对象
	 * 
	 * @param msgId
	 *            要显示的文字id
	 */
	public void showToastLong(Context context, int msgId) {
		ToastUtils.showToastLong(getApplication(context), msgId);
	}

	/**
	 * 判断对象是否为空
	 * 
	 * @param obj
	 *            要判断的对象
	 * @return 空就返回true
	 */
	protected boolean isNull(Object obj) {
		return IsNull.isNull(obj);
	}

	// /**
	// * 判断字符串是否为空
	// *
	// * @param str
	// * 要判断的字符串
	// * @return 空就返回true
	// */
	// protected boolean isNullStr(String str) {
	// return IsNull.isNullStr(str);
	// }
	//
	// /**
	// * 判断对象是否为空
	// *
	// * @param obj
	// * 要判断的对象
	// * @return 空就返回true
	// */
	// protected boolean isNullObject(Object obj) {
	// return IsNull.isNullObject(obj);
	// }
	//
	// /**
	// * 判断集合是否为空
	// *
	// * @param arr
	// * 要判断的集合
	// * @return 空就或者size=0，返回true
	// */
	// protected boolean isNullSet(@SuppressWarnings("rawtypes") List arr) {
	// return IsNull.isNullSet(arr);
	// }
	//
	// /**
	// * 判断数组是否为空
	// *
	// * @param array
	// * 要判断的数组
	// * @return 空就或者length=0，返回true
	// */
	// protected boolean isNullArray(Object[] array) {
	// return IsNull.isNullArray(array);
	// }

	/**
	 * 读取字符串
	 * 
	 * @param context
	 *            上下文对象
	 * 
	 * @param key
	 *            键
	 * @return String类型的值
	 */
	public String getString(Context context, String key) {
		return SharedPreferencesUtils.getInstance(getApplication(context))
				.getString(key);
	}

	/**
	 * 保持字符串
	 * 
	 * @param context
	 *            上下文对象
	 * 
	 * @param key
	 *            键
	 * @param value
	 *            值
	 */
	public void putString(Context context, String key, String value) {
		SharedPreferencesUtils.getInstance(getApplication(context)).putString(
				key, value);
	}

	/**
	 * 读取布尔类型数据
	 * 
	 * @param context
	 *            上下文对象
	 * 
	 * @param key
	 *            键
	 * @return Boolean类型的值
	 */
	public Boolean getBoolean(Context context, String key) {
		return SharedPreferencesUtils.getInstance(getApplication(context))
				.getBoolean(key, false);
	}

	/**
	 * 读取布尔类型数据
	 * 
	 * 
	 * @param context
	 *            上下文对象
	 * @param key
	 *            键
	 * @param defValue
	 *            默认值
	 * @return Boolean类型的值
	 */
	public Boolean getBoolean(Context context, String key, boolean defValue) {
		return SharedPreferencesUtils.getInstance(getApplication(context))
				.getBoolean(key, defValue);
	}

	/**
	 * 读取布尔类型数据(设置声音界面)
	 * 
	 * @param context
	 *            上下文对象
	 * 
	 * @param key
	 *            键
	 * @return Boolean类型的值
	 */
	public Boolean getVoiceBoolean(Context context, String key) {
		return SharedPreferencesUtils.getInstance(getApplication(context))
				.getBoolean(key, true);
	}

	/**
	 * 保存布尔类型的数据
	 * 
	 * @param context
	 *            上下文对象
	 * 
	 * @param key
	 *            键
	 * @param value
	 *            值
	 */
	public void putBoolean(Context context, String key, Boolean value) {
		SharedPreferencesUtils.getInstance(getApplication(context)).putBoolean(
				key, value);
	}

	/**
	 * 读取整型类型数据
	 * 
	 * @param key
	 *            键
	 * @return Int类型的值
	 */
	public Integer getInt(Context context, String key) {
		return SharedPreferencesUtils.getInstance(getApplication(context))
				.getInt(key);
	}

	/**
	 * 保存整型类型的数据
	 * 
	 * @param context
	 *            上下文对象
	 * 
	 * @param key
	 *            键
	 * @param value
	 *            值
	 */
	public void putInt(Context context, String key, Integer value) {
		SharedPreferencesUtils.getInstance(getApplication(context)).putInt(key,
				value);
	}

	/**
	 * 读取浮点型类型数据
	 * 
	 * @param context
	 *            上下文对象
	 * 
	 * @param key
	 *            键
	 * @return Float类型的值
	 */
	public Float getFloat(Context context, String key) {
		return SharedPreferencesUtils.getInstance(getApplication(context))
				.getFloat(key);
	}

	/**
	 * 保存浮点型类型的数据
	 * 
	 * @param context
	 *            上下文对象
	 * 
	 * @param key
	 *            键
	 * @param value
	 *            值
	 */
	public void putFloat(Context context, String key, Float value) {
		SharedPreferencesUtils.getInstance(getApplication(context)).putFloat(
				key, value);
	}

	/**
	 * 读取长整型类型数据
	 * 
	 * @param context
	 *            上下文对象
	 * 
	 * @param key
	 *            键
	 * @return Long类型的值
	 */
	public Long getLong(Context context, String key) {
		return SharedPreferencesUtils.getInstance(getApplication(context))
				.getLong(key);
	}

	/**
	 * 保存长整型类型的数据
	 * 
	 * @param context
	 *            上下文对象
	 * 
	 * @param key
	 *            键
	 * @param value
	 *            Long值
	 */
	public void putLong(Context context, String key, Long value) {
		SharedPreferencesUtils.getInstance(getApplication(context)).putLong(
				key, value);
	}

	/**
	 * v打印日志
	 * 
	 * @param tag
	 *            标志
	 * @param msg
	 *            值
	 */
	public void v(String tag, String msg) {
		Logger.v(tag, msg);
	}

	/**
	 * d打印日志
	 * 
	 * @param tag
	 *            标志
	 * @param msg
	 *            值
	 */
	public void d(String tag, String msg) {
		Logger.d(tag, msg);
	}

	/**
	 * i打印日志
	 * 
	 * @param tag
	 *            标志
	 * @param msg
	 *            值
	 */
	public void i(String tag, String msg) {
		Logger.i(tag, msg);
	}

	/**
	 * w打印日志
	 * 
	 * @param tag
	 *            标志
	 * @param msg
	 *            值
	 */
	public void w(String tag, String msg) {
		Logger.w(tag, msg);
	}

	/**
	 * e打印日志
	 * 
	 * @param tag
	 *            标志
	 * @param msg
	 *            值
	 */
	public void e(String tag, String msg) {
		Logger.e(tag, msg);
	}

	/**
	 * System.out.println打印日志
	 * 
	 * @param msg
	 *            日志内容
	 */
	public void syso(String msg) {
		SystemOut.sysoString(msg);
	}

	/**
	 * 获取application对象
	 * 
	 * @param context
	 *            上下文
	 * @return application对象
	 */
	public Application getApplication(Context context) {
		return (Application) context.getApplicationContext();
	}

	/**
	 * 获取资源id对应的颜色
	 *
	 * @param colorRseId 资源id
	 * @param context    上下文
	 * @return 资源id对应的颜色
	 */
	public int getResColor(Context context, int colorRseId) {
		return context.getResources().getColor(colorRseId);
	}

	/**
	 * 获取资源id对应的字符串
	 *
	 * @param stringRseId 资源id
	 * @param context     上下文
	 * @return 资源id对应的字符串
	 */
	public String getResString(Context context, int stringRseId) {
		return context.getResources().getString(stringRseId);
	}
}
