package com.lpq.base.lib.inf;

import android.content.Intent;
import android.support.annotation.ColorRes;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.view.View;

/**
 * 功能：公用功能接口 <br />
 * 作者：lipanquan on 2018/1/15 <br />
 * 邮箱：lipanquan@a-eye.cn <br />
 */
public interface IPublicInf {

    /**
     * 获取软键盘的状态
     *
     * @return 若返回true，则表示输入法打开
     */
    boolean getInputMethodState();

    /**
     * 隐藏键盘
     */
    void closeKeyboard();

    /**
     * 开启软键盘
     */
    void openKeyboard();

    /**
     * 显示控件
     *
     * @param view 要显示的控件
     */
    void setViewVisible(@NonNull View view);

    /**
     * 隐藏控件
     *
     * @param view 要隐藏的控件
     */
    void setViewGone(@NonNull View view);

    /**
     * 启动activity，伴随动画是进入动画（当前activity从右向左移出，要启动的activity从右向左进入）
     *
     * @param intent
     */
    void startEnterActivity(Intent intent, boolean isFinish);

    /**
     * 启动activity，伴随动画是进入动画（当前activity从右向左移出，要启动的activity从右向左进入）
     *
     * @param intent Intent
     */
    void startEnterActivity(Intent intent);

    /**
     * 启动activity，伴随动画是进入动画（当前activity从右向左移出，要启动的activity从右向左进入）
     *
     * @param cls      Class要启动的类的字节码对象
     * @param isFinish 是否关闭当前Activity
     */
    void startEnterActivity(Class cls, boolean isFinish);

    /**
     * 启动activity，伴随动画是进入动画（当前activity从右向左移出，要启动的activity从右向左进入）
     *
     * @param cls Class要启动的类的字节码对象
     */
    void startEnterActivity(Class cls);

    /**
     * 启动activity，伴随动画是退出动画（当前activity从左向右移出，另外一个activity从左向右进入）
     *
     * @param intent   Intent
     * @param isFinish 是否关闭当前Activity
     */
    void startExitActivity(Intent intent, boolean isFinish);

    /**
     * 启动activity，伴随动画是退出动画（当前activity从左向右移出，另外一个activity从左向右进入）
     *
     * @param intent Intent
     */
    void startExitActivity(Intent intent);

    /**
     * 启动activity，伴随动画是退出动画（当前activity从左向右移出，另外一个activity从左向右进入）
     *
     * @param cls      Class要关闭的类的字节码对象
     * @param isFinish 是否关闭当前Activity
     */
    void startExitActivity(Class cls, boolean isFinish);

    /**
     * 启动activity，伴随动画是退出动画（当前activity从左向右移出，另外一个activity从左向右进入）
     *
     * @param cls Class要关闭的类的字节码对象
     */
    void startExitActivity(Class cls);

    /**
     * 退出当前activity，伴随动画是退出动画（当前activity从左向右移出，另外一个activity从左向右进入）
     */
    void startExitActivity();

    /**
     * 短时间显示土司
     *
     * @param msg 要显示的文字
     */
    void showToastShort(String msg);

    /**
     * 短时间显示土司
     *
     * @param msgId 要显示的文字的id
     */
    void showToastShort(@StringRes int msgId);

    /**
     * 短时间显示土司（资源id + str）
     *
     * @param msgId 要显示的文字的资源id
     * @param str   要显示的文字
     */
    void showToastShort(@StringRes int msgId, String str);

    /**
     * 短时间显示土司（资源id + str）
     *
     * @param msgId 要显示的文字的资源id
     * @param str   要显示的文字
     */
    void showToastShort(@StringRes int msgId, @StringRes int str);

    /**
     * 长时间显示土司
     *
     * @param msg 要显示的文字
     */
    void showToastLong(String msg);

    /**
     * 长时间显示土司
     *
     * @param msgId 要显示的文字id
     */
    void showToastLong(@StringRes int msgId);

    /**
     * 长时间显示土司（资源id + str）
     *
     * @param msgId 要显示的文字的资源id
     * @param str   要显示的文字
     */
    void showToastLong(@StringRes int msgId, String str);

    /**
     * 长时间显示土司（资源id + str）
     *
     * @param msgId 要显示的文字的资源id
     * @param str   要显示的文字
     */
    void showToastLong(@StringRes int msgId, @StringRes int str);

    /**
     * 判断对象是否为空
     *
     * @param obj 要判断的对象
     * @return 空就返回true
     */
    boolean isNull(Object obj);

    /**
     * 判断对象非空
     *
     * @param obj 要判断的对象
     * @return 非空就返回true
     */
    boolean isNotNull(Object obj);

    /**
     * 获取String资源对应的字符串
     *
     * @param id String资源id
     * @return String资源对应的字符串
     */
    String getResString(@StringRes int id);

    /**
     * 获取String资源对应的字符串
     *
     * @param id         String资源id
     * @param formatArgs formatArgs
     * @return String资源对应的字符串
     */
    String getResString(@StringRes int id, Object... formatArgs);

    /**
     * 获取Color资源对应的颜色值
     *
     * @param id Color资源id
     * @return Color资源对应的颜色值
     */
    int getResColor(@ColorRes int id);

    /**
     * 读取字符串
     *
     * @param key 键
     * @return String类型的值
     */
    String getString(String key);

    /**
     * 保持字符串
     *
     * @param key   键
     * @param value 值
     */
    void putString(String key, String value);

    /**
     * 读取布尔类型数据
     *
     * @param key 键
     * @return Boolean类型的值
     */
    boolean getBoolean(String key);

    /**
     * 读取布尔类型数据
     *
     * @param key      键
     * @param defValue 默认值
     * @return Boolean类型的值
     */
    boolean getBoolean(String key, boolean defValue);

    /**
     * 保存布尔类型的数据
     *
     * @param key   键
     * @param value 值
     */
    void putBoolean(String key, Boolean value);

    /**
     * 读取整型类型数据
     *
     * @param key 键
     * @return Int类型的值
     */
    int getInt(String key);

    /**
     * 保存整型类型的数据
     *
     * @param key   键
     * @param value 值
     */
    void putInt(String key, Integer value);

    /**
     * 读取浮点型类型数据
     *
     * @param key 键
     * @return Float类型的值
     */
    float getFloat(String key);

    /**
     * 保存浮点型类型的数据
     *
     * @param key   键
     * @param value 值
     */
    void putFloat(String key, Float value);

    /**
     * 读取长整型类型数据
     *
     * @param key 键
     * @return Long类型的值
     */
    long getLong(String key);

    /**
     * 保存长整型类型的数据
     *
     * @param key   键
     * @param value Long值
     */
    void putLong(String key, Long value);

    /**
     * v打印日志
     *
     * @param tag 标志
     * @param msg 值
     */
    void v(String tag, String msg);

    /**
     * d打印日志
     *
     * @param tag 标志
     * @param msg 值
     */
    void d(String tag, String msg);

    /**
     * i打印日志
     *
     * @param tag 标志
     * @param msg 值
     */
    void i(String tag, String msg);

    /**
     * w打印日志
     *
     * @param tag 标志
     * @param msg 值
     */
    void w(String tag, String msg);

    /**
     * e打印日志
     *
     * @param tag 标志
     * @param msg 值
     */
    void e(String tag, String msg);

    /**
     * System.out.println打印日志
     *
     * @param msg 日志内容
     */
    void syso(String msg);
}