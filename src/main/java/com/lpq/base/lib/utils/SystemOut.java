package com.lpq.base.lib.utils;

import com.lpq.base.lib.config.LibAppConfig;

/**
 * 功能：输出到控制台的工具类 <br />
 * 作者：lipanquan on 2018/1/9 <br />
 * 邮箱：862321807@qq.cn <br />
 */
public final class SystemOut {

    /**
     * 把字符串输出到控制台
     *
     * @param msg 要输出的字符串
     */
    public static void sysoString(String msg) {
        if (LibAppConfig.IS_DEBUG)
            System.out.println(msg);
    }

}