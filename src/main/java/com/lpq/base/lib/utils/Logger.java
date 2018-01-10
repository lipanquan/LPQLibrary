package com.lpq.base.lib.utils;

import android.util.Log;

import com.lpq.base.lib.config.LibAppConfig;

/**
 * 功能：日志输出控制工具类 <br />
 * 作者：lipanquan on 2018/1/9 <br />
 * 邮箱：862321807@qq.cn <br />
 */
public final class Logger {

    public static void v(String tag, String msg) {
        if (LibAppConfig.IS_DEBUG)
            Log.v(tag, msg);
    }

    public static void d(String tag, String msg) {
        if (LibAppConfig.IS_DEBUG)
            Log.d(tag, msg);
    }

    public static void i(String tag, String msg) {
        if (LibAppConfig.IS_DEBUG)
            Log.i(tag, msg);
    }

    public static void w(String tag, String msg) {
        if (LibAppConfig.IS_DEBUG)
            Log.w(tag, msg);
    }

    public static void e(String tag, String msg) {
        if (LibAppConfig.IS_DEBUG)
            Log.e(tag, msg);
    }
}