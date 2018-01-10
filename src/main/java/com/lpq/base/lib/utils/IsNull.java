package com.lpq.base.lib.utils;

import java.util.List;

/**
 * 功能：判断是否为空 <br/>
 * Created by lipanquan on 2017/3/24.<br />
 * 作者：lipanquan on 2018/1/9 <br />
 * 邮箱：862321807@qq.cn <br />
 */
public final class IsNull {

    private IsNull() {
    }

    /**
     * 判断对象是否为null
     *
     * @param obj 要判断的对象
     * @return true 为空
     */
    @SuppressWarnings("rawtypes")
    public static boolean isNull(Object obj) {
        if (obj == null) {
            return true;
        } else if (obj instanceof String) {
            return isNullStr((String) obj);
        } else if (obj instanceof List) {
            return isNullSet((List) obj);
        } else if (obj instanceof Object[]) {
            return isNullArray((Object[]) obj);
        } else {
            return isNullObject(obj);
        }
    }

    /**
     * 判断字符串是否为空
     *
     * @param str 要判断的字符串
     * @return 空就返回true
     */
    private static boolean isNullStr(String str) {
        if (str == null)
            return true;
        if (str.length() == 0)
            return true;
        return "".equals(str);
    }

    /**
     * 判断对象是否为空
     *
     * @param obj 要判断的对象
     * @return 空就返回true
     */
    private static boolean isNullObject(Object obj) {
        return obj == null;
    }

    /**
     * 判断集合是否为空
     *
     * @param arr 要判断的集合
     * @return 空就或者size=0，返回true
     */
    private static boolean isNullSet(@SuppressWarnings("rawtypes") List arr) {
        return arr == null || arr.size() == 0;
    }

    /**
     * 判断数组是否为空
     *
     * @param array 要判断的数组
     * @return 空就或者length=0，返回true
     */
    private static boolean isNullArray(Object[] array) {
        return array == null || array.length == 0;
    }
}