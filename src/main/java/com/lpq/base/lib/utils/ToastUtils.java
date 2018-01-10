package com.lpq.base.lib.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * 功能：Toast 工具类
 * 作者：lipanquan on 2018/1/9 <br />
 * 邮箱：862321807@qq.cn <br />
 */
public class ToastUtils {

	/**
	 * 显示 短 Toast <br>
	 * 不需要再次调用 Toast show()方法
	 * 
	 * @param context
	 *            Context
	 * @param text
	 *            要显示的文字
	 */
	public static void showToastShort(Context context, String text) {
		Toast.makeText(context.getApplicationContext(), text, Toast.LENGTH_SHORT).show();
	}

	/**
	 * 显示 短 Toast <br>
	 * 不需要再次调用 Toast show()方法
	 * 
	 * @param context
	 *            Context
	 * @param strId
	 *            要显示的文字的id
	 */
	public static void showToastShort(Context context, int strId) {
		Toast.makeText(context.getApplicationContext()	, strId, Toast.LENGTH_SHORT).show();
	}

	/**
	 * 显示 长 Toast <br>
	 * 不需要再次调用 Toast show()方法
	 * 
	 * @param context
	 *            Context
	 * @param text
	 *            要显示的文字
	 */
	public static void showToastLong(Context context, String text) {
		Toast.makeText(context.getApplicationContext(), text, Toast.LENGTH_LONG).show();
	}

	/**
	 * 显示 长 Toast <br>
	 * 不需要再次调用 Toast show()方法
	 * 
	 * @param context
	 *            Context
	 * @param strId
	 *            要显示的文字id
	 */
	public static void showToastLong(Context context, int strId) {
		Toast.makeText(context.getApplicationContext(), strId, Toast.LENGTH_LONG).show();
	}

}