package com.lpq.base.lib.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * 功能：保持配置信息的工具类 <br />
 * 作者：lipanquan on 2018/1/9 <br />
 * 邮箱：862321807@qq.cn <br />
 */
public final class SharedPreferencesUtils {

    /**
     * 私有构造（单例）
     *
     * @param context 上下文
     */
    private SharedPreferencesUtils(Context context) {
        sp = context.getApplicationContext().getSharedPreferences("setting", Context.MODE_PRIVATE);
    }

    /**
     * 本类对象
     */
    private static SharedPreferencesUtils instance;

    /**
     * SharedPreferences对象
     */
    private SharedPreferences sp;

    /**
     * 对外提供获取本类对象的方法
     *
     * @param context 上下文
     * @return SharedPreferences对象
     */
    public static SharedPreferencesUtils getInstance(Context context) {
        if (IsNull.isNull(instance)) {
            instance = new SharedPreferencesUtils(context.getApplicationContext());
        }
        return instance;
    }

    /**
     * 读取字符串
     *
     * @param key 键
     * @return String类型的值
     */
    public String getString(String key) {
        return sp.getString(key, "");
    }

    /**
     * 读取字符串
     *
     * @param key 键
     * @return String类型的值
     */
    public String getString(String key, String defalutValue) {
        return sp.getString(key, defalutValue);
    }

    /**
     * 保持字符串
     *
     * @param key   键
     * @param value 值
     */
    public void putString(String key, String value) {
        sp.edit().putString(key, value).commit();
    }

    /**
     * 读取布尔类型数据
     *
     * @param key 键
     * @return Boolean类型的值
     */
    public Boolean getBoolean(String key) {
        return sp.getBoolean(key, false);
    }

    /**
     * 读取布尔类型数据
     *
     * @param key      键
     * @param defValue 默认值
     * @return Boolean类型的值
     */
    public Boolean getBoolean(String key, boolean defValue) {
        return sp.getBoolean(key, defValue);
    }

    /**
     * 保存布尔类型的数据
     *
     * @param key   键
     * @param value 值
     */
    public void putBoolean(String key, Boolean value) {
        sp.edit().putBoolean(key, value).commit();
    }

    /**
     * 读取整型类型数据
     *
     * @param key 键
     * @return Int类型的值
     */
    public Integer getInt(String key) {
        return sp.getInt(key, 0);
    }

    /**
     * 读取整型类型数据
     *
     * @param key          键
     * @param defaultValue 默认值
     * @return Int类型的值
     */
    public Integer getInt(String key, int defaultValue) {
        return sp.getInt(key, defaultValue);
    }

    /**
     * 保存整型类型的数据
     *
     * @param key   键
     * @param value 值
     */
    public void putInt(String key, int value) {
        sp.edit().putInt(key, value).commit();
    }

    /**
     * 读取浮点型类型数据
     *
     * @param key 键
     * @return Float类型的值
     */
    public Float getFloat(String key) {
        return sp.getFloat(key, 0);
    }

    /**
     * 读取浮点型类型数据
     *
     * @param key          键
     * @param defaultValue 默认值
     * @return Float类型的值
     */
    public Float getFloat(String key, float defaultValue) {
        return sp.getFloat(key, defaultValue);
    }

    /**
     * 保存浮点型类型的数据
     *
     * @param key   键
     * @param value 值
     */
    public void putFloat(String key, float value) {
        sp.edit().putFloat(key, value).commit();
    }

    /**
     * 读取长整型类型数据
     *
     * @param key 键
     * @return Long类型的值
     */
    public Long getLong(String key) {
        return sp.getLong(key, 0);
    }

    /**
     * 保存长整型类型的数据
     *
     * @param key   键
     * @param value Long值
     */
    public void putLong(String key, Long value) {
        sp.edit().putLong(key, value).commit();
    }
}